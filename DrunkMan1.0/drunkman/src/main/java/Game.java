
import gfx.simplegfx.Grid;
import grid.position.GridPosition;
import player.Character;
import player.PlayerPlayer1;
import player.PlayerPlayer2;
import walls.WallsFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {
    public static PlayerPlayer1 player1;
    public static PlayerPlayer2 player2;
    private static Text end;
    private static Rectangle gameOverPage;
    private static Grid grid;
    private static boolean gameOver;
    private Keyboard keyboard;
    private Rectangle firstPage;
    private Text start;
    private Text startPress;
    private int counter;
    private Picture picBenny;
    private Picture picRolo;
    private Picture picPaulo;
    private Text nameBenny;
    private Text nameRolo;
    private Text namePaulo;
    private int numb = 2;
    private Text welcome;
    private int delay;
    private Picture pic;
    private Text pick;
    private static Sound theme;

    public Game(int cols, int rows, int delay) {
        grid = new Grid(cols, rows);
        this.delay = delay;
        this.keyboard = new Keyboard(this);
        this.counter = 1;
        player2 = new PlayerPlayer2((GridPosition)null);
        player1 = new PlayerPlayer1((GridPosition)null);
    }

    public void init() {
        theme = new Sound("/mp.wav");
        theme.play(true);
        this.firstPage = new Rectangle(10.0D, 10.0D, 1500.0D, 700.0D);
        this.firstPage.setColor(Color.DARK_GRAY);
        this.firstPage.fill();
        this.start = new Text(550.0D, 500.0D, "Press <SPACE> to START");
        this.startPress = new Text(590.0D, 550.0D, "the game");
        this.welcome = new Text(550.0D, 50.0D, "Welcome to the DRUNK MAN!");
        this.pic = new Picture(870.0D, 40.0D, "Beer.png");
        this.pic.grow(10.0D, 10.0D);
        this.pic.draw();
        this.welcome.setColor(Color.YELLOW);
        this.start.setColor(Color.WHITE);
        this.startPress.setColor(Color.YELLOW);
        this.start.grow(160.0D, 30.0D);
        this.start.draw();
        this.startPress.grow(70.0D, 20.0D);
        this.startPress.draw();
        this.welcome.draw();
        this.welcome.grow(200.0D, 30.0D);
        this.pick = new Text(350.0D, 100.0D, "Dear Players, pick your characters. Press [1] to pick Benny, [2] - Rolo-Demon and [3] - Paulinho");
        this.pick.setColor(Color.WHITE);
        this.pick.grow(280.0D, 15.0D);
        this.pick.draw();
        this.picBenny = new Picture(200.0D, 150.0D, "Benny.jpg");
        this.picBenny.draw();
        this.nameBenny = new Text(290.0D, 370.0D, Character.BENNY.getName());
        this.nameBenny.setColor(Color.RED);
        this.nameBenny.grow(30.0D, 10.0D);
        this.nameBenny.draw();
        this.picRolo = new Picture(500.0D, 150.0D, "Rolo.jpg");
        this.picRolo.draw();
        this.nameRolo = new Text(575.0D, 370.0D, Character.ROLO.getName());
        this.nameRolo.setColor(Color.RED);
        this.nameRolo.grow(45.0D, 10.0D);
        this.nameRolo.draw();
        this.picPaulo = new Picture(800.0D, 150.0D, "2.jpg");
        this.picPaulo.draw();
        this.namePaulo = new Text(885.0D, 370.0D, Character.PAULINHO.getName());
        this.namePaulo.setColor(Color.RED);
        this.namePaulo.grow(45.0D, 10.0D);
        this.namePaulo.draw();
        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(32);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.keyboard.addEventListener(pressSpace);
        KeyboardEvent pressOne = new KeyboardEvent();
        pressOne.setKey(49);
        pressOne.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(pressOne);
        KeyboardEvent pressTwo = new KeyboardEvent();
        pressTwo.setKey(50);
        pressTwo.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(pressTwo);
        KeyboardEvent pressTree = new KeyboardEvent();
        pressTree.setKey(51);
        pressTree.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.keyboard.addEventListener(pressTree);
    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (this.counter > 0) {
            this.start.delete();
            this.firstPage.delete();
            this.startPress.delete();
            this.nameBenny.delete();
            this.namePaulo.delete();
            this.nameRolo.delete();
            this.picBenny.delete();
            this.picPaulo.delete();
            this.picRolo.delete();
            this.welcome.delete();
            this.pic.delete();
            this.pick.delete();
            boolean keyboardSupport = grid instanceof Grid;
            grid.init();
            WallsFactory.getNewObject(grid);
            Text score1 = new Text(100.0D, 20.0D, "Score Paulinho :");
            score1.grow(80.0D, 20.0D);
            score1.setColor(Color.BLACK);
            Text score2 = new Text(1300.0D, 20.0D, "Score Benny :");
            score2.grow(80.0D, 20.0D);
            score2.setColor(Color.BLACK);
            score2.draw();
            score1.draw();
            if (keyboardSupport) {
                player1.setPos(grid.makeGridPosition("P.jpg"));
                player2.setPos(grid.makeGridPosition("B.jpg"));
                player1.getPos();
                player1.setGrid(grid);
                player2.getPos();
                player2.setGrid(grid);
            }

            for(int i = 0; i < grid.getPictures().length; ++i) {
                if (player1.getPos().getRow() == grid.getPictures()[i].getX() && player1.getPos().getCol() == grid.getPictures()[i].getY()) {
                    grid.getPictures()[i].delete();
                    System.out.println("aaa");
                }
            }

            this.counter = 0;
        }

    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == 49) {
            if (!player1.getPicked()) {
                player1.setCharacter(Character.BENNY);
                this.picBenny.delete();
                this.nameBenny.delete();
                player1.isPicked();
            } else {
                player2.setCharacter(Character.BENNY);
                this.picBenny.delete();
                this.nameBenny.delete();
                player2.isPicked();
            }
        }

        if (keyboardEvent.getKey() == 50) {
            if (!player1.getPicked()) {
                player1.setCharacter(Character.ROLO);
                this.picRolo.delete();
                this.nameRolo.delete();
                player1.isPicked();
            } else {
                player2.setCharacter(Character.ROLO);
                this.picRolo.delete();
                this.nameRolo.delete();
                player2.isPicked();
            }
        }

        if (keyboardEvent.getKey() == 51) {
            if (!player1.getPicked()) {
                player1.setCharacter(Character.PAULINHO);
                this.picPaulo.delete();
                this.namePaulo.delete();
                player1.isPicked();
            } else {
                player2.setCharacter(Character.PAULINHO);
                this.picPaulo.delete();
                this.namePaulo.delete();
                player2.isPicked();
            }
        }

    }

    public void start() throws InterruptedException {
        while(true) {
            Thread.sleep((long)this.delay);
        }
    }

    public static void gameOverFinish(String name) {
        theme.stop();
        theme = new Sound("/smw_game_over.wav");
        theme.play(true);
        gameOver = true;
        grid.remove();
        gameOverPage = new Rectangle(10.0D, 10.0D, 1500.0D, 750.0D);
        gameOverPage.setColor(Color.LIGHT_GRAY);
        gameOverPage.fill();
        Text winner = new Text(750.0D, 500.0D, name + "!!!");
        winner.setColor(Color.BLUE);
        winner.draw();
        winner.grow(80.0D, 30.0D);
        end = new Text(750.0D, 250.0D, "GAME OVER");
        end.setColor(Color.BLUE);
        end.draw();
        end.grow(100.0D, 30.0D);
    }
}
