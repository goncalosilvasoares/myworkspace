package gameObject;


import gfx.simplegfx.Grid;

public class GameObjectFactory {
    Grid grid;
    public static GameObject[] gameObjects;
    private static int number = 2;

    public GameObjectFactory() {
    }

    public static GameObject getNewObjects(GameObjectType type, Grid grid) {
        GameObject beer = new Beer();
        GameObject pizza = new Pizza();
        return (GameObject)(GameObjectType.BEER == type ? beer : pizza);
    }
}
