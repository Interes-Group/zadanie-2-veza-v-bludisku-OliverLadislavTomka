package sk.stuba.fei.uim.oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyJButton implements ActionListener {
    private final GameInitialization game;
    private final Player player;
    private final int x;
    MyJPanelv2 myJPanelv2;

    public MyJButton(MyJPanelv2 myJPanelv2, int x, GameInitialization game, Player player){
        this.myJPanelv2 = myJPanelv2;
        this.x=x;
        this.game=game;
        this.player=player;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        pohyb(x,player,game);
        myJPanelv2.repaint();
        myJPanelv2.controlFinish();
    }

    private void pohyb(int x, Player player,GameInitialization game){
        switch (x){
            case 0:
                player.setWinCounter(0);
                player.setPosx(0);
                player.setPosy(0);
                game.gener();
                break;
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
            case 5:
                System.exit(0);
        }
    }
}
