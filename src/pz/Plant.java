package pz;

public abstract class Plant extends Character {

	public Plant(String name) {
		super(name);
	}

	protected void move() {
		this.setPos(this.getPos().x + this.getSpeed(), this.getPos().y);
	}

}
