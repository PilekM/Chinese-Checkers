package Server;

public class SixPlayersMode implements GameMode {
    @Override
    public void setOrder(Game game) {
        game.setOrder(new Integer[]{1,4,5,6,3,2});
    }
    public void addPlayer(Game game,Player player){
        for(int i=0;i<6;i++){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(i+1,player);
                game.getAvailableColors()[i] = false;
                player.setCheckerSet(i,game.getRows(),game.getBoard());
                break;
            }
        }
    }
}
