package pz;

import org.newdawn.slick.Animation;

import com.Position;

public abstract class Plant extends Character {
	
	private Animation idle = new Animation();

	public Plant(String name, int hp, Position pos) {
		super(name, hp, pos);
	}

	protected void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

	public Animation getIdleAni() {
		return idle;
	}

	public void setIdleAni(Animation ani) {
		this.idle = ani;
	}
	
	public abstract void loadAnimation();

}
