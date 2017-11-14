package pz.bullet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

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

	public BPeashooter(int x, int y) {
		super(damage, speed, new Position(x, y));
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
}
