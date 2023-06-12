package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

public class BaseGame extends Game {

    private static BaseGame baseGame;

    public BaseGame() {
        baseGame = this;
    }

    @Override
    public void create() {
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public static void setActiveScreen(BaseScreen s) {
        baseGame.setScreen(s);
    }
}
