package sk.stuba.fei.uim.oop.components;

public class Tile {
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean visited;
    private boolean potential;

    public Tile() {
        this.up = true;
        this.down = true;
        this.left = true;
        this.right = true;
        this.visited = false;
        this.potential = false;
    }

    public boolean isPotential() {
        return potential;
    }

    public void setPotential(boolean potential) {
        this.potential = potential;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isVisited() {
        return !visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}