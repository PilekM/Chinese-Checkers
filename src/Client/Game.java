package Client;

import java.util.Map;
import static Client.Client.server;

public class Game {
    private Board board;
    private Map<Integer, Player> mapOfPlayers; //mozliwe ze wystarczy <Int,String> łączący kolor z nazwą gracza

    public Game(int rows,int players){
        board = new Board(rows);
    }

    public Board getBoard() {
        return board;
    }
}
