package sk.stuba.fei.uim.oop.listeners;

import sk.stuba.fei.uim.oop.components.Player;
import sk.stuba.fei.uim.oop.components.MyCanvas;
import sk.stuba.fei.uim.oop.gameEngine.GameInitialization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyJButtonListener implements ActionListener {
    private final GameInitialization game;
    private final Player player;
    private final int x;
    private final MyCanvas myCanvas;


    public MyJButtonListener(MyCanvas myCanvas, int x, GameInitialization game, Player player) {
        this.myCanvas = myCanvas;
        this.x = x;
        this.game = game;
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.isClicked()) {
            player.setClicked(false);
            myCanvas.neighborSetter(false);
        }
        keyMove(x, player, game);
        myCanvas.repaint();
        myCanvas.controlFinish();
    }

    private void keyMove(int x, Player player, GameInitialization game) {
        switch (x) {
            case 0:
                player.setWinCounter(0);
                player.setPosx(0);
                player.setPosy(0);
                game.gener();
                myCanvas.getWinCounter().setText("Wins:   " + player.getWinCounter());
                break;
            case 1:
                if (!game.getTilesArray()[player.getPosx()][player.getPosy()].isUp()) {
                    player.setPosy(player.getPosy() - 1);
                }
                break;
            case 2:
                if (!game.getTilesArray()[player.getPosx()][player.getPosy()].isLeft()) {
                    player.setPosx(player.getPosx() - 1);
                }
                break;
            case 3:
                if (!game.getTilesArray()[player.getPosx()][player.getPosy()].isDown()) {
                    player.setPosy(player.getPosy() + 1);
                }
                break;
            case 4:
                if (!game.getTilesArray()[player.getPosx()][player.getPosy()].isRight()) {
                    player.setPosx(player.getPosx() + 1);
                }
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}