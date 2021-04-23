package sk.stuba.fei.uim.oop.gameEngine;

import sk.stuba.fei.uim.oop.components.*;

public class Game {

    public Game() {
        Player player = new Player();
        GameInitialization game = new GameInitialization();
        Finish finish = new Finish(game.getN() - 1);
        MyCanvas canvas = new MyCanvas(game, player, finish);
        MyJPanel p = new MyJPanel(game, player, canvas);
        new MyJFrame(game, canvas, p, player);
    }
}