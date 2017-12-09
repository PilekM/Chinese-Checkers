public class FourPlayersMode implements GameMode {
    public void addPlayer(int ID, Game game){
        for(int i=2;i<6;i++){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(ID,new Player(i, ID));
                game.getAvailableColors()[i] = false;
                break;
            }
        }
    }
}
