package sk.stuba.fei.uim.oop;

import java.awt.*;

public class TestCanvas extends Canvas {
    GameInitialization game = new GameInitialization();
    public void paint(Graphics g){
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        for (int i = 0; i < game.getN(); i++) {
            for (int j = 0; j < game.getN(); j++) {
                if (game.getGameplan()[i][j].isUp()) g.drawRect(i*30+10,j*30+10,31,1);
                if (game.getGameplan()[i][j].isDown()) g.drawRect(i*30+10,j*30+30+10,31,1);
                if (game.getGameplan()[i][j].isLeft()) g.drawRect(i*30+10,j*30+10,1,31);
                if (game.getGameplan()[i][j].isRight()) g.drawRect(i*30+30+10,j*30+10,1,31);
            }
        }
    }
}
