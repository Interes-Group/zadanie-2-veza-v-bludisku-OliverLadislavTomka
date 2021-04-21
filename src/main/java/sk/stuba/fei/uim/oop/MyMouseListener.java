package sk.stuba.fei.uim.oop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private final GameInitialization game;
    private final Player player;
    private final MyCanvas myCanvas;

    public MyMouseListener(GameInitialization game, Player player, MyCanvas myCanvas) {
        this.game = game;
        this.player = player;
        this.myCanvas = myCanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!player.isClicked()) {
            if ((e.getX() > player.getPosx() * 30 + 20) && (e.getX() < player.getPosx() * 30 + 50) && (e.getY() > player.getPosy() * 30 + 50) && (e.getY() < player.getPosy() * 30 + 80)) {
                player.setClicked(true);
                fill2DArray();
                myCanvas.repaint();
            }
        } else if (player.isClicked()) {
            int x1 = (e.getX() - 20) / 30;
            int y1 = (e.getY() - 50) / 30;
            if (x1 < game.getN() && y1 < game.getN() && game.getTilesArray()[x1][y1].isPotential()) {
                player.setPosx(x1);
                player.setPosy(y1);
            }
            player.setClicked(false);
            myCanvas.neighborSetter(false);
            myCanvas.repaint();
            myCanvas.controlFinish();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((e.getX() - 20) / 30 < game.getN() && (e.getY() - 50) / 30 < game.getN() && game.getTilesArray()[(e.getX() - 20) / 30][(e.getY() - 50) / 30].isPotential()
        && e.getX() > 19 && e.getY() > 49) {
            myCanvas.setDx((e.getX() - 20) / 30);
            myCanvas.setDy((e.getY() - 50) / 30);
        } else {
            myCanvas.setDx(game.getN());
            myCanvas.setDy(game.getN());
        }
        myCanvas.repaint();
    }

    private void fill2DArray() {
        int x = player.getPosx();
        int y = player.getPosy();
        myCanvas.getPole().add(game.getTilesArray()[x][y]);
        for (int i = 1; i < 5; i++) {
            neighborChecker(i, x, y);
        }
        myCanvas.neighborSetter(true);
    }

    private void neighborChecker(int index, int x, int y) {
        switch (index) {
            case 1:
                if (!game.getTilesArray()[x][y].isUp()) {
                    myCanvas.getPole().add(game.getTilesArray()[x][y - 1]);
                    neighborChecker(index, x, y - 1);
                }
                break;
            case 2:
                if (!game.getTilesArray()[x][y].isRight()) {
                    myCanvas.getPole().add(game.getTilesArray()[x + 1][y]);
                    neighborChecker(index, x + 1, y);
                }
                break;
            case 3:
                if (!game.getTilesArray()[x][y].isDown()) {
                    myCanvas.getPole().add(game.getTilesArray()[x][y + 1]);
                    neighborChecker(index, x, y + 1);
                }
                break;
            case 4:
                if (!game.getTilesArray()[x][y].isLeft()) {
                    myCanvas.getPole().add(game.getTilesArray()[x - 1][y]);
                    neighborChecker(index, x - 1, y);
                }
                break;
        }
    }
}