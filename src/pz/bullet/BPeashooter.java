package pz.bullet;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;
import pz.Zombie;
import pz.zombie.NhiZombie;

/**
 * 
 * @author Nguyen Phan Hung Thuan
 *
 */
public class BPeashooter extends pz.Bullet {
	
	private static int   damage 	= 10;
	private static float speed		= 4f;
	//private static Animation ani = new Animation();
	
	protected void loadAnimation() { 
		try {
			getAnimation().addFrame(new Image("res/Plants/PeaShooter/Bullet/normal/Pea.png"), 10);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public BPeashooter(float x, float y) {
		super(damage, speed, new Position(x, y));
		loadAnimation();
	}
	
	public BPeashooter(float x, float y, int _damage, float _speed) {
		super(_damage, _speed, new Position(x, y));
		loadAnimation();
	}
	
	public BPeashooter(float f, float y, int _damage) {
		super(_damage, speed, new Position(f, y));
		loadAnimation();
	}
	
	public BPeashooter(Position pos) {
		super(damage, speed, pos);
		loadAnimation();
	}
	
	public BPeashooter(Position pos, int _damage, int _speed) {
		super(_damage, _speed, pos);
		loadAnimation();
	}

	public void move() {
		setPos(getPos().x + getSpeed(), getPos().y);
	}

	@Override
	public void attack(ArrayList<Zombie> zombieList, ArrayList<Bullet> bulletList) {
		for (Zombie z : zombieList) {
			//if (z == null) continue;
			if (Position.isIntersect(this, z)) {
				z.setHp(z.getHp() - getDamage());
				if (z instanceof NhiZombie)
					z.setDamage(getDamage() + 10);
				//System.out.println("hit");
				bulletList.remove(this);
				return;
			}
		}
	}
}
