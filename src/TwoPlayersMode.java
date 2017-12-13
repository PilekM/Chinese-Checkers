public class TwoPlayersMode implements GameMode {
    @Override
    public void setOrder(Game game) {
        game.setOrder(new Integer[]{3,4});
    }
    public void addPlayer(Game game,Player player){
        for(int i=3;i<5;i++){
            if(game.getAvailableColors()[i]){
                game.getMapOfPlayers().put(i,player);
                game.getAvailableColors()[i] = false;
                break;
            }
        }
    }
}
