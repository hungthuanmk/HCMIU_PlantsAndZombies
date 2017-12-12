package pz.plant;

import java.util.ArrayList;

import com.Position;

import gui.AnimationLoader;
import pz.Bullet;

public class Wallnut extends pz.Plant {
	
	private static int hp = 2000;
	private static int attackInterval = 0;

	public Wallnut(Position pos) {
		super("Wallnut", hp, 0, attackInterval, pos);
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		
	}

	@Override
	public void move() {
		
	}

	@Override
	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/WallNut/Idle2", 100));
	}

}
