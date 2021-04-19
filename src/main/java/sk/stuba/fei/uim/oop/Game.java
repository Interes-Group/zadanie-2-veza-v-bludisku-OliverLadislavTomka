package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Game {
    GameInitialization game = new GameInitialization();
    Player player = new Player();
    Finish finish = new Finish(game.getN()-1);
    MyJPanelv2 canvas=new MyJPanelv2(game,player,finish);
    MyJPanel P = new MyJPanel(game,player,finish,canvas);
    //JLabel counter = new JLabel("Counter: " + player.getWinCounter());



    public Game(){
        createWindow();
    }


    public void createWindow(){
        var F = new JFrame();
        F.setResizable(false);
        F.setSize(game.getN()*30+38,(game.getN()+4)*30);
        F.setBackground(Color.BLUE);
        F.setLayout(new BorderLayout());
        F.add(P,BorderLayout.SOUTH);
        F.add(canvas);
        F.setVisible(true);
    }

}

