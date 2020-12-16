package grid.position;


import grid.GridColor;
import grid.GridDirection;

public interface GridPosition {
    int getCol();

    int getRow();

    void setPos(int var1, int var2);

    void show();

    void hide();

    void moveInDirection(GridDirection var1, int var2);

    boolean equals(GridPosition var1);

    GridColor getColor();

    void setColor(GridColor var1);
}
