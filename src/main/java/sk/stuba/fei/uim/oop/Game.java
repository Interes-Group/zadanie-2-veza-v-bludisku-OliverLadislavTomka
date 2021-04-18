package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Game {
    public void gameEngine(){
        var F = new JFrame();
        F.setSize(370,500);
        Graphics g = F.getGraphics();
        F.add(new TestCanvas());
        F.setVisible(true);
    }
}

