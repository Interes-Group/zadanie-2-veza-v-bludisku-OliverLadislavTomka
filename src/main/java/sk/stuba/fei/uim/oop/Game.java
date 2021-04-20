package sk.stuba.fei.uim.oop;

public class Game {
    GameInitialization game = new GameInitialization();
    Player player = new Player();
    Finish finish = new Finish(game.getN()-1);
    MyCanvas canvas=new MyCanvas(game,player,finish);
    MyJPanel P = new MyJPanel(game,player,finish,canvas);



    public Game(){
        createWindow();
    }


    public void createWindow(){
        new MyJFrame(game, canvas,P,player);
    }

}

