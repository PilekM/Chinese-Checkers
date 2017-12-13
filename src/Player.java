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
                    gierka.getReferee().markMovable(gierka.getBoard().getFields(),Integer.parseInt(commandParts[1]),Integer.parseInt(commandParts[2]));
                    break;
                case("LEFTTURN"):
                    break;
                case("EXITCLIENT"):
                    if(gierka!=null){
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
