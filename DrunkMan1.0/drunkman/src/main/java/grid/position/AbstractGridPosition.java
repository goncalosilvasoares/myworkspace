package grid.position;


import grid.Grid;
import grid.GridColor;
import grid.GridDirection;

public abstract class AbstractGridPosition implements GridPosition {
    private int col;
    private int row;
    private GridColor color;
    private Grid grid;

    public AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.color = GridColor.NOCOLOR;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        this.show();
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public GridColor getColor() {
        return this.color;
    }

    public void setColor(GridColor color) {
        this.color = color;
    }

    public void moveInDirection(GridDirection direction, int distance) {
        switch(direction) {
            case UP:
                this.moveUp(distance);
                break;
            case DOWN:
                this.moveDown(distance);
                break;
            case LEFT:
                this.moveLeft(distance);
                break;
            case RIGHT:
                this.moveRight(distance);
        }

    }

    public boolean equals(GridPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }

    private void moveUp(int dist) {
        int maxRowsUp = Math.min(dist, this.getRow());
        this.setPos(this.getCol(), this.getRow() - maxRowsUp);
    }

    private void moveDown(int dist) {
        int maxRowsDown = Math.min(this.getGrid().getRows() - (this.getRow() + 1), dist);
        this.setPos(this.getCol(), this.getRow() + maxRowsDown);
    }

    private void moveLeft(int dist) {
        int maxRowsLeft = Math.min(dist, this.getCol());
        this.setPos(this.getCol() - maxRowsLeft, this.getRow());
    }

    private void moveRight(int dist) {
        int maxRowsRight = Math.min(this.getGrid().getCols() - (this.getCol() + 1), dist);
        this.setPos(this.getCol() + maxRowsRight, this.getRow());
    }
}