package gameObject;


import grid.Grid;
import grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject {
    private GridPosition pos;
    private Grid grid;
    protected Picture picture;
    private boolean sameSpace = false;

    public GameObject() {
    }

    public void setSameSpace(boolean sameSpace) {
        this.sameSpace = true;
        this.picture.delete();
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
    }

    public Picture getPicture() {
        return this.picture;
    }
}
