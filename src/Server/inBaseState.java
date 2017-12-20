package Server;

public class inBaseState implements FieldState {
    @Override
    public void markMovable(Field board[][],int x ,int y){
        int myRóżnica[]=new int[2];
        for (int i=x-2;i<=x+2;i++){
            for(int j=y-2;j<=y+2;j++){
                if(board[i][j].getField()&&board[i][j].getBase()!=0){
                    if(board[i][j].getChecker()==0){
                        board[i][j].changeCanMove(true);
                    }
                    else if(board[i][j].getChecker()>0){
                        myRóżnica[0]=(x-i)*2;
                        myRóżnica[1]=(y-j)*2;
                        if(board[x-myRóżnica[0]][y-myRóżnica[1]].getField()&&board[x-myRóżnica[0]][y-myRóżnica[1]].getChecker()==0&board[i][j].getBase()!=0){
                            board[x-myRóżnica[0]][y-myRóżnica[1]].changeCanMove(true);
                        }
                    }
                }
            }
        }
    }
}
