package Client;

public class Field {
    private int base;
    private boolean isField;
    private int checker;
    private boolean canMove;

    public int getBase() {
        return base;
    }

    public int getChecker() {
        return checker;
    }

    public boolean getCanMove(){
        return canMove;
    }

    public boolean getIsField(){
        return isField;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public void setField(boolean field) {
        isField = field;
    }
}
