package org.academiadecodigo.offstrings.phases.game;

import org.academiadecodigo.offstrings.Engine;
import org.academiadecodigo.offstrings.configs.ResourcePaths;
import org.academiadecodigo.offstrings.phases.GamePhase;
import org.academiadecodigo.offstrings.phases.end.GameEnd;
import org.academiadecodigo.offstrings.phases.game.gameobjects.Player;
import org.academiadecodigo.offstrings.phases.game.gameobjects.eatables.Eatable;
import org.academiadecodigo.offstrings.phases.game.gameobjects.eatables.EatableFactory;
import org.academiadecodigo.offstrings.phases.game.gameobjects.walls.Wall;
import org.academiadecodigo.offstrings.phases.game.gameobjects.walls.WallFactory;
import org.academiadecodigo.offstrings.phases.game.grid.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Game extends GamePhase {
    private static final int EATABLE_AMOUNT = 30;

    private GameEnd gameEnd;
    private List<Eatable> eatables;
    private List<Wall> walls;
    private String player1path;
    private String player2path;
    private Player player1;
    private Player player2;
    private boolean gameOver;
    private final WallFactory wallFactory;

    public Game(Engine engine) {

        super(engine, ResourcePaths.GAME_MUSIC);
        eatables = null;
        gameOver = false;
        wallFactory = new WallFactory();
    }

    @Override
    public void execute() throws InterruptedException {

        background.draw();
        walls = createWalls();
        eatables = createEatables(EATABLE_AMOUNT);
        player1 = new Player(player1path);
        checkPlayerPosition(player1);
        player2 = new Player(player2path);
        checkPlayerPosition(player2);
        music.play(true);
        music.setLoop(Integer.MAX_VALUE);

        while (!gameOver) {

            Thread.sleep(10);
            if(eatables.size() == 0){
                gameOver = true;
            }
        }

        gameEnd.setWinner(player1.getScore() > player2.getScore()
                ? ResourcePaths.PLAYER1
                : ResourcePaths.PLAYER2);
        gameEnd.setWinnerPicturePath(player1.getScore() > player2.getScore()
                ? player1path
                : player2path);
        engine.setCurrentPhase(gameEnd);
        cleanup();
    }

    private List<Wall> createWalls() {

        List<Wall> toReturn = new LinkedList<>();
        for (Wall wall : wallFactory.getWalls()) {

            wall.show();
            toReturn.add(wall);
        }
        return toReturn;
    }

    private List<Eatable> createEatables(int amount) {

        List<Eatable> toReturn = new LinkedList<>();
        for (int i = 0; i < amount; i++) {

            Eatable e = EatableFactory.createEatable();
            for (Wall w : walls) {

                while (e.isColliding(w)) {

                    e.setPosition(new GridPosition());
                }
            }
            e.show();
            toReturn.add(e);
        }
        return toReturn;
    }

    private void checkPlayerPosition(Player player) {

        for (Wall w : walls) {

            while (player.isColliding(w)) {
                player.setPosition(new GridPosition());
            }
        }

        for (Eatable e : eatables) {

            while (player.isColliding(e)) {
                player.setPosition(new GridPosition());
            }
        }

        player.show();
    }

    private void cleanup() {

        player1.delete();
        player2.delete();
        for (Eatable e : eatables) {
            e.delete();
        }
        eatables = null;
        gameOver = false;
        music.stop();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                player2.moveUp();
                if (checkWallCollision(player2)) {
                   player2.moveDown();
                }
                checkCollision(player2);
                break;
            case KeyboardEvent.KEY_DOWN:
                player2.moveDown();
                if (checkWallCollision(player2)) {
                    player2.moveUp();
                }
                checkCollision(player2);
                break;
            case KeyboardEvent.KEY_LEFT:
                player2.moveLeft();
                if (checkWallCollision(player2)) {
                    player2.moveRight();
                }
                checkCollision(player2);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player2.moveRight();
                if (checkWallCollision(player2)) {
                    player2.moveLeft();
                }
                checkCollision(player2);
                break;
            case KeyboardEvent.KEY_W:
                player1.moveUp();
                if (checkWallCollision(player1)) {
                    player1.moveDown();
                }
                checkCollision(player1);
                break;
            case KeyboardEvent.KEY_S:
                player1.moveDown();
                if (checkWallCollision(player1)) {
                    player1.moveUp();
                }
                break;
            case KeyboardEvent.KEY_A:
                player1.moveLeft();
                if (checkWallCollision(player1)) {
                    player1.moveRight();
                }
                checkCollision(player1);
                break;
            case KeyboardEvent.KEY_D:
                player1.moveRight();
                if (checkWallCollision(player1)) {
                    player1.moveLeft();
                }
                checkCollision(player1);
                break;
        }
    }

    public boolean checkWallCollision(Player player) {

        for (Wall w : walls) {

            if (player.isColliding(w)) {
                return true;
            }
        }
        return false;
    }

    public void checkCollision(Player player) {

        Iterator<Eatable> it = eatables.iterator();
        while (it.hasNext()) {

            Eatable e = it.next();
            if (player.isColliding(e)) {

                player.score(e.getPointsWorth());
                e.delete();
                it.remove();
                if (player.getScore() < 0) {

                    gameOver = true;
                }
            }
        }
    }

    public void setPlayers(String p1, String p2) {

        player1path = p1;
        player2path = p2;
    }

    public void setGameEnd(GameEnd gameEnd) {

        this.gameEnd = gameEnd;
    }
}
