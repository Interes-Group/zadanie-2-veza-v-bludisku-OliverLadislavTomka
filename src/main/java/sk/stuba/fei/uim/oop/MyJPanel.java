package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {


    public MyJPanel(GameInitialization game, Player player, MyCanvas myCanvas) {
        this.setLayout(new GridLayout(2, 3));
        var buttonClose = new JButton("CLOSE");
        buttonClose.addActionListener(new MyJButtonListener(myCanvas, 5, game, player));
        this.add(buttonClose);
        buttonClose.setFocusable(false);
        var buttonUp = new JButton("UP");
        buttonUp.addActionListener(new MyJButtonListener(myCanvas, 1, game, player));
        this.add(buttonUp);
        buttonUp.setFocusable(false);
        var buttonReset = new JButton("RESET");
        buttonReset.addActionListener(new MyJButtonListener(myCanvas, 0, game, player));
        this.add(buttonReset);
        buttonReset.setFocusable(false);
        var buttonLeft = new JButton("LEFT");
        buttonLeft.addActionListener(new MyJButtonListener(myCanvas, 2, game, player));
        this.add(buttonLeft);
        buttonLeft.setFocusable(false);
        var buttonDown = new JButton("DOWN");
        buttonDown.addActionListener(new MyJButtonListener(myCanvas, 3, game, player));
        this.add(buttonDown);
        buttonDown.setFocusable(false);
        var buttonRight = new JButton("RIGHT");
        buttonRight.addActionListener(new MyJButtonListener(myCanvas, 4, game, player));
        this.add(buttonRight);
        buttonRight.setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
