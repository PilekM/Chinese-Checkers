package Server;

public class TwoPlayersMode implements GameMode {
    @Override
    public void setOrder(Game game) {
        game.setOrder(new Integer[]{3,4});
    }
    public void addPlayer(Game game,Player player){
        int counter = 0;
        for(int i=3;i<5;i++){
            if(game.getAvailableColors()[counter]){
                game.getMapOfPlayers().put(i,player);
                game.getAvailableColors()[counter] = false;
                player.setCheckerSet(i,game.getRows(),game.getBoard());
                break;
            }
            counter ++;
        }
    }
}
