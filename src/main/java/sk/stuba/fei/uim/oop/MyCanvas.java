package sk.stuba.fei.uim.oop;

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
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, game.getN() * 30 + 38, game.getN() * 30 + 38);
        g.setColor(Color.CYAN);
        g.fillRect(finish.getXY() * 30 + 12, finish.getXY() * 30 + 22, 29, 29);
        for (int i = 0; i < game.getN(); i++) {
            for (int j = 0; j < game.getN(); j++) {
                g.setColor(Color.BLACK);
                if (game.getTilesArray()[i][j].isUp()) g.drawRect(i * 30 + 10, j * 30 + 20, 31, 1);
                if (game.getTilesArray()[i][j].isDown()) g.drawRect(i * 30 + 10, j * 30 + 30 + 20, 31, 1);
                if (game.getTilesArray()[i][j].isLeft()) g.drawRect(i * 30 + 10, j * 30 + 20, 1, 31);
                if (game.getTilesArray()[i][j].isRight()) g.drawRect(i * 30 + 30 + 10, j * 30 + 20, 1, 31);
                g.setColor(Color.GREEN);
                if (game.getTilesArray()[i][j].isPotential()) g.fillRect(i * 30 + 22, j * 30 + 31, 7, 7);
            }
        }
        g.setColor(Color.GREEN);
        if (!player.isClicked()) g.fillOval(player.getPosx() * 30 + 15, player.getPosy() * 30 + 25, 20, 20);
        else if (player.isClicked() && dx != game.getN() && game.getTilesArray()[dx][dy].isPotential())
            g.fillRect(dx * 30 + 15, dy * 30 + 25, 20, 20);
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

    protected void neighborSetter(boolean hodnota) {
        for (Tile tile : pole) {
            tile.setPotential(hodnota);
        }
        if (!hodnota) pole.clear();
    }

    protected void unmarkPlayer() {
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
}