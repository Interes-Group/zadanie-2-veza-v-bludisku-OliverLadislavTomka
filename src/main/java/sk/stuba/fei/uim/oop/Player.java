package sk.stuba.fei.uim.oop;

public class Player {
    private int posx;
    private int posy;
    private int winCounter;

    public Player() {
        this.posx = 0;
        this.posy = 0;
        this.winCounter = 0;
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
}
