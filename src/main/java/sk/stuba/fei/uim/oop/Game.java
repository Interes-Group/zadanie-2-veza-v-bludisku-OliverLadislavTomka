package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Game {
    GameInitialization game = new GameInitialization();
    Player player = new Player();
    Finish finish = new Finish(game.getN()-1);
    MyJPanel P = new MyJPanel(canvas,game, player,finish);
    MyCanvas canvas=new MyCanvas(game,player,finish,P);

    public Game(){
        createWindow();
    }

    public void createWindow(){
        var F = new JFrame();
        F.setResizable(false);
        F.setSize(game.getN()*30+38,(game.getN()+4)*30);
        F.setLayout(new BorderLayout());
        F.add(P,BorderLayout.SOUTH);
        F.add(canvas);
        F.setVisible(true);
    }

}

