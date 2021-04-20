package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    GameInitialization game;
    Player player;
    Finish finish;
    MyJPanelv2 myJPanelv2;
    //JLabel counter= new JLabel("");



    public MyJPanel(GameInitialization game, Player player, Finish finish, MyJPanelv2 myJPanelv2) {
        this.player=player;
        this.game=game;
        this.finish=finish;
        this.myJPanelv2 = myJPanelv2;
        this.setLayout(new GridLayout(2,3));

        var buttonClose = new JButton("CLOSE");
        buttonClose.addActionListener(new MyJButton(myJPanelv2,5,game,player));
        this.add(buttonClose);
        buttonClose.setFocusable(false);
        var buttonUp = new JButton("UP");
        buttonUp.addActionListener(new MyJButton(myJPanelv2,1,game,player));
        this.add(buttonUp);
        buttonUp.setFocusable(false);
        var buttonReset = new JButton("RESET");
        buttonReset.addActionListener(new MyJButton(myJPanelv2,0,game,player));
        this.add(buttonReset);
        buttonReset.setFocusable(false);
        var buttonLeft = new JButton("LEFT");
        buttonLeft.addActionListener(new MyJButton(myJPanelv2,2,game,player));
        this.add(buttonLeft);
        buttonLeft.setFocusable(false);
        var buttonDown = new JButton("DOWN");
        buttonDown.addActionListener(new MyJButton(myJPanelv2,3,game,player));
        this.add(buttonDown);
        buttonDown.setFocusable(false);
        var buttonRight = new JButton("RIGHT");
        buttonRight.addActionListener(new MyJButton(myJPanelv2,4,game,player));
        this.add(buttonRight);
        buttonRight.setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
