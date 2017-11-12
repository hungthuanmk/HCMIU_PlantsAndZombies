package pz.bullet;

import com.Position;

import pz.Bullet;

public class BSunFlower extends Bullet {
	
	// y = -5x + 10;
	private float x = 2f;
	private float y = -5*x + 10;

	public BSunFlower(int damage, int speed, Position pos) {
		super(damage, speed, pos);
		// TODO Auto-generated constructor stub
	}

	
	public void move() {
		y = -5*x + 10;
		if (x > -2f) 
			x -= 0.1f;
	}

	
	public void loadAnimation() {
		// TODO Auto-generated method stub

	}

}
