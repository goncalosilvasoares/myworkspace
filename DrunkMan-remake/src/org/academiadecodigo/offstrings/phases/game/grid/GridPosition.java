package org.academiadecodigo.offstrings.phases.game.grid;

public class GridPosition {
    private int col;
    private int row;

    public GridPosition() {

        col = (int) (Math.random() * Grid.COLS);
        row = (int) (Math.random() * Grid.ROWS);
    }

    public GridPosition(int col, int row) {

        this.col = col;
        this.row = row;
    }

    public void moveUp(int distance) {

        if (row - distance < 0) {
            row = 0;
            return;
        }
        row -= distance;
    }

    public void moveDown(int distance) {

        if (row + distance > Grid.ROWS - 1) {
            row = Grid.ROWS - 1;
            return;
        }
        row += distance;
    }

    public void moveLeft(int distance) {

        if (col - distance < 0) {
            col = 0;
            return;
        }
        col -= distance;
    }

    public void moveRight(int distance) {

        if (col + distance > Grid.COLS - 1) {
            col = Grid.COLS - 1;
            return;
        }
        col += distance;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isCoinciding(GridPosition other) {

        return col == other.col && row == other.row;
    }
}
