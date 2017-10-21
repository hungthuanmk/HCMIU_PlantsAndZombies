package pz;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Plant extends Character {

	public Plant(String name) {
		super(name);
	}

	protected void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

}
