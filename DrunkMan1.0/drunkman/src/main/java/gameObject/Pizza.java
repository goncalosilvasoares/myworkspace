package gameObject;


import grid.Grid;
import grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pizza extends GameObject {
    private GridPosition pos;
    private Grid grid;
    private Picture picture;

    public Pizza() {
    }

    public void initPicture() {
        int newX = this.getPos().getCol();
        int newY = this.getPos().getRow();
        this.picture = new Picture((double)newX, (double)newY, "Pizza.png");
        this.getPicture().draw();
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void draw() {
        this.picture.draw();
    }

    public Picture getPicture() {
        return super.getPicture();
    }

    public Grid getGrid() {
        return this.grid;
    }

    public GridPosition getPos() {
        return this.pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setPos(GridPosition pos) {
        this.pos = pos;
    }

    public void setSameSpace() {
        super.setSameSpace(true);
    }
}
