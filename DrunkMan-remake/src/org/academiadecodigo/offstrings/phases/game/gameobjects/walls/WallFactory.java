package org.academiadecodigo.offstrings.phases.game.gameobjects.walls;

import org.academiadecodigo.offstrings.phases.game.grid.Grid;
import org.academiadecodigo.offstrings.phases.game.grid.GridPosition;

import java.util.ArrayList;
import java.util.List;

public class WallFactory {

    public WallFactory() {
    }

    public List<Wall> getWalls() {

        List<GridPosition> listPositions = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            listPositions.add(new GridPosition(0, i));
        }

        for (int i = 0; i < 25; i++) {
            listPositions.add(new GridPosition(49, i));
        }

        for (int i = 0; i < 50; i++) {
            listPositions.add(new GridPosition(i, 0));
        }

        for (int i = 0; i < 50; i++) {
            listPositions.add(new GridPosition(i, 24));
        }

        listPositions.add(new GridPosition(8, 1));
        listPositions.add(new GridPosition(8, 2));
        listPositions.add(new GridPosition(8, 3));
        listPositions.add(new GridPosition(8, 4));
        listPositions.add(new GridPosition(8, 5));

        listPositions.add(new GridPosition(23, 7));
        listPositions.add(new GridPosition(23, 8));
        listPositions.add(new GridPosition(23, 9));
        listPositions.add(new GridPosition(23, 10));
        listPositions.add(new GridPosition(23, 11));
        listPositions.add(new GridPosition(23, 12));

        listPositions.add(new GridPosition(3, 19));
        listPositions.add(new GridPosition(4, 19));
        listPositions.add(new GridPosition(5, 19));
        listPositions.add(new GridPosition(6, 19));
        listPositions.add(new GridPosition(7, 19));

        listPositions.add(new GridPosition(22, 19));
        listPositions.add(new GridPosition(23, 19));
        listPositions.add(new GridPosition(24, 19));
        listPositions.add(new GridPosition(25, 19));
        listPositions.add(new GridPosition(26, 19));
        listPositions.add(new GridPosition(27, 19));

        listPositions.add(new GridPosition(1, 20));
        listPositions.add(new GridPosition(2, 20));

        listPositions.add(new GridPosition(30, 6));
        listPositions.add(new GridPosition(31, 6));
        listPositions.add(new GridPosition(32, 6));
        listPositions.add(new GridPosition(33, 6));
        listPositions.add(new GridPosition(34, 6));
        listPositions.add(new GridPosition(35, 6));

        listPositions.add(new GridPosition(44, 18));
        listPositions.add(new GridPosition(45, 18));
        listPositions.add(new GridPosition(46, 18));
        listPositions.add(new GridPosition(47, 18));
        listPositions.add(new GridPosition(48, 18));
        listPositions.add(new GridPosition(49, 18));

        listPositions.add(new GridPosition(49, 20));
        listPositions.add(new GridPosition(1, 20));

        listPositions.add(new GridPosition(49, 3));
        listPositions.add(new GridPosition(49, 4));
        listPositions.add(new GridPosition(49, 5));
        listPositions.add(new GridPosition(49, 6));

        listPositions.add(new GridPosition(49, 21));

        listPositions.add(new GridPosition(41, 22));
        listPositions.add(new GridPosition(41, 23));

        listPositions.add(new GridPosition(5, 10));
        listPositions.add(new GridPosition(5, 11));
        listPositions.add(new GridPosition(5, 12));
        listPositions.add(new GridPosition(5, 13));
        listPositions.add(new GridPosition(5, 14));
        listPositions.add(new GridPosition(5, 15));

        listPositions.add(new GridPosition(49, 3));
        listPositions.add(new GridPosition(49, 4));
        listPositions.add(new GridPosition(49, 5));
        listPositions.add(new GridPosition(49, 6));

        listPositions.add(new GridPosition(41, 20));
        listPositions.add(new GridPosition(41, 21));
        listPositions.add(new GridPosition(41, 22));
        listPositions.add(new GridPosition(41, 23));

        listPositions.add(new GridPosition(44, 10));
        listPositions.add(new GridPosition(44, 11));
        listPositions.add(new GridPosition(44, 12));

        listPositions.add(new GridPosition(14, 13));
        listPositions.add(new GridPosition(15, 13));
        listPositions.add(new GridPosition(16, 13));
        listPositions.add(new GridPosition(17, 13));
        listPositions.add(new GridPosition(18, 13));
        listPositions.add(new GridPosition(19, 13));

        for (GridPosition listPosition : listPositions) {

            Wall wall = new Wall();
            wall.setPosition(listPosition);
            walls.add(wall);
        }

        return walls;
    }
}
