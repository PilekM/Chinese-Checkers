import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector{

    public static void main()throws Exception{
        int port = 1997;
        ServerSocket mySocket = new ServerSocket(port);
        try {
            while (true) {
                new Handler(mySocket.accept()).start();

            }
        }
        finally {
            mySocket.close();
        }

    }



}
