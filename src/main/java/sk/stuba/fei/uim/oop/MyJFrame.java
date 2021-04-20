package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame{
    GameInitialization game;
    MyCanvas canvas;
    MyJPanel P;
    Player player;
    MyKeyListener myKeyListener;

    public MyJFrame(GameInitialization game, MyCanvas myCanvas, MyJPanel P, Player player) {
        this.game=game;
        this.canvas= myCanvas;
        this.P=P;
        this.player = player;
        this.myKeyListener = new MyKeyListener(game,player,canvas);
        var frame = new JFrame();
        frame.addKeyListener(myKeyListener);
        frame.setTitle("Maze");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(game.getN()*30+38,(game.getN()+4)*30);
        frame.setLayout(new BorderLayout());
        frame.add(P,BorderLayout.SOUTH);
        frame.add(myCanvas);
        frame.setVisible(true);
    }

}
