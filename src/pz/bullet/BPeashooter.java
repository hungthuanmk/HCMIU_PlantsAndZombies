package pz.bullet;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Zombie;

public class BPeashooter extends pz.Bullet {
	
	private static int damage 	= 10;
	private static int speed	= 5;
	//private static Animation ani = new Animation();
	
	protected void loadAnimation() { 
		try {
			getAnimation().addFrame(new Image("res/Plants/PeaShooter/Pea.png"), 10);
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
	
	public boolean attack(ArrayList<Zombie> zombieList) {
		//for (ArrayList<Zombie> zomList : zombieList)
			for (Zombie z : zombieList) {
				if (Position.isInteract(this, z)) {
					z.setHp(z.getHp() - getDamage());
					
					System.out.println("hit");
					return true;
				}		
			}
			return false;
	}
}
