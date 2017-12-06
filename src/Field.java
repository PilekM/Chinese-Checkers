
public class Field {
    private int base = 0;
    private boolean isField = false;
    private int checker = 0;

    void changeField(boolean bul) {
        this.isField = bul;
    }

    void changeBase(int i) {
        this.base = i;
    }

    void changeChecker(int i) {
        this.checker = i;
    }

    ;


    int getBase() {
        return this.base;
    }

    boolean getField() {
        return this.isField;
    }

    void move(Field board[][], int newX, int newY) {
        board[newX][newY].changeChecker(this.checker);
        this.checker=0;
    }

}