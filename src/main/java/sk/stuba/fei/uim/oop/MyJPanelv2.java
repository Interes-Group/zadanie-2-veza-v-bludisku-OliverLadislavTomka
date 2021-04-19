package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyJPanelv2 extends JPanel {
    GameInitialization game;
    Player player;
    Finish finish;

    public MyJPanelv2(GameInitialization game, Player player, Finish finish){
        this.game=game;
        this.player=player;
        this.finish=finish;
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.GRAY);
        //g.fillRect(0,0,game.getN()*30+38,game.getN()*30+38);
        g.setColor(Color.CYAN);
        g.fillRect(finish.getX()*30+12,finish.getX()*30+12,29,29);
        g.setColor(Color.BLACK);
        for (int i = 0; i < game.getN(); i++) {
            for (int j = 0; j < game.getN(); j++) {
                if (game.getGameplan()[i][j].isUp()) g.drawRect(i*30+10,j*30+10,31,1);
                if (game.getGameplan()[i][j].isDown()) g.drawRect(i*30+10,j*30+30+10,31,1);
                if (game.getGameplan()[i][j].isLeft()) g.drawRect(i*30+10,j*30+10,1,31);
                if (game.getGameplan()[i][j].isRight()) g.drawRect(i*30+30+10,j*30+10,1,31);
            }
        }
        g.setColor(Color.GREEN);
        g.fillOval(player.getPosx()*30+15,player.getPosy()*30+15,20,20);
    }

    public void controlFinish(){
        if (player.getPosx() == finish.getX() && player.getPosx() == player.getPosy()){
            player.setWinCounter(player.getWinCounter()+1);
            player.setPosx(0);
            player.setPosy(0);
            game.gener();
        }
    }



}
