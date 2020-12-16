package player;


import grid.GridDirection;
import grid.position.GridPosition;
import walls.WallsFactory;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerPlayer1 extends PlayerFac implements KeyboardHandler {
    private final int MAX_SPEED = 3;
    private int speed = 0;
    private Keyboard keyboard = new Keyboard(this);
    private int score = 1;
    private boolean u = false;
    private boolean d = false;
    private boolean l = false;
    private boolean r = false;
    public static boolean check = false;

    public PlayerPlayer1(GridPosition pos) {
        super(pos);
        this.init();
        this.eat();
    }

    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(37);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(39);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(38);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(40);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent leftR = new KeyboardEvent();
        leftR.setKey(37);
        leftR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        KeyboardEvent rightR = new KeyboardEvent();
        rightR.setKey(39);
        rightR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        KeyboardEvent upR = new KeyboardEvent();
        upR.setKey(38);
        upR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        KeyboardEvent downR = new KeyboardEvent();
        downR.setKey(40);
        downR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(left);
        this.keyboard.addEventListener(right);
        this.keyboard.addEventListener(up);
        this.keyboard.addEventListener(down);
        this.keyboard.addEventListener(leftR);
        this.keyboard.addEventListener(rightR);
        this.keyboard.addEventListener(upR);
        this.keyboard.addEventListener(downR);
    }

    public void move() {
        this.accelerate(this.currentDirection, this.speed);
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void accelerate(GridDirection direction, int speed) {
        this.currentDirection = direction;

        for(int i = 0; i < speed; ++i) {
            this.getPos().moveInDirection(direction, 1);
        }

        if (this.getGrid().hasCollided(this)) {
        }

    }

    public void eat() {
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
            case 37:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() - 1 == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.l = true;
                this.m();
                break;
            case 38:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() - 1 == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.u = true;
                this.m();
                break;
            case 39:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() + 1 == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.r = true;
                this.m();
                break;
            case 40:
                for(i = 0; i < WallsFactory.getWalls().length; ++i) {
                    if (this.getPos().getCol() == WallsFactory.getWalls()[i].getPos().getCol() && this.getPos().getRow() + 1 == WallsFactory.getWalls()[i].getPos().getRow()) {
                        return;
                    }
                }

                this.d = true;
                this.m();
        }

        if (this.speed == 0) {
            this.accelerate(this.currentDirection, 1);
        }

    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 37:
                this.l = false;
                break;
            case 38:
                this.u = false;
                break;
            case 39:
                this.r = false;
                break;
            case 40:
                this.d = false;
        }

    }

    public int getSpeed() {
        return this.speed;
    }
}