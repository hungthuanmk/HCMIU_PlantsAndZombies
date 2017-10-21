package pz.bullet;

import org.newdawn.slick.Animation;

import com.Position;

public class BPeaShooter extends pz.Bullet {

	public BPeaShooter() {
		super(new Animation(), 10, 20, new Position(0, 0));
	}

	protected void move() {
		this.setPos(getSpeed(), this.getPos().y);
	}
}
