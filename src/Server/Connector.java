package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Connector{

    static Game game=null;

    public static void main(String args[])throws Exception{
        int port = 1997;


        int counter = 0;
        Socket clientSocket;
        ServerSocket mySocket = new ServerSocket(port);
        try {
            while (true) {
                clientSocket = mySocket.accept();
                new Thread(new Player(0, counter++, clientSocket )).start();

            }
        }
        finally {
            mySocket.close();
        }

    }



}
