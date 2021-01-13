package org.academiadecodigo.offstrings.phases.start;

import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.offstrings.Engine;
import org.academiadecodigo.offstrings.phases.GamePhase;
import org.academiadecodigo.offstrings.phases.game.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends GamePhase {

    private static final int AVATARS_Y = 310;
    private static final int AVATAR1_X = 310;
    private static final int AVATAR2_X = 710;
    private static final int AVATAR3_X = 1110;
    private static final int WELCOME_X = 110;
    private static final int WELCOME_Y = 105;

    private final Avatar[] avatars;
    private final Picture welcomePicture;
    private Game game;
    private String p1;
    private String p2;

    public StartMenu(Engine engine) {

        super(engine, ResourcePaths.GAME_MUSIC);
        avatars = new Avatar[]{
                new Avatar(AVATAR1_X, AVATARS_Y, ResourcePaths.BENNY, 1),
                new Avatar(AVATAR2_X, AVATARS_Y, ResourcePaths.PAULO, 2),
                new Avatar(AVATAR3_X, AVATARS_Y, ResourcePaths.ROLO, 3)
        };
        welcomePicture = new Picture(WELCOME_X,WELCOME_Y, ResourcePaths.WELCOME_TEXT);
    }

    @Override
    public void execute() throws InterruptedException {

        background.draw();
        welcomePicture.draw();
        showAvatars();
        music.play(true);
        music.setLoop(Integer.MAX_VALUE); //lib limitations

        while (p2 == null) {
            Thread.sleep(10);
        }

        game.setPlayers(p1, p2);
        engine.setCurrentPhase(game);
        cleanup();
    }

    private void cleanup() {

        music.stop();
        hideAvatars();
        background.delete();
        welcomePicture.delete();
        p1 = null;
        p2 = null;
    }

    private void showAvatars(){

        for (Avatar a: avatars) {
            a.show();
        }
    }

    private void hideAvatars(){

        for (Avatar a : avatars) {
            a.delete();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                if (p1 == null) {
                    p1 = ResourcePaths.BENNY;
                } else if (p2 == null) {
                    p2 = ResourcePaths.BENNY;
                }
                break;
            case KeyboardEvent.KEY_2:
                if (p1 == null) {
                    p1 = ResourcePaths.PAULO;
                } else if (p2 == null) {
                    p2 = ResourcePaths.PAULO;
                }
                break;
            case KeyboardEvent.KEY_3:
                if (p1 == null) {
                    p1 = ResourcePaths.ROLO;
                } else if (p2 == null) {
                    p2 = ResourcePaths.ROLO;
                }
                break;
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
