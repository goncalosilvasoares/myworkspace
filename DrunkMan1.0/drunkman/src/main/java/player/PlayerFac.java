package player;


import grid.Grid;
import grid.GridDirection;
import grid.position.GridPosition;
import java.awt.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public abstract class PlayerFac implements KeyboardHandler {
    private GridPosition pos;
    private Grid grid;
    private int speed;
    private boolean alive;
    protected Keyboard keyboard;
    protected Rectangle rectangle;
    protected java.lang.Character characters;
    private int score;
    protected java.lang.Character character;
    private boolean picked;
    private boolean check = false;
    protected GridDirection currentDirection;

    public PlayerFac(GridPosition pos) {
        this.pos = pos;
        this.score = 0;
        this.alive = true;
        this.keyboard = new Keyboard(this);
        this.characters = null;
        this.rectangle = null;
    }

    public boolean isCheck() {
        return this.check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public GridPosition getPos() {
        return this.pos;
    }

    public abstract void move();

    public void accelerate(GridDirection direction, int speed) {
        GridDirection newDirection = direction;
        if (this.isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        this.currentDirection = newDirection;

        for(int i = 0; i < speed; ++i) {
            this.getPos().moveInDirection(newDirection, 1);
        }

    }

    public boolean isHittingWall() {
        switch(this.currentDirection) {
            case LEFT:
                if (this.getPos().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (this.getPos().getCol() == this.grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (this.getPos().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (this.getPos().getRow() == this.grid.getRows() - 1) {
                    return true;
                }
        }

        return false;
    }

    public void setCharacter(java.lang.Character character) {
        this.character = character;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
    }

    public void isPicked() {
        this.picked = true;
    }

    public boolean getPicked() {
        return this.picked;
    }
}