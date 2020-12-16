package gfx.simplegfx;


import grid.GridDirection;
import grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position extends AbstractGridPosition {
    private Rectangle rectangle;
    private Grid grid;
    private Picture picture;

    public Position(Grid grid, String str) {
        super((int)(Math.random() * (double)grid.getCols()), (int)(Math.random() * (double)grid.getRows()), grid);
        this.grid = grid;
        int x = this.grid.columnToX(this.getCol());
        int y = this.grid.rowToY(this.getRow());
        this.picture = new Picture((double)x, (double)y, str);
        this.show();
    }

    public Position(int col, int row, Grid grid) {
        super(col, row, grid);
        this.grid = grid;
        this.grid.columnToX(col);
        this.grid.rowToY(row);
    }

    public void show() {
        this.picture.draw();
    }

    public void hide() {
        this.rectangle.delete();
    }

    public void moveInDirection(GridDirection direction, int distance) {
        int initialCol = this.getCol();
        int initialRow = this.getRow();
        super.moveInDirection(direction, distance);
        int dx = this.grid.columnToX(this.getCol()) - this.grid.columnToX(initialCol);
        int dy = this.grid.rowToY(this.getRow()) - this.grid.rowToY(initialRow);
        this.picture.translate((double)dx, (double)dy);
    }
}
