public class TwoPlayersMode implements GameMode {
    public void addPlayer(int ID, Game game){
        for(int i=3;i<5;i++){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(ID,new Player(i, ID));
                game.getAvailableColors()[i] = false;
                break;
            }
        }
    }
}
