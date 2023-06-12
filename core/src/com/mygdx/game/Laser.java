package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Laser extends BaseActor{
    public Laser(float x, float y, Stage stage) {
        super(x, y, stage);
        loadTexture("assets/laser.png");
        addAction(Actions.delay(1));
        addAction(Actions.after(Actions.fadeOut(0.5f)));
        addAction(Actions.after(Actions.removeActor()));

        setSpeed(400);
        setMaxSpeed(400);
        setDeceleration(0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        applyPhysics(delta);
        wrapAroundWorld();
    }
}
