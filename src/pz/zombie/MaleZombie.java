package pz.zombie;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Plant;
import pz.Zombie;

public class MaleZombie extends Zombie {

	private static int hp = 100;
	private static int damage = 100;
	private static int attackInterval = 100;
	private static float speed = 0.4f;
	private static float scaleFactor = 0.2f;

	public MaleZombie(Position pos) {
		super("MaleZombie", hp, damage, attackInterval, speed, pos);
	}	

	@Override
	public void move() {
		setPos(getPos().x - getSpeed(), getPos().y);
	}

	@Override
	protected void loadAnimation() {
		try {
			for (int i = 1; i <= 10; i++)
				getAnimation().addFrame(new Image("res/ZombieTest/male/Walk (" + i + ").png"), 110);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attack(Plant[][] plant) {
		for (int i=0; i<5; i++)
			for (int j=0; j<9; j++) {
				if (plant[i][j] != null)
					if (Position.isInteract(this, plant[i][j])) 
						System.out.println("touched");
			}
	}

}
