package player;


import grid.GridDirection;
import grid.position.GridPosition;
import walls.WallsFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerPlayer2 extends PlayerFac implements KeyboardHandler {
    private final int MAX_SPEED = 3;
    private Keyboard keyboard = new Keyboard(this);
    private int speed = 0;
    private int score = 1;
    private boolean u = false;
    private boolean d = false;
    private boolean l = false;
    private boolean r = false;
    public boolean check = false;

    public PlayerPlayer2(GridPosition pos) {
        super(pos);
        this.init();
    }

    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(65);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(68);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(87);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(83);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent leftR = new KeyboardEvent();
        leftR.setKey(65);
        leftR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        KeyboardEvent rightR = new KeyboardEvent();
        rightR.setKey(68);
        rightR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        KeyboardEvent upR = new KeyboardEvent();
        upR.setKey(87);
        upR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        KeyboardEvent downR = new KeyboardEvent();
        downR.setKey(83);
        downR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(leftR);
        this.keyboard.addEventListener(rightR);
        this.keyboard.addEventListener(upR);
        this.keyboard.addEventListener(downR);
        this.keyboard.addEventListener(left);
        this.keyboard.addEventListener(right);
        this.keyboard.addEventListener(up);
        this.keyboard.addEventListener(down);
    }

    public void move() {
        this.accelerate(this.currentDirection, this.speed);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void accelerate(GridDirection direction, int speed) {
        this.currentDirection = direction;

        for(int i = 0; i < speed; ++i) {
            this.getPos().moveInDirection(direction, 1);
        }

        if (this.getGrid().hasCollided(this)) {
        }

    }

    public void m() {
        if (this.l) {
            this.currentDirection = GridDirection.LEFT;
        }

        if (this.r) {
            this.currentDirection = GridDirection.RIGHT;
        }

        if (this.u) {
            this.currentDirection = GridDirection.UP;
        }

        if (this.d) {
            this.currentDirection = GridDirection.DOWN;
        }

    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        int i;
        switch(keyboardEvent.getKey()) {
            case 65:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() - 1 == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.l = true;
                this.m();
                break;
            case 68:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() + 1 == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.r = true;
                this.m();
                break;
            case 83:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() + 1 == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.d = true;
                this.m();
                break;
            case 87:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() - 1 == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.u = true;
                this.m();
        }

        if (this.speed == 0) {
            this.accelerate(this.currentDirection, 1);
        }

    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 65:
                this.l = false;
                break;
            case 68:
                this.r = false;
                break;
            case 83:
                this.d = false;
                break;
            case 87:
                this.u = false;
        }

    }

    public int getSpeed() {
        return this.speed;
    }
}
