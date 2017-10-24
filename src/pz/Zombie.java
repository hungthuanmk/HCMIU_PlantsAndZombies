package pz;

public abstract class Zombie extends Character {

	public Zombie(String name) {
		super(name);
	}

	protected void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

}
