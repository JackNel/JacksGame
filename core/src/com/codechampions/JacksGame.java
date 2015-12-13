package com.codechampions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Timer;

public class JacksGame implements ApplicationListener {
	SpriteBatch batch;
	Texture texture;
	Sprite sprite;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();

		texture = new Texture(Gdx.files.internal("data/0001.png"));
		sprite = new Sprite(texture);
		sprite.setPosition(w/2 - sprite.getWidth()/2, h/2 - sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
					Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
			sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
					Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		}
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

}
