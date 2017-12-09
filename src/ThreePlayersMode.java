public class ThreePlayersMode implements GameMode {
    public void addPlayer(int ID, Game game){
        for(int i=1;i<6;i=+2){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(ID,new Player(i, ID));
                game.getAvailableColors()[i] = false;
                break;
            }
        }
    }
}
