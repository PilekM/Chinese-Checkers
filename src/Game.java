import java.util.*;

public class Game {
	private Board board;
	private Referee referee;
	private Map<Integer,Player> mapOfPlayers;
	private List<Player> gameQueue;
	private Integer[] order;
	private boolean availableColors[];
	private int GameNumber;
	private GameMode gameMode;
  Game(int players, int rows, int hostID, int GameNumber){
  	board = new Board(rows);
  	referee = new Referee();
  	mapOfPlayers = new HashMap<Integer,Player>();
  	availableColors = new boolean[players];
  	gameQueue = new ArrayList<Player>();
  	order = new Integer[]{1,4,5,6,3,2};
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
    		for(Player player:gameQueue){
    			if(player.Color==mapOfPlayers.get(ID).Color){
    				gameQueue.remove(player);
				}
			}
    		mapOfPlayers.remove(ID);
   }


  void letHimMove(int i){
  	for (Player player : gameQueue){
  		player.canMove=false;
	}
  	gameQueue.get(i).canMove = true;
  }

  private int generateFirstPlayer(){
  	Random generator = new Random();
  	int player;
  	while(true) {
		player = (generator.nextInt() * (mapOfPlayers.size() - 1)) + 1;
		if (availableColors[player]==false){
			return player;
		}
	 }
  }
	 private void setPlayersOrder(){
  	  int  firstPlayer = generateFirstPlayer();
  	  int counter;
  	  for(counter=0;counter<6;counter++){
  	  	if(firstPlayer==order[counter]){
  	  		break;
		  }
	  }

  	  for(int i=counter;i<availableColors.length;i++){
  	  	if(availableColors[order[counter]-1]==false){
  	  		for(Map.Entry<Integer,Player> entry: mapOfPlayers.entrySet()){
              if(entry.getValue().Color==order[counter]){
              	gameQueue.add(entry.getValue());
			  }
			}
		}
	  }
	  for(int i=0;i<counter;i++){
	   if(availableColors[order[counter]-1]==false){
		for(Map.Entry<Integer,Player> entry: mapOfPlayers.entrySet()){
			if(entry.getValue().Color==order[counter]){
				gameQueue.add(entry.getValue());
			}
		}
	   }
  	  }
	}
  void startGame(){
  	int counter = 0;
  	setPlayersOrder();
  	while(!referee.checkWin(this)){
  		letHimMove(counter%gameQueue.size());
  		while(//koniectura){
  			referee.markMovable(board,);
		}
	}
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

