package org.academiadecodigo.offstrings.phases.game.gameobjects.eatables;

import org.academiadecodigo.offstrings.phases.game.gameobjects.GameObject;

public abstract class Eatable extends GameObject {
    protected int pointsWorth;

    public Eatable(String representationPath, int pointsWorth) {

        super(representationPath);
        this.pointsWorth = pointsWorth;
    }


    public int getPointsWorth() {
        return pointsWorth;
    }
}
