package pz;

import org.newdawn.slick.Animation;

import com.Position;

import gui.PZGUI;

public abstract class Zombie extends Character {

	private Animation ani = new Animation();
	
	private float scaleFactor = 0.3f;
	
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
	
	public float getWith() {
		return getAnimation().getWidth() * scaleFactor * PZGUI.resolutionRateWidth ;
	}
	
	public float getHeight() {
		return getAnimation().getHeight() * scaleFactor * PZGUI.resolutionRateHeight ;
	}
	
	public void draw() {
		getAnimation().draw(getPos().x, getPos().y, getWith(), getHeight());
	}
	
	protected abstract void loadAnimation();

}
