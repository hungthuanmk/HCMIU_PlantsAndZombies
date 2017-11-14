package pz;

import org.newdawn.slick.Animation;

import com.Position;

public abstract class Plant extends Character {
	
	private Animation idle = new Animation();
	
	private int attackInterval = 0;
	private int framePassed = 0;

	public Plant(String name, int hp, int damage, int attackInterval, Position pos) {
		super(name, hp, pos);
		loadAnimation(); 
		setDamage(damage);
		setAttackInterval(attackInterval);
		setFramePassed(attackInterval);
	}

	public void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

	public Animation getIdleAni() {
		return idle;
	}

	public void setIdleAni(Animation ani) {
		this.idle = ani;
	}
	
	protected abstract void loadAnimation();

	public int getFramePassed() {
		return framePassed;
	}

	public void setFramePassed(int framePassed) {
		this.framePassed = framePassed;
	}

	public int getAttackInterval() {
		return attackInterval;
	}

	public void setAttackInterval(int attackInterval) {
		this.attackInterval = attackInterval;
	}

}
