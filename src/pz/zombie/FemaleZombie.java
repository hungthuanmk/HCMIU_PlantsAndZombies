package pz.zombie;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Plant;
import pz.Zombie;

public class FemaleZombie extends Zombie {

	private static int hp = 100;
	private static int damage = 100;
	private static int attackInterval = 50;
	private static float speed = 0.4f;
	//private static float scaleFactor = 0.2f;

	public FemaleZombie(Position pos) {
		super("FemaleZombie", hp, damage, attackInterval, speed, pos);
	}

	@Override
	public void move() {
		setPos(getPos().x - getSpeed(), getPos().y);
	}

	@Override
	protected void loadAnimation() {
		try {
			for (int i = 1; i <= 10; i++)
				getAnimation().addFrame(new Image("res/ZombieTest/female/Walk (" + i + ").png").getFlippedCopy(true, false), 110);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attack(Plant[][] plane) {
		
	}

}
