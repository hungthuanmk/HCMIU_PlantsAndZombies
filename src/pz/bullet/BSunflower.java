package pz.bullet;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;
import pz.Zombie;

public class BSunflower extends Bullet {
	
	// y = -5x + 10;
	private float x;
	private float y;
	private int time = 0;
	private float delta, theta;
	private static int damage = 0;
	private static int speed = 10;

	public BSunflower(Position pos) {
		super(damage, speed, pos);
		x = getPos().x;
		delta = getPos().x;
		theta = getPos().y;
	}
	
	public void move() {
		if (time % 10 == 0) {
			y = -1*(x-delta + 9)*(x-delta + 9) + 50 + theta;
			if (x > delta - 9) 
				x--;
			setPos(x, y);
		}	
		time++;
	}
	
	protected void loadAnimation() {
		try {
			for (int i=1; i<=6; i++)
				getAnimation().addFrame(new Image("res/Sun Sprite/Sun "+i+".png").getScaledCopy(0.1f), 200);
		} catch (SlickException e) {
			e.printStackTrace();
		}	
	}
	
	public void attack(ArrayList<Zombie>[] zombieList) {
		
	}

}
