package game;

public class Bullet {
	private int damage = 0;
	private String img;
	private int speed = 0;
	
	
	public Bullet(String img, int damage, int speed) {
		this.setDamage(damage);
		this.img = img;
		this.setSpeed(speed);
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
