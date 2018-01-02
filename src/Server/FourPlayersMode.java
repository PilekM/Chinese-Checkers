package Server;

public class FourPlayersMode implements GameMode {
    @Override
    public void setOrder(Game game) {
        game.setOrder(new Integer[]{4,5,3,2});
    }
    public void addPlayer(Game game,Player player){
        for(int i=2;i<6;i++){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(i,player);
                game.getAvailableColors()[i] = false;
                player.setCheckerSet(i,game.getRows(),game.getBoard());
                break;
            }
        }
    }
}
