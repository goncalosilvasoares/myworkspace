package grid;


import grid.position.GridPosition;
import player.PlayerFac;

public interface Grid {
    void init();

    int getCols();

    int getRows();

    GridPosition makeGridPosition();

    GridPosition makeGridPosition(int var1, int var2);

    boolean hasCollided(PlayerFac var1);
}
