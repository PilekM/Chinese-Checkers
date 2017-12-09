import java.util.*;

public class Game {
	private Board board;
	private Referee referee;
	private Map<Integer,Player> mapOfPlayers;
	private boolean availableColors[];
	private int GameNumber;
	private GameMode gameMode;
  Game(int players, int rows, int hostID, int GameNumber){
  	board = new Board(rows);
  	referee = new Referee();
  	mapOfPlayers = new HashMap<Integer,Player>();
  	availableColors = new boolean[players];
  	this.GameNumber=GameNumber;
  	switch(players){
		case 2:
		 setGameMode(new TwoPlayersMode());
		 break;
		case 3:
		 setGameMode(new ThreePlayersMode());
		 break;
		case 4:
		 setGameMode(new FourPlayersMode());
		 break;
		case 6:
		 setGameMode(new SixPlayersMode());
		 break;
		default:
			//Ewentualne zachowanie w przypadku podania błędnej liczby ale tak nie bedzie bo to sprawdzi sie wwczesniej
	}
  	for(boolean bool : availableColors){
  		bool = true;
	  }
  	gameMode.addPlayer(hostID,this);
  }

   void deletePlayer(int ID){
    		availableColors[mapOfPlayers.get(ID).Color-1] = true;
    		mapOfPlayers.remove(ID);
   }


  void letHimMove(int ID){
  	mapOfPlayers.get(ID).canMove = true;
  }

  private int generateFirstPlayer(){
  	Random generator = new Random();
  	return (generator.nextInt()*(mapOfPlayers.size()-1))+1;
  }

  void startGame(){

  }

  public boolean[] getAvailableColors() {
		return availableColors;
  }

  public Map<Integer, Player> getMapOfPlayers() {
		return mapOfPlayers;
  }

  public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
  }
}

