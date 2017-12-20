package Server;

public class Referee {

    int placeInGame = 1;
    Field fieldToMove;
    Checker checkerToMove;

    void validateMove(Field board[][],int newX,int newY, Player player){
        if(board[newX][newY].getCanMove()){
            fieldToMove.move(board,newX,newY);
            checkerToMove.move(board, newX, newY, player);
        }
    }

    void markMovable(Field board[][],int x ,int y, Checker[] checkers){
        for(int i = 0; i < checkers.length; i++){
                if(checkers[i].getX()==x && checkers[i].getY()==y){
                    checkerToMove = checkers[i];
                    if(board[x][y].getState()!=null){
                        board[x][y].getState().markMovable(board,x,y);
                    }
                    else{
                        System.out.println("Unknown status!");
                    }
                    break;
                }
                else{
                    System.out.println("Touch your own checkers!");
                }
        }
    }

    boolean doWeStillPlay(Game game){
        if(game.getMapOfPlayers().size()<2){
            return false;
        }
        return true;
    }

    void checkForWinner(Game game,Player player){
        for(int i = 0; i < player.getCheckerSet().length; i++){

            if(player.getHowManyinBase() == player.getCheckerSet().length){
                player.send("WIN~"+placeInGame);
                placeInGame++;
                game.deletePlayer(player);
            }
        }
    }
}
