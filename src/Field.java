
public class Field {
    private int base;
    private boolean isField;
    private int checker;
    private boolean canMove;
    private FieldState state;

    Field(){
        base = 0;
        isField = false;
        checker = 0;
        canMove = false;
        state = new notInBaseState();
    }

    void changeField(boolean bul) {
        this.isField = bul;
    }

    void changeBase(int i) {
        this.base = i;
    }

    void changeChecker(int i) {
        this.checker = i;
    }
    void changeCanMove(boolean bul){
        this.canMove=bul;
    }

    boolean getCanMove(){
        return this.canMove;
    }
    int getBase() {
        return this.base;
    }

    boolean getField() {
        return this.isField;
    }

    int getChecker(){
        return this.checker;
    }

    FieldState getState(){
        return this.state;
    }

    void changeState(FieldState state){
        this.state=state;
    }

    void move(Field board[][], int newX, int newY) {
        board[newX][newY].changeChecker(this.checker);
        this.checker = 0;
        if(board[newX][newY].getBase()+board[newX][newY].getChecker()==7){
            board[newX][newY].changeState(new inBaseState());
        }
    }

}
