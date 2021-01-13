package org.academiadecodigo.offstrings.phases.game.gameobjects;

import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.offstrings.phases.game.grid.Grid;
import org.academiadecodigo.offstrings.phases.game.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {
    protected Picture representation;
    protected GridPosition position;
    protected String fullPicturePath;

    public GameObject(String picturePath) {

        position = new GridPosition();
        int x = Grid.colToX(position.getCol());
        int y = Grid.rowToY(position.getRow());
        fullPicturePath = ResourcePaths.PATH_IMAGES + picturePath;
        representation = new Picture(x, y, fullPicturePath);
    }

    public void show() {
        representation.draw();
    }

    public void delete(){
        representation.delete();
    }

    public boolean isColliding(GameObject other){
        return position.isCoinciding(other.position);
    }

    public void setPosition(GridPosition position) {

        this.position = position;
        int x = Grid.colToX(position.getCol());
        int y = Grid.rowToY(position.getRow());
        representation = new Picture(x, y, fullPicturePath);
    }

    public GridPosition getPosition() {
        return position;
    }
}
