package org.academiadecodigo.offstrings.input;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public enum Key {
    ONE_RELEASE(KeyboardEvent.KEY_1, KeyboardEventType.KEY_RELEASED),
    TWO_RELEASE(KeyboardEvent.KEY_2, KeyboardEventType.KEY_RELEASED),
    THREE_RELEASE(KeyboardEvent.KEY_3, KeyboardEventType.KEY_RELEASED),
    Q_PRESS(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED),
    W_RELEASE(KeyboardEvent.KEY_W,KeyboardEventType.KEY_RELEASED),
    S_RELEASE(KeyboardEvent.KEY_S ,KeyboardEventType.KEY_RELEASED),
    A_RELEASE(KeyboardEvent.KEY_A,KeyboardEventType.KEY_RELEASED),
    D_RELEASE(KeyboardEvent.KEY_D,KeyboardEventType.KEY_RELEASED),
    UP_RELEASE(KeyboardEvent.KEY_UP,KeyboardEventType.KEY_RELEASED),
    DOWN_RELEASE(KeyboardEvent.KEY_DOWN,KeyboardEventType.KEY_RELEASED),
    LEFT_RELEASE(KeyboardEvent.KEY_LEFT,KeyboardEventType.KEY_RELEASED),
    RIGHT_RELEASE(KeyboardEvent.KEY_RIGHT,KeyboardEventType.KEY_RELEASED),
    B_PRESS(KeyboardEvent.KEY_B, KeyboardEventType.KEY_PRESSED);

    public final int keyNumber;
    public final KeyboardEventType type;

    Key(int keyNumber, KeyboardEventType type) {

        this.keyNumber = keyNumber;
        this.type = type;
    }
}
