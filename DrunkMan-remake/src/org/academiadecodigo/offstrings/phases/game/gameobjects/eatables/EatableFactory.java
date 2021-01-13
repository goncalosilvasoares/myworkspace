package org.academiadecodigo.offstrings.phases.game.gameobjects.eatables;

public class EatableFactory {
    public static Eatable createEatable(){

        EatableType[] eatableTypes = EatableType.values();
        int randomIndex = (int)(Math.random() * EatableType.values().length);
        EatableType type = eatableTypes[randomIndex];

        switch (type){

            case BEER:
                return new Beer();
            case PIZZA:
                return new Pizza();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
