package Client;

public class Player {
    String name;
    Checker[] checkers;
    boolean isReady;

    public String getName() {
        return name;
    }

    public Checker[] getCheckers() {
        return checkers;
    }

    public boolean getIsReady(){
        return isReady;
    }

    public void setCheckers(Checker[] checkers) {
        this.checkers = checkers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
