package walls;


import grid.Grid;
import grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Walls<V> {
    private GridPosition pos;
    private Grid grid;
    private Picture picture;

    public Walls(GridPosition pos) {
        this.pos = pos;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPos() {
        return this.pos;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
        this.picture = new Picture((double)this.columnToX(pos.getCol()), (double)this.rowToY(pos.getRow()), "/wall.png");
        this.picture.draw();
    }

    public int rowToY(int row) {
        return 10 + 30 * row;
    }

    public int columnToX(int column) {
        return 10 + 30 * column;
    }
}
