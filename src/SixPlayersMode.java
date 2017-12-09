public class SixPlayersMode implements GameMode {
    public void addPlayer(int ID, Game game){
        for(int i=0;i<6;i++){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(ID,new Player(i+1, ID));
                game.getAvailableColors()[i] = false;
                break;
            }
        }
    }
}
