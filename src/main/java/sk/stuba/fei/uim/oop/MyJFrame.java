package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame{
    GameInitialization game;
    MyJPanelv2 canvas;
    MyJPanel P;

    public MyJFrame(GameInitialization game,MyJPanelv2 canvas, MyJPanel P) {
        this.game=game;
        this.canvas=canvas;
        this.P=P;
        var frame = new JFrame();
        frame.setTitle("Maze");
        frame.setResizable(false);
        frame.setSize(game.getN()*30+38,(game.getN()+4)*30);
        frame.setLayout(new BorderLayout());
        frame.add(P,BorderLayout.SOUTH);
        frame.add(canvas);
        frame.setVisible(true);
    }
}
