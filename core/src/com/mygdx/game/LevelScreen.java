package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class LevelScreen extends BaseScreen{

    private Spaceship spaceship;
    private boolean gameOver;
    @Override
    public void initialize() {
        BaseActor space = new BaseActor(0, 0, mainStage);
        space.loadTexture("assets/space.png");
        space.setSize(800, 600);
        BaseActor.setWorldBounds(space);

        spaceship = new Spaceship(400, 200, mainStage);

        new Rock(600, 500, mainStage);
        new Rock(600, 300, mainStage);
        new Rock(600, 100, mainStage);
        new Rock(400, 100, mainStage);
        new Rock(200, 100, mainStage);
        new Rock(200, 300, mainStage);
        new Rock(200, 500, mainStage);
        new Rock(400, 500, mainStage);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.X) {
            spaceship.warp();
        }

        if (keycode == Input.Keys.SPACE) {
            spaceship.shoot();
        }

        return false;
    }

    @Override
    public void update(float deltaTime) {
        for (BaseActor rockActor: BaseActor.getList(mainStage, "com.mygdx.game.Rock")) {
            if (rockActor.overlaps(spaceship)) {
                if (spaceship.shieldPower <= 0) {
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(spaceship);
                    spaceship.remove();
                    spaceship.setPosition(-1000, -1000);

                    BaseActor messageLoose = new BaseActor(0, 0, mainStage);
                    messageLoose.loadTexture("assets/message-lose.png");
                    messageLoose.centerAtPosition(400, 300);
                    messageLoose.setOpacity(0);
                    messageLoose.addAction(Actions.fadeIn(1));
                    gameOver = true;
                }  else {
                    spaceship.shieldPower -= 34;
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(rockActor);
                    rockActor.remove();
                }
            }

            for(BaseActor laserActor : BaseActor.getList(mainStage, "com.mygdx.game.Laser")) {
                if (laserActor.overlaps(rockActor)) {
                    Explosion boom = new Explosion(0, 0, mainStage);
                    boom.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                }
            }
        }

        if (!gameOver && BaseActor.count(mainStage, "com.mygdx.game.Rock") == 0) {
            BaseActor winMessage = new BaseActor(0, 0, uiStage);
            winMessage.loadTexture("assets/message-win.png");
            winMessage.centerAtPosition(400, 300);
            winMessage.setOpacity(0);
            winMessage.addAction(Actions.fadeIn(1));
            gameOver = true;
        }
    }
}
