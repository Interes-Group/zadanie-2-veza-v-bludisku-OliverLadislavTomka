package sk.stuba.fei.uim.oop.gameEngine;

import sk.stuba.fei.uim.oop.components.Tile;
import java.util.ArrayList;
import java.util.Collections;

public class GameInitialization {
    private final int n = 21;
    private final Tile[][] tilesArray = new Tile[n][n];
    private final ArrayList<Integer> neighborArray = new ArrayList<>();
    public GameInitialization() {
        gener();
    }

    public void gener() {
        init();
        createMaze();
    }

    public int getN() {
        return n;
    }

    public Tile[][] getTilesArray() {
        return tilesArray;
    }

    private void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tilesArray[i][j] = new Tile();
            }
        }
    }

    private void createMaze() {
        int startX = 0;
        int startY = 0;
        randomizedDFS(startX, startY);
    }

    private void randomizedDFS(int x, int y) {
        tilesArray[x][y].setVisited(true);
        makeNeighborArray(x,y);
        while (neighborArray.size() > 0) {
            chooseNeighbor(x,y);
            makeNeighborArray(x,y);
        }
    }

    private void chooseNeighbor(int x, int y){
        switch (neighborArray.get(0)) {
            case 1:
                tilesArray[x][y - 1].setDown(false);
                tilesArray[x][y].setUp(false);
                randomizedDFS(x, y - 1);
                break;
            case 2:
                tilesArray[x + 1][y].setLeft(false);
                tilesArray[x][y].setRight(false);
                randomizedDFS(x + 1, y);
                break;
            case 3:
                tilesArray[x][y + 1].setUp(false);
                tilesArray[x][y].setDown(false);
                randomizedDFS(x, y + 1);
                break;
            case 4:
                tilesArray[x - 1][y].setRight(false);
                tilesArray[x][y].setLeft(false);
                randomizedDFS(x - 1, y);
                break;
        }
    }

    private void makeNeighborArray(int x, int y){
        neighborArray.clear();
        for (int i = 1; i < 5; i++) {
            switch (i) {
                case 1:
                    if ((y - 1) >= 0 && tilesArray[x][y - 1].isVisited()) neighborArray.add(i);
                    break;
                case 2:
                    if ((x + 1) < n && tilesArray[x + 1][y].isVisited()) neighborArray.add(i);
                    break;
                case 3:
                    if ((y + 1) < n && tilesArray[x][y + 1].isVisited()) neighborArray.add(i);
                    break;
                case 4:
                    if ((x - 1) >= 0 && tilesArray[x - 1][y].isVisited()) neighborArray.add(i);
                    break;
            }
        }
        Collections.shuffle(neighborArray);
    }


}