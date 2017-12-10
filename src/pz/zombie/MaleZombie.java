package pz.zombie;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import gui.AnimationLoader;
import pz.Bullet;
import pz.Plant;
import pz.Zombie;

public class MaleZombie extends Zombie {

	private static int hp = 100;
	private static int damage = 100;
	private static int attackInterval = 100;
	private static float speed = 0.4f;
	//private static float scaleFactor = 0.2f;

	public MaleZombie(Position pos) {
		super("MaleZombie", hp, damage, attackInterval, speed, pos);
	}	

	@Override
	public void move() {
		setPos(getPos().x - getSpeed(), getPos().y);
	}

	@Override
	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/ZombieTest/MaleZombie/walk", 110));
	}

	@Override
	public void attack(Plant[][] plant, ArrayList<Bullet> bulletList) {
		boolean hit = false;
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				if (plant[i][j] != null) {
					if (Position.isInteract(this, plant[i][j])) {
						hit = true;
						setSpeed(0);
						//setAnimation(AnimationLoader.getAnimationFromFolder("res/ZombieTest/MaleZombie/attack", 110));
						//System.out.println("touched");
						if (getFramePassed() >= getAttackInterval()) {
							plant[i][j].setHp(plant[i][j].getHp() - getDamage());
							setFramePassed(0);
						}
						setFramePassed(getFramePassed()+1);
					}
				}			
			}
		}
		if (hit == false) setSpeed(speed);
	}

}
