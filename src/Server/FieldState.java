package Server;

public interface FieldState {
    void markMovable(Field board[][],int x ,int y);
    void markMovableAfterMove(Field board[][],int x,int y);
}
