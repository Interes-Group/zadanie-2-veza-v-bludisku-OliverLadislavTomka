package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;

public class GameInitialization {
    private final int n=11;
    private final Tile[][] gameplan = new Tile[n][n];


    public GameInitialization(){
        gener();
    }

    public void gener(){
        init();
        createMaze();
    }

    public int getN() {
        return n;
    }

    public Tile[][] getGameplan() {
        return gameplan;
    }

    private void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gameplan[i][j] = new Tile();
            }
        }
    }

    private void createMaze(){
        int startX=0;
        int startY=0;
        randomizedDFS(startX,startY);
    }

    private void randomizedDFS(int x, int y){
        gameplan[x][y].setVisited(true);
        ArrayList<Integer> zoznamSusedov = new ArrayList<>();
        for (int i = 1; i < 5  ; i++) {
            switch (i){
                case 1:
                    if ((y-1) >= 0 && !gameplan[x][y-1].isVisited()) zoznamSusedov.add(i);
                    break;
                case 2:
                    if ((x+1) < n && !gameplan[x+1][y].isVisited()) zoznamSusedov.add(i);
                    break;
                case 3:
                    if ((y+1) < n && !gameplan[x][y+1].isVisited()) zoznamSusedov.add(i);
                    break;
                case 4:
                    if ((x-1) >= 0 && !gameplan[x-1][y].isVisited()) zoznamSusedov.add(i);
                    break;
            }
        }
        Collections.shuffle(zoznamSusedov);
        while (zoznamSusedov.size() > 0) {
            if (trueSused(x, y, zoznamSusedov.get(0))) {
                switch (zoznamSusedov.get(0)) {
                    case 1:
                        gameplan[x][y - 1].setDown(false);
                        gameplan[x][y].setUp(false);
                        randomizedDFS(x, y - 1);
                        break;
                    case 2:
                        gameplan[x + 1][y].setLeft(false);
                        gameplan[x][y].setRight(false);
                        randomizedDFS(x + 1, y);
                        break;
                    case 3:
                        gameplan[x][y + 1].setUp(false);
                        gameplan[x][y].setDown(false);
                        randomizedDFS(x, y + 1);
                        break;
                    case 4:
                        gameplan[x - 1][y].setRight(false);
                        gameplan[x][y].setLeft(false);
                        randomizedDFS(x - 1, y);
                        break;
                }
            }
            zoznamSusedov.remove(0);
        }
    }

    private boolean trueSused(int x,int y,int iteracia){
        switch (iteracia){
            case 1:
                if (gameplan[x][y-1].isVisited())
                    return false;
                    break;
            case 2:
                if (gameplan[x+1][y].isVisited())
                    return false;
                break;
            case 3:
                if (gameplan[x][y+1].isVisited())
                    return false;
                break;
            case 4:
                if (gameplan[x-1][y].isVisited())
                    return false;
                break;
        }
        return true;
    }


}
