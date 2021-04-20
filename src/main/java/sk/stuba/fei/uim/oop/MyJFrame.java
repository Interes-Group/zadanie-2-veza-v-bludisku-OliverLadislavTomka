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
        var F = new JFrame();
        F.setTitle("Maze");
        F.setResizable(false);
        F.setSize(game.getN()*30+38,(game.getN()+4)*30);
        F.setBackground(Color.BLUE);
        F.setLayout(new BorderLayout());
        F.add(P,BorderLayout.SOUTH);
        F.add(canvas);
        F.setVisible(true);
    }
}
