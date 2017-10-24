package pz.bullet;

import org.newdawn.slick.Animation;

import com.Position;

public class BPeaShooter extends pz.Bullet {

	public BPeaShooter(int x, int y) {
		super(new Animation(), 10, 20, new Position(x, y));
	}
	
	public BPeaShooter(Position pos) {
		super(new Animation(), 10, 20, pos);
	}

	protected void move() {
		this.setPos(getSpeed(), this.getPos().y);
	}
}
