package org.academiadecodigo.offstrings.phases.game.grid;

public class Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 32;
    public static final int COLS = 50;
    public static final int ROWS = 25;

    public static int colToX(int col){
        return col * CELL_SIZE + PADDING;
    }
    public static int rowToY(int row){
        return row * CELL_SIZE + PADDING;
    }
}
