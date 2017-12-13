public class Referee {

    Field fieldToMove;

    void validateMove(Field board[][],int newX,int newY){
        if(board[newX][newY].getCanMove()){
            fieldToMove.move(board,newX,newY);
        }
    }

    void markMovable(Field board[][],int x ,int y){
        if(board[x][y].getState()!=null){
            board[x][y].getState().markMovable(board,x,y);
        }
        else{
            System.out.println("Unknown status!");
        }
        fieldToMove = board[x][y];
    }

    boolean checkWin(Game game){
        if(game.getMapOfPlayers().size()>2){
            return true;
        }
        return false;
    }

}
