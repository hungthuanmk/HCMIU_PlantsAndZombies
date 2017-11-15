package pz;

import org.newdawn.slick.Animation;

import com.Position;

public abstract class Zombie extends Character {

	private Animation ani = new Animation();
	
	public Zombie(String name, int hp, float speed, Position pos) {
		super(name, hp, pos);
		setSpeed(speed);
		loadAnimation();
	}

	public Animation getAnimation() {
		return ani;
	}

	public void setAnimation(Animation ani) {
		this.ani = ani;
	}
	
	protected abstract void loadAnimation();

}
