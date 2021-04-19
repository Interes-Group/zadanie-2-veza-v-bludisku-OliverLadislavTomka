package sk.stuba.fei.uim.oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyJButton implements ActionListener {
    private final GameInitialization game;
    private final Player player;
    private final Finish finish;
    private int x;
    MyCanvas myCanvas;

    public MyJButton(MyCanvas myCanvas,int x,GameInitialization game, Player player, Finish finish){
        this.myCanvas= myCanvas;
        this.x=x;
        this.game=game;
        this.player=player;
        this.finish=finish;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        pohyb(x,player,game);
        myCanvas.repaint();
        myCanvas.controlFinish();
    }

    private void pohyb(int x, Player player,GameInitialization game){
        switch (x){
            case 1:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isUp()){
                    player.setPosy(player.getPosy()-1);
                }
                break;
            case 2:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isLeft()){
                    player.setPosx(player.getPosx()-1);
                }
                break;
            case 3:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isDown()){
                    player.setPosy(player.getPosy()+1);
                }
                break;
            case 4:
                if (!game.getGameplan()[player.getPosx()][player.getPosy()].isRight()){
                    player.setPosx(player.getPosx()+1);
                }
                break;
        }
    }
}
