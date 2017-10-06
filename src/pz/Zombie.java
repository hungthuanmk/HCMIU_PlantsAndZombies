package pz;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import gui.PZGUI;

public class Zombie extends Character {
	private int speed = 100;
	public Animation zombie_ani = new Animation();
	public Animation zombie_walk = new Animation();
	public Animation zombie_attack = new Animation();
	
	public Zombie(String name) throws SlickException {
		super(name);
		loadAni();
		//zombie_ani = zombie_walk;
			
	}
	
	public void draw() {
		zombie_walk.draw(Mouse.getX(), PZGUI.height - Mouse.getY());
	}
	
	public void loadWalkAni() throws SlickException{		
		zombie_walk.addFrame(new Image("res/zombiebie/male/Walk (1).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (2).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (3).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (4).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (5).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (6).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (7).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (8).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (9).png"), speed);
		zombie_walk.addFrame(new Image("res/zombie_walkbie/male/Walk (10).png"), speed);
	}
	
	public void loadAttackAni() throws SlickException{
		zombie_attack.addFrame(new Image("res/zombiebie/male/Attack (1).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (2).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (3).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (4).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (5).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (6).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (7).png"), speed);
		zombie_attack.addFrame(new Image("res/zombie_attackbie/male/Attack (8).png"), speed);
	}

	public void loadAni() throws SlickException{
		loadWalkAni();
		loadAttackAni();
	}

}
