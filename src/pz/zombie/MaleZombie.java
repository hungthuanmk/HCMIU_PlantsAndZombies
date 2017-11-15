package pz.zombie;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;
import pz.Zombie;

public class MaleZombie extends Zombie {

	private static int hp = 100;
	private static int speed = 1;

	public MaleZombie(Position pos) {
		super("MaleZombie", hp, speed, pos);
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
				getAnimation().addFrame(new Image("res/ZombieTest/male/Walk (" + i + ").png"), 80);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
