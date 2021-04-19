package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    GameInitialization game;
    Player player;
    Finish finish;
    MyCanvas myCanvas;
    JLabel counter= new JLabel("");

    public MyJPanel(GameInitialization game, Player player, Finish finish,MyCanvas myCanvas) {
        this.player=player;
        this.game=game;
        this.finish=finish;
        this.myCanvas = myCanvas;
        this.setLayout(new GridLayout(2,3));
        var buttonUp = new JButton("UP");
        counter.setText ("   Win counter:   " + player.getWinCounter());
        this.add(counter);
        buttonUp.addActionListener(new MyJButton(myCanvas,1,game,player,finish));
        this.add(buttonUp);
        buttonUp.setFocusable(false);
        var buttonReset = new JButton("RESET");
        buttonReset.addActionListener(new MyJButton(myCanvas,0,game,player,finish));
        this.add(buttonReset);
        buttonReset.setFocusable(false);
        var buttonLeft = new JButton("LEFT");
        buttonLeft.addActionListener(new MyJButton(myCanvas,2,game,player,finish));
        this.add(buttonLeft);
        buttonLeft.setFocusable(false);
        var buttonDown = new JButton("DOWN");
        buttonDown.addActionListener(new MyJButton(myCanvas,3,game,player,finish));
        this.add(buttonDown);
        buttonDown.setFocusable(false);
        var buttonRight = new JButton("RIGHT");
        buttonRight.addActionListener(new MyJButton(myCanvas,4,game,player,finish));
        this.add(buttonRight);
        buttonRight.setFocusable(false);
    }

    public void updateWinCounter(){
        counter.setText ("   Win counter:   " + player.getWinCounter());
    }

}
