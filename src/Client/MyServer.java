package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyServer {
    Socket clientSocket;
    BufferedReader in;
    PrintStream out;

    private MyServer instance;

    public MyServer() implements Runnable{
        try {
            clientSocket = new Socket("localhost",1997);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MyServer getInstance(){
        if (this.instance == null)
            synchronized (MyServer.class) {
                if (instance == null)
                    instance = new MyServer();
            }
        return instance;
    }

    public void send(String command) {
        out.println(command);
    }

    @Override
    public void run(){

    }
}

