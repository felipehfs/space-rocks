package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Explosion extends BaseActor{
    public Explosion(float x, float y, Stage stage) {
        super(x, y, stage);
        loadAnimationFromSheet("assets/explosion.png", 6,6, 0.03f, false);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (isAnimationFinished()) {
            remove();
        }
    }
}
