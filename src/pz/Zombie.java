package pz;

import com.Position;

public abstract class Zombie extends Character {

	public Zombie(String name, int hp, Position pos) {
		super(name, hp, pos);
	}

	protected void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

}
