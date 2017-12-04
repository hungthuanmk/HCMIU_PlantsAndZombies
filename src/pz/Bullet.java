package pz;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.Position;

import gui.PZGUI;

public abstract class Bullet {
	private int damage = 0;
	private Animation ani = new Animation();
	private float speed = 0;
	private Position pos;
	private static float scaleFactor = 0.6f;

	public Bullet(int damage, float speed, Position pos) {
		setDamage(damage);
		setSpeed(speed);
		setPos(pos);
		loadAnimation();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Animation getAnimation() {
		return ani;
	}

	public void setAnimation(Animation img) {
		this.ani = img;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public void setPos(float x, float y) {
		this.pos.x = x;
		this.pos.y = y;
	}
	
	public float getWidth() {
		return getAnimation().getWidth() * scaleFactor * PZGUI.resolutionRateWidth ;
	}
	
	public float getHeight() {
		return getAnimation().getHeight() * scaleFactor * PZGUI.resolutionRateHeight ;
	}
	
	public void draw() {
		getAnimation().draw(getPos().x, getPos().y, getWidth(), getHeight());
	}

	public abstract void move();
	public abstract void attack(ArrayList<Zombie> zombieList);
	protected abstract void loadAnimation();

}
