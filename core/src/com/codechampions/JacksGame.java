package com.codechampions;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;

import java.util.Iterator;

public class JacksGame implements ApplicationListener {

	public class MyActor extends Actor {
		Texture texture = new Texture(Gdx.files.internal("data/jet.png"));
		public boolean started = false;

		public MyActor() {
			setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());  //This tells the InputListener where the actor is located, that way it knows when you clikc on it
		}

		@Override
		public void draw(Batch batch, float alpha) {
			batch.draw(texture, this.getX(), getY(), this.getOriginX(), this.getOriginY(), this.getWidth(),
					this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0,
					texture.getWidth(), texture.getHeight(), false, false);
		}

		@Override
		public void act(float delta) {
			for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();) {
				iter.next().act(delta);
			}
		}

	}

	private Stage stage;

	@Override
	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		MyActor myActor = new MyActor();

		MoveToAction moveAction = new MoveToAction();
		RotateToAction rotateAction = new RotateToAction();
		ScaleToAction scaleAction = new ScaleToAction();

		moveAction.setPosition(300f, 0f);  //This is where the jet will move to.
		moveAction.setDuration(5f); //this is how long it will take to get there
		rotateAction.setRotation(90f);
		rotateAction.setDuration(5f);
		scaleAction.setScale(0.5f);
		scaleAction.setDuration(5f);

		myActor.addAction(moveAction);  //this assigns the action to the actor
		myActor.addAction(rotateAction);
		myActor.addAction(scaleAction);

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