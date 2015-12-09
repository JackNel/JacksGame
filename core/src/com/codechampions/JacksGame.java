package com.codechampions;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JacksGame implements ApplicationListener {
	SpriteBatch batch;
	BitmapFont font;
	Texture texture;
	Sprite sprite;
	Pixmap pixmap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		//Create a Pixmap that is 256x128 using 8 bytes for R, G, B, and A
		pixmap = new Pixmap(256, 128, Pixmap.Format.RGBA8888);

		//Fill pixmap red
		pixmap.setColor(Color.RED);
		pixmap.fill();

		//Draw 2 lines forming an X
		pixmap.setColor(Color.BLACK);
		pixmap.drawLine(0, 0, pixmap.getWidth()-1, pixmap.getHeight()-1);
		pixmap.drawLine(0, pixmap.getHeight()-1, pixmap.getWidth()-1, 0);

		//Draw a circle about the middle
		pixmap.setColor(Color.YELLOW);
		pixmap.drawCircle(pixmap.getWidth()/2, pixmap.getHeight()/2, pixmap.getHeight()/2-1);

		texture = new Texture(pixmap);
		//Since we have passed the pixmap to texture, we can dispose of pixmap
		pixmap.dispose();

		sprite = new Sprite(texture);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.setPosition(0, 0);
		sprite.draw(batch);
		sprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

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
