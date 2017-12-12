package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

import com.Position;

import gui.AnimationLoader;
import gui.SunUI;
import pz.Bullet;
import pz.sun.SunSunflower;

public class Sunflower extends pz.Plant {
	
	private static int hp = 100;
	private static int attackInterval = 300;
	@SuppressWarnings("unused")
	private static float scaleFactor = 0.2f;

	public Sunflower(Position pos) {
		super("Sunflower", hp, 0, attackInterval, pos);
	}

	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/SunFlower/Idle", 50));
	}
	
	public void attack(ArrayList<Bullet> bulletArrayList) {
		if (getFramePassed() > getAttackInterval()) {
			try {
				SunUI.getSunManager().add(new SunSunflower(SunUI.getSunAni(), getPos().x, getPos().y + getHeight()/3f));
			} catch (SlickException e) {
				e.printStackTrace();
			}
			setFramePassed(0);
		}
		setFramePassed(getFramePassed()+1);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
