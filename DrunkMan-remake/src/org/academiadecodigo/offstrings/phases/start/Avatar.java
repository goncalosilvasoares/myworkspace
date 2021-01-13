package org.academiadecodigo.offstrings.phases.start;

import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Avatar {
    private final Picture representation;
    private final Text text;

    public Avatar(int x, int y, String picturePath, int key) {

        representation = new Picture(x, y, ResourcePaths.PATH_IMAGES + picturePath + ResourcePaths.AVATAR_EXTENSION);
        text = new Text(x, y + 200, "Pick <"+picturePath+"> by pressing " + key +"!");
    }

    public void show(){

        representation.draw();
        text.draw();
    }

    public void delete(){

        representation.delete();
        text.delete();
    }
}
