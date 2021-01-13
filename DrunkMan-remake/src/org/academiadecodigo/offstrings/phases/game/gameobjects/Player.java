package org.academiadecodigo.offstrings.phases.game.gameobjects;

import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.offstrings.phases.game.grid.Grid;

public class Player extends GameObject{
    private final int speed;
    private int score;

    public Player(String playerName) {

        super(playerName + ResourcePaths.INGAME_EXTENSION);
        speed = 1; //TODO
        score = 0;
    }


    public void moveUp() {

        int initialCol = position.getCol();
        int initialRow = position.getRow();
        position.moveUp(speed);
        moveRepresentation(initialCol, initialRow);
    }

    public void moveDown() {

        int initialCol = position.getCol();
        int initialRow = position.getRow();
        position.moveDown(speed);
        moveRepresentation(initialCol, initialRow);
    }

    public void moveLeft() {

        int initialCol = position.getCol();
        int initialRow = position.getRow();
        position.moveLeft(speed);
        moveRepresentation(initialCol, initialRow);
    }

    public void moveRight() {

        int initialCol = position.getCol();
        int initialRow = position.getRow();
        position.moveRight(speed);
        moveRepresentation(initialCol, initialRow);
    }

    private void moveRepresentation(int initialCol, int initialRow) {

        int dx = Grid.colToX(position.getCol()) - Grid.colToX(initialCol);
        int dy = Grid.rowToY(position.getRow()) - Grid.rowToY(initialRow);
        representation.translate(dx, dy);
    }

    public void score(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}
