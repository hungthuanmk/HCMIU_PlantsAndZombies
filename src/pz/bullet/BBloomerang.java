package pz.bullet;

import java.util.ArrayList;

import com.Position;

import gui.AnimationLoader;
import pz.Bullet;
import pz.Zombie;

public class BBloomerang extends Bullet {

	private static int   damage 	= 1;
	private static float speed		= 0.01f;
	private static float range		= 400f;
	
	private Zombie justShoot = null;
	
	private float initX, initY;
	private float x, y;
	//private static Animation ani = new Animation();
	
	protected void loadAnimation() { 
		setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/Bloomerang/Bullet", 20));
	}

	private void initMoveEquation() {
		initX = getPos().x;
		initY = getPos().y;
		
		//y = -0.9f;
		y = (float) -Math.sqrt( (range - 1f) / 100f);
	}
	
	public BBloomerang(float x, float y) {
		super(damage, speed, new Position(x, y));
		initMoveEquation();
		loadAnimation();	
		
	}
	
	public BBloomerang(float x, float y, int _damage, float _speed) {
		super(_damage, _speed, new Position(x, y));
		initMoveEquation();
		loadAnimation();
	}
	
	public BBloomerang(float f, float y, int _damage) {
		super(_damage, speed, new Position(f, y));
		initMoveEquation();
		loadAnimation();
	}
	
	public BBloomerang(Position pos) {
		super(damage, speed, pos);
		initMoveEquation();
		loadAnimation();
	}
	
	public BBloomerang(Position pos, int _damage, int _speed) {
		super(_damage, _speed, pos);
		initMoveEquation();
		loadAnimation();
	}

	public void move() {
		x  = -(10.0f*y)*(10.0f*y) + range;
		if (x > 0.0f) {
			setPos(initX + x, initY + y);
		}
		y += getSpeed();
		if (Math.round(x) == range)
			justShoot = null;
	}

	
	
	@Override
	public void attack(ArrayList<Zombie> zombieList, ArrayList<Bullet> bulletList) {
		if (x <= 0) {
			bulletList.remove(this);
			return;
		}
		
		for (Zombie z : zombieList) {
			//if (z == null) continue;
			if ( !z.equals(justShoot) ) {
				if (Position.isIntersect(this, z)) {
					z.setHp(z.getHp() - getDamage());
					justShoot = z;
					return;			
				}
			}
			
		}
	}
	
}
