package org.academiadecodigo.offstrings.phases;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.offstrings.Engine;
import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GamePhase implements KeyboardHandler {

    private static final int PADDING = 10;

    protected final Engine engine;
    protected final Picture background;
    protected final Sound music;

    public GamePhase(Engine engine, String soundPath) {

        this.engine = engine;
        background = new Picture(PADDING, PADDING, ResourcePaths.BACKGROUND);
        music = new Sound(soundPath);
    }

    public abstract void execute() throws InterruptedException;
}
