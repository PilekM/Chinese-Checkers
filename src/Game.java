import java.util.*;

public class Game {
	private Board board;
	private Referee referee;
	private Map<Integer, Player> mapOfPlayers;
	private Integer[] order;
	private boolean availableColors[];
	private int GameNumber;
	private GameMode gameMode;

	Game(int players, int rows, Player player, int GameNumber) {
		board = new Board(rows);
		referee = new Referee();
		mapOfPlayers = new HashMap<Integer, Player>();
		availableColors = new boolean[players];
		this.GameNumber = GameNumber;
		switch (players) {
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
		for (boolean bool : availableColors) {
			bool = true;
		}
		gameMode.setOrder(this);
		gameMode.addPlayer(this, player);
		this.GameNumber = GameNumber;
		this.initializeGame();
	}

	void deletePlayer(Player player) {
		availableColors[mapOfPlayers.get(player).Color - 1] = true;
		mapOfPlayers.remove(player);
	}


	private Player letHimMove(int i) {
		for (Map.Entry<Integer, Player> entry : mapOfPlayers.entrySet()) {
			entry.getValue().canMove = false;
		}
		mapOfPlayers.get(i).canMove = true;
		return mapOfPlayers.get(i);
	}

	private int generateFirstPlayer(Integer[] order) {
		Random generator = new Random();
		int counter = generator.nextInt(order.length);
		return order[counter];
	}

	private int setPlayersOrder() {
		int firstPlayer;
		int counter;

		firstPlayer = generateFirstPlayer(this.order);
		for (counter = 0; counter < order.length; counter++) {
			if (firstPlayer == order[counter]) {
				break;
			}
		}
		return order[counter];
  	/*  for(int i=counter;i<availableColors.length;i++){
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
  	  }*/
	}
	private void initializeGame(){
		while(mapOfPlayers.size()!=0){
			if(mapOfPlayers.size()==availableColors.length&&isEveryoneReady()){
				this.startGame();
				break;
			}

		}
	}


	private void startGame() {
		int counter = 0;
		setPlayersOrder();
		while (!referee.checkWin(this)) {
			Player turnPlayer = letHimMove(counter % mapOfPlayers.size());
			while (turnPlayer.canMove) {

			}
		}
	}

	public boolean[] getAvailableColors() {
		return this.availableColors;
	}

	public Map<Integer, Player> getMapOfPlayers() {
		return this.mapOfPlayers;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public GameMode getGameMode() {
		return this.gameMode;
	}

	public void setOrder(Integer[] order) {
		this.order = order;
	}

	public Referee getReferee() {
		return this.referee;
	}

	public Board getBoard() {
		return this.board;
	}

	private boolean isEveryoneReady() {
		for (Map.Entry<Integer, Player> entry : mapOfPlayers.entrySet()) {
			if (entry.getValue().isReady == false) {
				return false;
			}
		}
		return true;
	}
}



