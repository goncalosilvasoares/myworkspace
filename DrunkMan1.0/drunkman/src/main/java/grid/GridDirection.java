package grid;

public enum GridDirection {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    private GridDirection() {
    }

    public boolean isOpposite(GridDirection dir) {
        return dir.equals(this.oppositeDirection());
    }

    public GridDirection oppositeDirection() {
        GridDirection opposite = null;
        switch(this) {
            case UP:
                opposite = DOWN;
                break;
            case DOWN:
                opposite = UP;
                break;
            case LEFT:
                opposite = RIGHT;
                break;
            case RIGHT:
                opposite = LEFT;
        }

        return opposite;
    }
}
