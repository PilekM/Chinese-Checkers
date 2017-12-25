package Server;

public class Checker {

    private int color;
    private int x;
    private int y;
    private FieldState checkerState;

    public Checker(int Color,int x, int y){
        this.color = Color;
        this.x = x;
        this.y = y;
        this.checkerState = new notInBaseState();
    }

    void move(Field board[][], int newX, int newY, Player player) {
        board[this.x][this.y].changeChecker(0);
        x = newX;
        y = newY;
        board[newX][newY].changeChecker(this.color);
        if(board[newX][newY].getBase()+this.color==7&&this.checkerState!=new inBaseState()){
            this.changeState(new inBaseState());
            player.setHowManyinBase(player.getHowManyinBase()+1);
        }
    }

    private void changeState(FieldState state){
        this.checkerState = state;
    }

    public int getColor(){
        return this.color;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setColor(int color){
        this.color = color;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }



}
