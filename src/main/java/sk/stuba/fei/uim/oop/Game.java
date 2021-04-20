package sk.stuba.fei.uim.oop;

public class Game {
    GameInitialization game = new GameInitialization();
    Player player = new Player();
    Finish finish = new Finish(game.getN()-1);
    MyJPanelv2 canvas=new MyJPanelv2(game,player,finish);
    MyJPanel P = new MyJPanel(game,player,finish,canvas);



    public Game(){
        createWindow();
    }


    public void createWindow(){
        new MyJFrame(game, canvas,P);
    }

}

