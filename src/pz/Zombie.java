package pz;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import gui.PZGUI;

public abstract class Zombie extends Character {
	private int speed = 100;
	
	public Animation animation = new Animation();
	public Animation walk = new Animation();
	public Animation attack = new Animation();
	
	
	public Zombie(String name) throws SlickException {
		super(name);
		loadAni();
		animation = walk;
			
	}
	
	public void setAnimationToWalk(){
		this.animation = walk;
	}
	public void setAnimationToAttack(){
		this.animation = attack;
	}
	public void loadWalkAni() throws SlickException{		
		
	}
	
	public void loadAttackAni() throws SlickException{
		
	}

	public void loadAni() throws SlickException{
		
	}
	
	protected void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

}
