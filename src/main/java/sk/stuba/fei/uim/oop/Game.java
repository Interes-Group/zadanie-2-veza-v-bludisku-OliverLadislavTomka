package sk.stuba.fei.uim.oop;

public class Game {
    private final GameInitialization game = new GameInitialization();
    private final Player player = new Player();
    private final Finish finish = new Finish(game.getN()-1);
    private final MyCanvas canvas=new MyCanvas(game,player,finish);
    private final MyJPanel P = new MyJPanel(game,player,canvas);



    public Game(){
        createWindow();
    }


    public void createWindow(){
        new MyJFrame(game, canvas,P,player);
    }

}

