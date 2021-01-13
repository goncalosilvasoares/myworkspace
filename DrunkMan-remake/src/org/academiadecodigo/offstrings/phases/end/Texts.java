package org.academiadecodigo.offstrings.phases.end;

import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Texts {

    public static final int HASWON_X = 430;
    public static final int HASWON_Y = 555;
    public static final double PLAYER_X = 594.5;
    public static final int PLAYER_Y = 105;
    public static final int BTOBACK_X = 496;
    public static final int BTOBACK_Y = 645;

    private final Picture player;
    private final Picture hasWon;
    private final Picture bToBack;

    public Texts(String winnerText){

        player = new Picture( PLAYER_X, PLAYER_Y, winnerText);
        hasWon = new Picture(HASWON_X, HASWON_Y, ResourcePaths.HAS_WON_TEXT);
        bToBack = new Picture(BTOBACK_X, BTOBACK_Y,ResourcePaths.B_TO_BACK_TEXT);
    }

    public void draw(){

        hasWon.draw();
        player.draw();
        bToBack.draw();
    }

    public void delete(){

        hasWon.delete();
        player.delete();
        bToBack.delete();
    }
}
