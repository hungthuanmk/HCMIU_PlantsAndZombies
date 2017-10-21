package pz;

import org.newdawn.slick.Image;

public abstract class Bullet {
	private int damage = 0;
	private Image img;
	private int speed = 0;
	
	
	public Bullet(Image img, int damage, int speed) {
		this.setDamage(damage);
		this.setImg(img);
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
	
	protected abstract void move();

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
}
