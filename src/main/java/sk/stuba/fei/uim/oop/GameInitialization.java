package sk.stuba.fei.uim.oop;

public class GameInitialization {
    int n = 11;
    private Tile[][] gameplan = new Tile[n][n];

    public GameInitialization(){
        init();
        gameplan[1][1].setDown(false);
        printGame();
    }

    public void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gameplan[i][j] = new Tile();
            }
        }
    }

    public void printGame() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gameplan[i][j].isDown() && gameplan[i][j].isUp() && gameplan[i][j].isRight() && gameplan[i][j].isLeft())  System.out.print("a");
                else System.out.print("n");
            }
            System.out.print("\n");
        }
    }

}
