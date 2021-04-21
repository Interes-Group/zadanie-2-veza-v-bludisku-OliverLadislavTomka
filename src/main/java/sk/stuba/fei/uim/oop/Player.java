package sk.stuba.fei.uim.oop;

public class Player {
    private int posx;
    private int posy;
    private int winCounter;
    private boolean clicked;

    public Player() {
        this.posx = 0;
        this.posy = 0;
        this.winCounter = 0;
        this.clicked = false;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}