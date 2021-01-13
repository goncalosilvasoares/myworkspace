package org.academiadecodigo.offstrings.input;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardStrategyContext implements KeyboardHandler {
    private KeyboardHandler handler;

    public void setHandler(KeyboardHandler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){

            System.exit(0);
        }
        handler.keyPressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        handler.keyReleased(keyboardEvent);
    }
}
