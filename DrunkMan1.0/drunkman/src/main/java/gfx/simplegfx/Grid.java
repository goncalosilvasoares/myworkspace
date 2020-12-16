package gfx.simplegfx;


import Game;
import gameObject.Beer;
import gameObject.GameObject;
import gameObject.Pizza;
import grid.position.GridPosition;
import player.PlayerFac;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid implements grid.Grid {
    public static final int PADDING = 10;
    private int cellSize;
    private int cols;
    private int rows;
    private Beer[] beer;
    private Pizza[] pizza;
    int counter = 1;
    public static Text score1;
    public static Text score2;
    private boolean score = false;
    private Rectangle field;
    public static GameObject[] gameObjects;
    public Picture[] pictures;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = 30;
        score1 = new Text(250.0D, 20.0D, (String)null);
        score1.grow(15.0D, 15.0D);
        score1.setColor(Color.BLACK);
        score2 = new Text(1450.0D, 20.0D, (String)null);
        score2.grow(15.0D, 15.0D);
        score2.setColor(Color.BLACK);
    }

    public void init() {
        this.field = new Rectangle(10.0D, 10.0D, (double)(this.cols * this.cellSize), (double)(this.rows * this.cellSize));
        this.field.draw();
        this.pictures = new Picture[45];
        this.pictures[0] = new Picture((double)this.columnToX(20), (double)this.rowToY(10), "Pizza.png");
        this.pictures[0].draw();
        this.pictures[1] = new Picture((double)this.columnToX(6), (double)this.rowToY(12), "Pizza.png");
        this.pictures[1].draw();
        this.pictures[2] = new Picture((double)this.columnToX(20), (double)this.rowToY(16), "Pizza.png");
        this.pictures[2].draw();
        this.pictures[3] = new Picture((double)this.columnToX(7), (double)this.rowToY(19), "Pizza.png");
        this.pictures[3].draw();
        this.pictures[4] = new Picture((double)this.columnToX(20), (double)this.rowToY(10), "Pizza.png");
        this.pictures[4].draw();
        this.pictures[5] = new Picture((double)this.columnToX(16), (double)this.rowToY(8), "Pizza.png");
        this.pictures[5].draw();
        this.pictures[6] = new Picture((double)this.columnToX(25), (double)this.rowToY(9), "Pizza.png");
        this.pictures[6].draw();
        this.pictures[7] = new Picture((double)this.columnToX(42), (double)this.rowToY(19), "Pizza.png");
        this.pictures[7].draw();
        this.pictures[8] = new Picture((double)this.columnToX(18), (double)this.rowToY(4), "Pizza.png");
        this.pictures[8].draw();
        this.pictures[9] = new Picture((double)this.columnToX(20), (double)this.rowToY(16), "Pizza.png");
        this.pictures[9].draw();
        this.pictures[10] = new Picture((double)this.columnToX(41), (double)this.rowToY(12), "Pizza.png");
        this.pictures[10].draw();
        this.pictures[11] = new Picture((double)this.columnToX(18), (double)this.rowToY(16), "Pizza.png");
        this.pictures[11].draw();
        this.pictures[12] = new Picture((double)this.columnToX(40), (double)this.rowToY(9), "Pizza.png");
        this.pictures[12].draw();
        this.pictures[13] = new Picture((double)this.columnToX(28), (double)this.rowToY(10), "Beer.png");
        this.pictures[13].draw();
        this.pictures[14] = new Picture((double)this.columnToX(30), (double)this.rowToY(12), "Beer.png");
        this.pictures[14].draw();
        this.pictures[15] = new Picture((double)this.columnToX(25), (double)this.rowToY(16), "Beer.png");
        this.pictures[15].draw();
        this.pictures[16] = new Picture((double)this.columnToX(29), (double)this.rowToY(19), "Beer.png");
        this.pictures[16].draw();
        this.pictures[17] = new Picture((double)this.columnToX(30), (double)this.rowToY(20), "Beer.png");
        this.pictures[17].draw();
        this.pictures[18] = new Picture((double)this.columnToX(1), (double)this.rowToY(1), "Beer.png");
        this.pictures[18].draw();
        this.pictures[19] = new Picture((double)this.columnToX(5), (double)this.rowToY(15), "Beer.png");
        this.pictures[19].draw();
        this.pictures[20] = new Picture((double)this.columnToX(45), (double)this.rowToY(0), "Beer.png");
        this.pictures[20].draw();
        this.pictures[21] = new Picture((double)this.columnToX(45), (double)this.rowToY(5), "Beer.png");
        this.pictures[21].draw();
        this.pictures[22] = new Picture((double)this.columnToX(45), (double)this.rowToY(10), "Beer.png");
        this.pictures[22].draw();
        this.pictures[23] = new Picture((double)this.columnToX(15), (double)this.rowToY(10), "Beer.png");
        this.pictures[23].draw();
        this.pictures[24] = new Picture((double)this.columnToX(40), (double)this.rowToY(20), "Beer.png");
        this.pictures[24].draw();
        this.pictures[25] = new Picture((double)this.columnToX(35), (double)this.rowToY(20), "Beer.png");
        this.pictures[25].draw();
        this.pictures[26] = new Picture((double)this.columnToX(20), (double)this.rowToY(12), "Beer.png");
        this.pictures[26].draw();
        this.pictures[27] = new Picture((double)this.columnToX(5), (double)this.rowToY(18), "Beer.png");
        this.pictures[27].draw();
        this.pictures[28] = new Picture((double)this.columnToX(25), (double)this.rowToY(10), "Beer.png");
        this.pictures[28].draw();
        this.pictures[29] = new Picture((double)this.columnToX(18), (double)this.rowToY(10), "Beer.png");
        this.pictures[29].draw();
        this.pictures[30] = new Picture((double)this.columnToX(42), (double)this.rowToY(12), "Beer.png");
        this.pictures[30].draw();
        this.pictures[31] = new Picture((double)this.columnToX(35), (double)this.rowToY(20), "Beer.png");
        this.pictures[31].draw();
        this.pictures[32] = new Picture((double)this.columnToX(29), (double)this.rowToY(19), "Beer.png");
        this.pictures[32].draw();
        this.pictures[33] = new Picture((double)this.columnToX(30), (double)this.rowToY(20), "Beer.png");
        this.pictures[33].draw();
        this.pictures[34] = new Picture((double)this.columnToX(1), (double)this.rowToY(10), "Beer.png");
        this.pictures[34].draw();
        this.pictures[35] = new Picture((double)this.columnToX(36), (double)this.rowToY(15), "Beer.png");
        this.pictures[35].draw();
        this.pictures[36] = new Picture((double)this.columnToX(32), (double)this.rowToY(2), "Beer.png");
        this.pictures[36].draw();
        this.pictures[37] = new Picture((double)this.columnToX(4), (double)this.rowToY(2), "Beer.png");
        this.pictures[37].draw();
        this.pictures[38] = new Picture((double)this.columnToX(8), (double)this.rowToY(17), "Beer.png");
        this.pictures[38].draw();
        this.pictures[39] = new Picture((double)this.columnToX(20), (double)this.rowToY(10), "Beer.png");
        this.pictures[39].draw();
        this.pictures[40] = new Picture((double)this.columnToX(18), (double)this.rowToY(9), "Beer.png");
        this.pictures[40].draw();
        this.pictures[41] = new Picture((double)this.columnToX(14), (double)this.rowToY(18), "Beer.png");
        this.pictures[41].draw();
        this.pictures[42] = new Picture((double)this.columnToX(18), (double)this.rowToY(15), "Beer.png");
        this.pictures[42].draw();
        this.pictures[43] = new Picture((double)this.columnToX(12), (double)this.rowToY(10), "Beer.png");
        this.pictures[43].draw();
        this.pictures[44] = new Picture((double)this.columnToX(12), (double)this.rowToY(10), "Beer.png");
        this.pictures[44].draw();
    }

    public int getCellSize() {
        return this.cellSize;
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public GridPosition makeGridPosition() {
        return null;
    }

    public int getWidth() {
        return this.field.getWidth();
    }

    public int getHeight() {
        return this.field.getHeight();
    }

    public int getX() {
        return this.field.getX();
    }

    public int getY() {
        return this.field.getY();
    }

    public GridPosition makeGridPosition(String str) {
        return new Position(this, str);
    }

    public GridPosition makeGridPosition(int col, int row) {
        return new Position(col, row, this);
    }

    public int rowToY(int row) {
        return 10 + this.cellSize * row;
    }

    public int columnToX(int column) {
        return 10 + this.cellSize * column;
    }

    public int xToColumn(int x) {
        return x / this.cellSize;
    }

    public int yToRow(int y) {
        return y / this.cellSize;
    }

    public Picture[] getPictures() {
        return this.pictures;
    }

    public boolean hasCollided(PlayerFac player) {
        for(int i = 0; i < this.pictures.length; ++i) {
            if (player.getPos().getRow() == this.yToRow(this.pictures[i].getY()) && player.getPos().getCol() == this.xToColumn(this.pictures[i].getX())) {
                this.pictures[i].delete();
                this.pictures[i].translate(-100.0D, -100.0D);

                int a;
                for(a = 0; a < 13; ++a) {
                    if (this.pictures[i].equals(this.pictures[a])) {
                        if (!player.isCheck()) {
                            player.setScore(player.getScore() + 9);
                            player.setCheck(true);
                        } else {
                            player.setScore(player.getScore() + 10);
                        }

                        System.out.println(player.getScore());
                        score2.delete();
                        score1.delete();
                        score1.setText(String.valueOf(Game.player1.getScore()));
                        score2.setText(String.valueOf(Game.player2.getScore()));
                        score2.draw();
                        score1.draw();
                    }
                }

                for(a = 13; a < this.pictures.length; ++a) {
                    if (this.pictures[i].equals(this.pictures[a])) {
                        if (!player.isCheck()) {
                            player.setScore(player.getScore() - 6);
                            player.setCheck(true);
                        } else {
                            player.setScore(player.getScore() - 5);
                        }

                        score2.delete();
                        score1.delete();
                        score1.setText(String.valueOf(Game.player1.getScore()));
                        score2.setText(String.valueOf(Game.player2.getScore()));
                        score2.draw();
                        score1.draw();
                        System.out.println(player.getScore());
                        if (Game.player1.getScore() <= 0 || Game.player2.getScore() <= 0) {
                            if (player.equals(Game.player1)) {
                                score1.delete();
                                score2.delete();
                                Game.gameOverFinish("Benny has won");
                            } else {
                                score1.delete();
                                score2.delete();
                                Game.gameOverFinish("Paulinho has won");
                            }
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public void remove() {
    }
}
