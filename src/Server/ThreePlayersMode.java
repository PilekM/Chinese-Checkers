package Server;

public class ThreePlayersMode implements GameMode {

    @Override
    public void setOrder(Game game) {
        game.setOrder(new Integer[]{2,4,6});
    }

    public void addPlayer(Game game, Player player){
        for(int i=1;i<6;i=+2){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(i+1,player);
                game.getAvailableColors()[i] = false;
                player.setCheckerSet(i,game.getRows(),game.getBoard());
                break;
            }
        }
    }

}
