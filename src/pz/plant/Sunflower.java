package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.bullet.BSunflower;

public class Sunflower extends pz.Plant {
	
	private static int hp = 100;
	private static int attackInterval = 500;
	private static float scaleFactor = 0.2f;
	//private static int damage = 0;

	public Sunflower(Position pos) {
		super("Sunflower", hp, 0, attackInterval, pos);
	}

	protected void loadAnimation() {
		try {
			for (int i=1; i<=30; i++)
				getAnimation().addFrame(new Image("res/Plants/SunFlower/Idle/"+i+".png"), 50);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void attack(ArrayList<pz.Bullet> bulletArrayList) {
		if (getFramePassed() > getAttackInterval()) {
			bulletArrayList.add(new BSunflower(new Position(getPos().x, getPos().y)));
			setFramePassed(0);
		}
		setFramePassed(getFramePassed()+1);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
