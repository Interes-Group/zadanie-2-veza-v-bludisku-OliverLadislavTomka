package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private final GameInitialization game;
    private final Player player;
    private final MyCanvas myCanvas;

    public MyKeyListener(GameInitialization game, Player player, MyCanvas myCanvas) {
        this.game = game;
        this.player = player;
        this.myCanvas = myCanvas;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38:
            case 87:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isUp()) {
                    player.setPosy(player.getPosy() - 1);
                }
                break;
            case 82:
                player.setWinCounter(0);
                player.setPosx(0);
                player.setPosy(0);
                game.gener();
                myCanvas.counter.setText("Wins:" + player.getWinCounter());
                myCanvas.add(myCanvas.counter, BorderLayout.NORTH);
                break;
            case 37:
            case 65:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isLeft()){
                    player.setPosx(player.getPosx()-1);
                }
                break;
            case 40:
            case 83:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isDown()){
                    player.setPosy(player.getPosy()+1);
                }
                break;
            case 39:
            case 68:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isRight()){
                    player.setPosx(player.getPosx()+1);
                }
                break;
            default:
                break;
        }
        myCanvas.repaint();
        myCanvas.controlFinish();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
