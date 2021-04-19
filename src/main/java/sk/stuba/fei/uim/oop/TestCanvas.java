package sk.stuba.fei.uim.oop;

import java.awt.*;

public class TestCanvas extends Canvas {
    GameInitialization game = new GameInitialization();
    Player player = new Player();
    Finish finish = new Finish(game.getN()-1);
    public void paint(Graphics g){
        for (int i = 0; i < game.getN(); i++) {
            for (int j = 0; j < game.getN(); j++) {
                if (game.getGameplan()[i][j].isUp()) g.drawRect(i*30+10,j*30+10,31,1);
                if (game.getGameplan()[i][j].isDown()) g.drawRect(i*30+10,j*30+30+10,31,1);
                if (game.getGameplan()[i][j].isLeft()) g.drawRect(i*30+10,j*30+10,1,31);
                if (game.getGameplan()[i][j].isRight()) g.drawRect(i*30+30+10,j*30+10,1,31);
            }
        }
        g.setColor(Color.GREEN);
        g.drawOval(player.getPosx()*30+15,player.getPosy()*30+15,20,20);
        g.setColor(Color.CYAN);
        g.drawOval(finish.getX()*30+15,finish.getX()*30+15,20,20);
    }
}
