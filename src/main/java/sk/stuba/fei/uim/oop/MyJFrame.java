package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame{
    GameInitialization game;
    MyCanvas canvas;
    MyJPanel P;
    Player player;
    MyKeyListener myKeyListener;
    MyMouseListener myMouseListener;

    public MyJFrame(GameInitialization game, MyCanvas myCanvas, MyJPanel P, Player player) {
        this.game=game;
        this.canvas= myCanvas;
        this.P=P;
        this.player = player;
        this.myKeyListener = new MyKeyListener(game,player,canvas);
        this.myMouseListener = new MyMouseListener(game,player,canvas);
        var frame = new JFrame();
        frame.setSize(game.getN()*30+38,(game.getN()+4)*30+3);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.addKeyListener(myKeyListener);
        frame.addMouseListener(myMouseListener);
        frame.addMouseMotionListener(myMouseListener);
        frame.setTitle("Maze");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(P,BorderLayout.SOUTH);
        frame.add(myCanvas);
        frame.setVisible(true);
    }


}
