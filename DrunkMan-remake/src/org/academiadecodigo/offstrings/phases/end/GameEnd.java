package org.academiadecodigo.offstrings.phases.end;

import org.academiadecodigo.offstrings.Engine;
import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.offstrings.phases.GamePhase;
import org.academiadecodigo.offstrings.phases.start.StartMenu;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameEnd extends GamePhase {
    private static final int PICTURE_X = 710;
    private static final int PICTURE_Y = 310;

    private boolean idling = true;
    private StartMenu startMenu;
    private String winnerTextPath;
    private String winnerPicturePath;
    private Picture winnerPicture;
    private Texts texts;

    public GameEnd(Engine engine) {
        super(engine, ResourcePaths.END_MUSIC);
    }

    @Override
    public void execute() throws InterruptedException {

        winnerPicture = new Picture( PICTURE_X, PICTURE_Y, ResourcePaths.PATH_IMAGES + winnerPicturePath + ResourcePaths.AVATAR_EXTENSION);
        texts = new Texts(winnerTextPath);
        background.draw();
        winnerPicture.draw();
        texts.draw();
        music.play(true);
        music.setLoop(Integer.MAX_VALUE); // lib limitations

        while(idling){
            Thread.sleep(10);
        }

        engine.setCurrentPhase(startMenu);
        cleanup();
    }

    private void cleanup(){

        texts.delete();
        background.delete();
        winnerPicture.delete();
        music.stop();
        idling = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_B:
                idling = false;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void setStartMenu(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    public void setWinner(String winner) {
        this.winnerTextPath = winner;
    }

    public void setWinnerPicturePath(String winnerPicturePath){
        this.winnerPicturePath = winnerPicturePath;
    }
}
