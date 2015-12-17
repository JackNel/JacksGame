package com.codechampions;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Pool;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

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

		final MyActor myActor = new MyActor();
		Pool<MoveToAction> actionPool = new Pool<MoveToAction>() {
			protected MoveToAction newObject() {
				return new MoveToAction();
			}
		};

		MoveToAction moveAction = actionPool.obtain();
		moveAction.setDuration(5f);
		moveAction.setPosition(300f, 0);

		myActor.addAction(moveAction);

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