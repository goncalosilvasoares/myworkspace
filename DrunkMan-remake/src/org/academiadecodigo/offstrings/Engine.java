package org.academiadecodigo.offstrings;

import org.academiadecodigo.offstrings.input.KeyboardStrategyContext;
import org.academiadecodigo.offstrings.input.Key;
import org.academiadecodigo.offstrings.phases.GamePhase;
import org.academiadecodigo.offstrings.phases.end.GameEnd;
import org.academiadecodigo.offstrings.phases.game.Game;
import org.academiadecodigo.offstrings.phases.start.StartMenu;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Engine {
    private GamePhase currentPhase;
    private KeyboardStrategyContext keyboardStrategyContext;

    public void start() {

        try {

            while (true) {

                keyboardStrategyContext.setHandler(currentPhase);
                currentPhase.execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bootstrap() {

        initKeyboard();
        StartMenu startMenu = new StartMenu(this);
        Game game = new Game(this);
        GameEnd gameEnd = new GameEnd(this);

        startMenu.setGame(game);
        game.setGameEnd(gameEnd);
        gameEnd.setStartMenu(startMenu);

        currentPhase = startMenu;
    }

    private void initKeyboard() {

        keyboardStrategyContext = new KeyboardStrategyContext();
        Keyboard keyboard = new Keyboard(keyboardStrategyContext);
        for (Key key : Key.values()) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(key.type);
            event.setKey(key.keyNumber);
            keyboard.addEventListener(event);
        }
    }

    public void setCurrentPhase(GamePhase phase) {
        currentPhase = phase;
    }
}
