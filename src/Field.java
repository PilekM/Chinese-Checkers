
public class Field {
    private int base = 0;
    private boolean isField = false;
    private int checker = 0;
    private boolean canMove=false;

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

    void move(Field board[][], int newX, int newY) {
        board[newX][newY].changeChecker(this.checker);
        this.checker = 0;
    }

}
