package pz.zombie;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;
import pz.Zombie;

public class FemaleZombie extends Zombie {

	private static int hp = 100;
	private static float speed = 0.4f;

	public FemaleZombie(Position pos) {
		super("FemaleZombie", hp, speed, pos);
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {

	}

	@Override
	public void move() {
		setPos(getPos().x - getSpeed(), getPos().y);
	}

	@Override
	protected void loadAnimation() {
		try {
			for (int i = 1; i <= 10; i++)
				getAnimation().addFrame(new Image("res/ZombieTest/female/Walk (" + i + ").png"), 110);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
