public class Referee {

    void validateMove(Field board[][],Field start,int newX,int newY){
        if(board[newX][newY].getCanMove()){
            start.move(board,newX,newY);
        }
    }

    void markMovable(Field board[][],int x ,int y){
        if(board[x][y].getState()!=null){
            board[x][y].getState().markMovable(board,x,y);
        }
        else{
            System.out.println("Unknown status!");
        }
    }

}
