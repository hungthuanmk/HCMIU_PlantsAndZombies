package pz.plant;

import java.util.ArrayList;

import com.Position;

import gui.AnimationLoader;

import pz.Bullet;
import pz.bullet.BBloomerang;

public class Bloomerang extends pz.Plant {
	
	private static int hp = 100;
	private static int damage = 5;
	private static int attackInterval = 500;

	public Bloomerang(Position pos) {
		super("Bloomerang", hp, damage, attackInterval, pos);
	}

	@Override
	public void attack(ArrayList<Bullet> bulletList) {
		if (getAnimation().getFrame() == 14 && getFramePassed() > getAttackInterval()) {
			bulletList.add(new BBloomerang(getPos().x + getWidth()/2f, getPos().y + getHeight()*0.33f, getDamage()));
			setFramePassed(0);
		}
		setFramePassed(getFramePassed()+1);
	}

	@Override
	public void move() {
		
	}

	@Override
	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/Bloomerang/Idle", 150));
	}

}
