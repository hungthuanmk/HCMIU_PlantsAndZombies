package pz.zombie;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.Position;

import gui.AnimationLoader;
import pz.Bullet;
import pz.Plant;
import pz.Zombie;

public class NhiZombie extends Zombie {

	private static int hp = 1500;
	private static int damage = 10;
	private static int attackInterval = 50;
	private static float speed = 0.4f;
	
	private Animation attackAni;
	private Animation walkAni;
	private Animation deadAni;
	
	public NhiZombie(Position pos) {
		super("FemaleZombie", hp, damage, attackInterval, speed, pos);
		attackAni = AnimationLoader.getAnimationFromFolder("res/ZombieTest/NhiZombie/attack", 110);
		deadAni = AnimationLoader.getAnimationFromFolder("res/ZombieTest/NhiZombie/dead", 110);
		walkAni = getAnimation();
	}

	@Override
	public void move() {
		setPos(getPos().x - getSpeed(), getPos().y);
	}

	@Override
	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/ZombieTest/NhiZombie/walk", 110));
	}

	@Override
	public void attack(Plant[][] plant, ArrayList<Bullet> bulletList) {
		boolean hit = false;
		for (int i=0; i<5; i++) {
			for (int j=0; j<9; j++) {
				if (plant[i][j] != null) {
					if (Position.isInteract(this, plant[i][j])) {
						hit = true;
						setAnimation(attackAni);
						setSpeed(0);
						//System.out.println("touched");
						if (getFramePassed() >= getAttackInterval()) {
							plant[i][j].setHp(plant[i][j].getHp() - getDamage());
							setFramePassed(0);
						}
						setFramePassed(getFramePassed()+1);
						return;
					}
				}			
			}
		}
		if (hit == false) {
			setAnimation(walkAni);
			setSpeed(speed);
		}
	}
	
	@Override
	public boolean dead() {
		if (getAnimation() != deadAni) {
			setAnimation(deadAni);
		}
		System.out.println(getAnimation().getFrame());
		if (getAnimation().getFrame() == getAnimation().getFrameCount() - 1)
			return true;
		return false;
	}

}
