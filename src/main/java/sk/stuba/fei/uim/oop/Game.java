package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Game {
    GameInitialization game = new GameInitialization();
    Player player = new Player();
    Finish finish = new Finish(game.getN()-1);

    public Game(){
        gameEngine();
    }

    public void gameEngine(){
        var F = new JFrame();
        F.setResizable(false);
        F.setSize(game.getN()*30+38,(game.getN()+4)*30);
        F.setLayout(new BorderLayout());
        var P = new JPanel();
        P.setLayout(new GridLayout(2,3));
        P.add(new JLabel ("        Win counter:      " + player.getWinCounter()));
        P.add(new JButton("UP"));
        P.add(new JButton("RESET"));
        P.add(new JButton("LEFT"));
        P.add(new JButton("DOWN"));
        P.add(new JButton("RIGHT"));
        F.add(P,BorderLayout.SOUTH);
        F.add(new TestCanvas(game, player,finish));
        F.setVisible(true);
    }
}

