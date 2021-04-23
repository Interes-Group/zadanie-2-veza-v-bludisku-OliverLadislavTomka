package sk.stuba.fei.uim.oop.components;

import sk.stuba.fei.uim.oop.gameEngine.GameInitialization;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyCanvas extends JPanel {
    private final GameInitialization game;
    private final Player player;
    private final Finish finish;
    private final ArrayList<Tile> pole = new ArrayList<>();
    JLabel winCounter = new JLabel("");
    private int dx;
    private int dy;


    public MyCanvas(GameInitialization game, Player player, Finish finish) {
        this.game = game;
        this.player = player;
        this.finish = finish;
        this.winCounter.setText("Wins:   " + player.getWinCounter());
        this.add(winCounter, BorderLayout.NORTH);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, game.getN() * 30 + 38, game.getN() * 30 + 48);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(10, 30, game.getN() * 30, game.getN() * 30);
        g.setColor(Color.CYAN);
        g.fillRect(finish.getXY() * 30 + 12, finish.getXY() * 30 + 32, 29, 29);
        for (int i = 0; i < game.getN(); i++) {
            for (int j = 0; j < game.getN(); j++) {
                g.setColor(Color.WHITE);
                if (game.getTilesArray()[i][j].isUp()) g.fillRect(i * 30 + 8, j * 30 + 28, 33, 3);
                if (game.getTilesArray()[i][j].isDown()) g.fillRect(i * 30 + 8, j * 30 + 30 + 28, 33, 3);
                if (game.getTilesArray()[i][j].isLeft()) g.fillRect(i * 30 + 8, j * 30 + 28, 3, 33);
                if (game.getTilesArray()[i][j].isRight()) g.fillRect(i * 30 + 30 + 8, j * 30 + 28, 3, 33);
                g.setColor(Color.GREEN);
                if (game.getTilesArray()[i][j].isPotential()) g.fillRect(i * 30 + 22, j * 30 + 41, 7, 7);
            }
        }
        g.setColor(Color.GREEN);
        if (!player.isClicked()) g.fillOval(player.getPosx() * 30 + 13, player.getPosy() * 30 + 33, 22, 22);
        else if (player.isClicked() && dx != game.getN() && game.getTilesArray()[dx][dy].isPotential())
            g.fillRect(dx * 30 + 14, dy * 30 + 35, 20, 20);
    }

    public void controlFinish() {
        if (player.getPosx() == finish.getXY() && player.getPosx() == player.getPosy()) {
            player.setWinCounter(player.getWinCounter() + 1);
            player.setPosx(0);
            player.setPosy(0);
            game.gener();
            this.winCounter.setText("Wins:   " + player.getWinCounter());
        }
    }

    public ArrayList<Tile> getPole() {
        return pole;
    }

    public void neighborSetter(boolean hodnota) {
        for (Tile tile : pole) {
            tile.setPotential(hodnota);
        }
        if (!hodnota) pole.clear();
    }

    public void unmarkPlayer() {
        if (player.isClicked()) {
            player.setClicked(false);
            this.neighborSetter(false);
        }
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public JLabel getWinCounter() {
        return winCounter;
    }
}