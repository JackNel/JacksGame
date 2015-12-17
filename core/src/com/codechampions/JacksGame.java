package com.codechampions;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;

public class JacksGame implements ApplicationListener {

	public class MyActor extends Actor {
		Texture texture = new Texture(Gdx.files.internal("data/jet.png"));
		float actorX = 0, actorY = 0;
		public boolean started = false;

		public MyActor() {
			setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());  //This tells the InputListener where the actor is located, that way it knows when you clikc on it
			addListener(new InputListener() {
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((MyActor)event.getTarget()).started = true;
					return true;
				}
			});
		}

		@Override
		public void draw(Batch batch, float alpha) {
			batch.draw(texture, actorX, actorY);
		}

		@Override
		public void act(float delta) {  //The act method is similar to update(), it tells the actor(s) what to do, in this case, add 5 time the actor's x location
			if(started) {
				actorX += 5;
			}
		}
	}

	private Stage stage;

	@Override
	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		MyActor myActor = new MyActor();
		myActor.setTouchable(Touchable.enabled);
		stage.addActor(myActor);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
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