package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import static Server.Connector.game;


public class Player implements Runnable {
    int Color;
    //int ID;
    boolean canMove = false;
    private Socket socket;
    String name;
    private PrintWriter out;
    private BufferedReader in;
    private String command;
    private String commandParts[];
    private Game gierka;
    static int gameCounter;
    boolean isReady;
    static Map<Integer, Game> mapOfGames = new HashMap<>();
    private Checker[] checkerSet;
    private int howManyinBase = 0;
    private boolean active = true;


    Player(int color, int ID, Socket connection) {
        this.isReady = false;
        this.Color = color;
        //this.ID = ID;
        this.socket = connection;
        gameCounter = 0;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void setName(String name) {
        this.name = name;
    }

    void send(String outputCommand) {
        out.println(outputCommand);
    }

    public void setCheckerSet(int color, int rows, Board board) {
        int amount = 0;
        int newX;
        int newY;
        Field[][] fields = board.getFields();
        for (int i = 1; i <= rows; i++) {
            amount += i;
        }
        System.out.println(color +" "+ rows);
        this.checkerSet = new Checker[amount];
        int counter = 0;
        switch (color) {
            case (1):
                newX = 3 * rows;
                newY = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j <= i; j++) {
                        fields[newX - i + 2 * j][newY + i * 2].changeChecker(color);
                        this.checkerSet[counter] = new Checker(color,newX - i + 2 * j,newY + i * 2);
                        counter++;
                    }
                }
                break;
            case (2):
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j <= i; j++) {
                        fields[rows - 1 - i + 2 * j][2 * (2 * rows - 1 - i)].changeChecker(color);
                        this.checkerSet[counter] = new Checker(color,rows - 1 - i + 2 * j,2 * (2 * rows - 1 - i));
                        counter++;
                    }
                }
                break;
            case (3):
                newX = rows - 1;
                newY = 4 * rows + 2;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j <= i; j++) {
                        fields[newX - i + 2 * j][newY + i * 2].changeChecker(color);
                        this.checkerSet[counter] = new Checker(color,newX - i + 2 * j,newY + i * 2);
                        counter++;
                    }
                }
                break;
            case (4):
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j <= i; j++) {
                        fields[5 * rows + 1 - i + 2 * j][2 * (2 * rows - 1 - i)].changeChecker(color);
                        this.checkerSet[counter] = new Checker(color,5 * rows + 1 - i + 2 * j,2 * (2 * rows - 1 - i) );
                        counter++;
                    }
                }
                break;
            case (5):
                newX = 5 * rows + 1;
                newY = 4 * rows + 2;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j <= i; j++) {
                        fields[newX - i + 2 * j][newY + i * 2].changeChecker(color);
                        this.checkerSet[counter] = new Checker(color,newX - i + 2 * j,newY + i * 2);
                        counter++;
                    }
                }
                break;
            case (6):
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j <= i; j++) {
                        fields[3 * rows - i + 2 * j][2 * (2 * rows - 1 - i)].changeChecker(color);
                        this.checkerSet[counter] = new Checker(color,3 * rows - i + 2 * j,2 * (2 * rows - 1 - i));
                        counter++;
                    }
                }
                break;
        }
    }

    public Checker[] getCheckerSet() {
        return this.checkerSet;
    }

    public int getHowManyinBase() {
        return this.howManyinBase;
    }

    public String getName(){
        return this.name;
    }

    public void setHowManyinBase(int i) {
        this.howManyinBase = i;
    }

    @Override
    public synchronized void run() {

        while (active) {

            try {
                command = in.readLine();
                commandParts = command.split("~");
                System.out.println(commandParts[0]);
                switch (commandParts[0]) {
                    case("STARTGAME"):
                        if(game.getMapOfPlayers().size()==game.getAvailableColors().length&&game.isEveryoneReady()){
                            game.startGame();
                        }
                        else
                            send("NOTREADY");
                        break;
                    case("GIVEROWS"):
                        send(String.valueOf(game.getRows()));
                        break;
                    case ("CREATEGAME"):
                        System.out.println("czesc poczatek");
                        gameCounter++;
                        game = new Game(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]), this, gameCounter);
                        gierka = game;
                        mapOfGames.put(gameCounter, gierka);
                        System.out.println("czesc koniec");
                        //send("GAMECREATED~" + gameCounter);
                        break;
                    case ("SETNAME"):
                        setName(commandParts[1]);
                        System.out.println(this.name);
                        break;
                    case ("JOINGAME"):
                        gierka = game;
                        game.getGameMode().addPlayer(gierka, this);
                        break;
                    case ("SHOWGAME"):
                        if (game == null) {
                            send("BRAK");
                            System.out.println("wysyłam nullka");
                        } else {
                            String command0 = String.valueOf(game.getNumberofPlayer());
                            String command1 = String.valueOf(game.getMapOfPlayers().size());
                            send(command0 + "~" + command1);
                        }
                        break;
                    case("REFRESH"):
                        send("REPAINT"+game.getAllNames());
                        break;
                    case ("MOVE"):
                        if (canMove) {
                            gierka.getReferee().validateMove(gierka.getBoard().getFields(), Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]), this);
                            this.canMove = false;
                        }
                        break;
                    case ("CHECKMOVE"):
                        if (canMove)
                            gierka.getReferee().markMovable(gierka.getBoard().getFields(), Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]), this.checkerSet);
                        break;
                    case ("LEFTTURN"):
                        this.canMove = false;
                        break;
                    case ("EXITCLIENT"):
                        if (gierka != null) {
                            gierka.deletePlayer(this);
                        }
                        active=false;
                        break;
                    case ("SETREADY"):
                        this.isReady = true;
                        break;
                    case ("SETUNREADY"):
                        this.isReady = false;
                        break;

                }
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}
