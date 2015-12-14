package com.codechampions;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

import java.util.HashMap;
import java.util.Map;


public class JacksGame implements ApplicationListener, GestureDetector.GestureListener {
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture texture;
	Sprite sprite;


	@Override
	public void create() {
		camera = new OrthographicCamera(1280, 720);
		batch = new SpriteBatch();

		texture = new Texture(Gdx.files.internal("data/Toronto2048wide.jpg"));
		texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		final Sound mp3Sound = Gdx.audio.newSound(Gdx.files.internal("soundFiles/14 Death Around The Corner.mp3"));
		final Sound wavSound = Gdx.audio.newSound(Gdx.files.internal("soundFiles/bossdeath.wav"));
		Sound oggSound = Gdx.audio.newSound(Gdx.files.internal("soundFiles/error.ogg"));

		long id = mp3Sound.play();
		mp3Sound.setPan(id, 1f, 1f);

		sprite = new Sprite(texture);
		sprite.setOrigin(0, 0);
		sprite.setPosition(- sprite.getWidth()/2, - sprite.getHeight()/2);

		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
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

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		camera.translate(deltaX, 0);
		camera.update();
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
}