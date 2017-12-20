package Server;

public class Referee {

    Field fieldToMove;
    Checker checkerToMover;

    void validateMove(Field board[][],int newX,int newY){
        if(board[newX][newY].getCanMove()){
            fieldToMove.move(board,newX,newY);
        }
    }

    void markMovable(Field board[][],int x ,int y, Checker[] checkers){
        if(board[x][y].getState()!=null){
            board[x][y].getState().markMovable(board,x,y);
        }
        else{
            System.out.println("Unknown status!");
        }
        fieldToMove = board[x][y];
    }

    boolean doWeStillPlay(Game game){
        if(game.getMapOfPlayers().size()<2){
            return false;
        }
        return true;
    }

    void checkForWinner(Game game){

    }

}
