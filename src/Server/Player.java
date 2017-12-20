package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Player implements Runnable{
    int Color;
    int ID;
    boolean canMove=false;
    private Socket socket;
    String name;
    private PrintWriter out;
    private BufferedReader in;
    private String command;
    private String commandParts[];
    private Game gierka;
    int Field;
    static int gameCounter;
    boolean isReady;
    static Map<Integer,Game> mapOfGames=new HashMap<>();
    private Checker[] checkerSet;


    Player(int color, int ID, Socket connection){
        this.isReady = false;
        this.Color = color;
        this.ID = ID;
        this.socket = connection;
        gameCounter = 0;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    void setName(String name){
        this.name = name;
    }

    void send(String outputCommand){
        out.println(outputCommand);
    }

    public void setCheckerSet(int color, int rows) {
        int amount = 0;
        int newX;
        int newY;
        for(int i = 1; i <= rows; i++){
            amount+=i;
        }
        this.checkerSet = new Checker[amount];
        int counter=0;
        switch(color) {
            case(1):
                newX = 3*rows;
                newY = 0;
                for(int i=0;i<rows;i++)
                {
                    for(int j=0;j<=i;j++)
                    {
                        checkerSet[counter++].setColor(color);
                        checkerSet[counter++].setX(newX-i+2*j);
                        checkerSet[counter++].setY(newY+i*2);
                    }
                }
                break;
            case(2):
                for(int i=0;i<rows;i++)
                {
                    for(int j=0;j<=i;j++)
                    {
                        checkerSet[counter++].setColor(color);
                        checkerSet[counter++].setX(rows-1-i+2*j);
                        checkerSet[counter++].setY(2*(2*rows-1-i));
                    }
                }
                break;
            case(3):
                newX = rows-1;
                newY = 4*rows + 2;
                for(int i=0;i<rows;i++)
                {
                    for(int j=0;j<=i;j++)
                    {
                        checkerSet[counter++].setColor(color);
                        checkerSet[counter++].setX(newX-i+2*j);
                        checkerSet[counter++].setY(newY+i*2);
                    }
                }
                break;
            case(4):
                for(int i=0;i<rows;i++)
                {
                    for(int j=0;j<=i;j++)
                    {
                        checkerSet[counter++].setColor(color);
                        checkerSet[counter++].setX(5*rows+1-i+2*j);
                        checkerSet[counter++].setY(2*(2*rows-1-i));
                    }
                }
                break;
            case(5):
                newX = 5*rows + 1;
                newY = 4*rows + 2;
                for(int i=0;i<rows;i++)
                {
                    for(int j=0;j<=i;j++)
                    {
                        checkerSet[counter++].setColor(color);
                        checkerSet[counter++].setX(newX-i+2*j);
                        checkerSet[counter++].setY(newY+i*2);
                    }
                }
                break;
            case(6):
                for(int i=0;i<rows;i++)
                {
                    for(int j=0;j<=i;j++)
                    {
                        checkerSet[counter++].setColor(color);
                        checkerSet[counter++].setX(3*rows-i+2*j);
                        checkerSet[counter++].setY(2*(2*rows-1-i));
                    }
                }
                break;
        }
    }

    public Checker[] getCheckerSet(){
        return this.checkerSet;
    }

    @Override
    public void run() {
        try {
            command = in.readLine();
            commandParts = command.split("~");
            switch(commandParts[0]){
                case("STARTGAME"):
                    gameCounter++;
                    gierka = new Game(Integer.parseInt(commandParts[1]),Integer.parseInt(commandParts[2]),this,gameCounter);
                    mapOfGames.put(gameCounter,gierka);
                    send("GAMECREATED~"+gameCounter);
                    break;
                case("SETNAME"):
                    setName(commandParts[1]);
                    break;
                case("JOINGAME"):
                    gierka = mapOfGames.get(commandParts[1]);
                    gierka.getGameMode().addPlayer(gierka,this);
                    break;
                case("MOVE"):
                    if(canMove)
                    gierka.getReferee().validateMove(gierka.getBoard().getFields(),Integer.parseInt(commandParts[1]),Integer.parseInt(commandParts[2]));
                    break;
                case("CHECKMOVE"):
                    if(canMove)
                    gierka.getReferee().markMovable(gierka.getBoard().getFields(),Integer.parseInt(commandParts[1]),Integer.parseInt(commandParts[2]), this.checkerSet);
                    break;
                case("LEFTTURN"):
                    this.canMove = false;
                    break;
                case("EXITCLIENT"):
                    if(gierka != null){
                        gierka.deletePlayer(this);
                    }
                    break;
                case("SETREADY"):
                    this.isReady = true;
                    break;
                case("SETUNREADY"):
                    this.isReady = false;
                    break;

            }
        }
        catch(IOException e){
            System.out.println(e);
        }





    }

}
