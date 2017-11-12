package pz.bullet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

public class BPeaShooter extends pz.Bullet {
	
	private static int damage 	= 10;
	private static int speed	= 5;
	//private static Animation ani = new Animation();
	
	public void loadAnimation() {
		try {
			getAnimation().addFrame(new Image("res/Plants/PeaShooter/Pea.png"), 10);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public BPeaShooter(int x, int y) {
		super(damage, speed, new Position(x, y));
		//loadAnimation();
	}
	
	public BPeaShooter(Position pos) {
		super(damage, speed, pos);
		//loadAnimation();
	}

	public void move() {
		setPos(getPos().x + getSpeed(), getPos().y);	
	}
}
