package sk.stuba.fei.uim.oop.components;

import sk.stuba.fei.uim.oop.gameEngine.GameInitialization;
import sk.stuba.fei.uim.oop.listeners.MyKeyListener;
import sk.stuba.fei.uim.oop.listeners.MyMouseListener;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    public MyJFrame(GameInitialization game, MyCanvas myCanvas, MyJPanel P, Player player) {
        MyKeyListener myKeyListener = new MyKeyListener(game, player, myCanvas);
        MyMouseListener myMouseListener = new MyMouseListener(game, player, myCanvas);
        var frame = new JFrame();
        frame.setSize(game.getN() * 30 + 38, (game.getN() + 4) * 30 + 13);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.addKeyListener(myKeyListener);
        frame.addMouseListener(myMouseListener);
        frame.addMouseMotionListener(myMouseListener);
        frame.setTitle("Maze");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(P, BorderLayout.SOUTH);
        frame.add(myCanvas);
        frame.setVisible(true);
    }

}