package com.mygdx.game;

public class SpaceRocks extends BaseGame {

	@Override
	public void create() {
		super.create();
		setActiveScreen(new LevelScreen());
	}
}
