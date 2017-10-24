package pz;

import java.util.ArrayList;

import com.Position;

abstract class Character {

	private String name;
	private Position pos;

	private int hp = 0;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	private int damage = 0;
	private int speed = 0;

	// private int attackInterval = 100;

	public Character(String name) {
		setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String S) {
		this.name = S;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public void setPos(int x, int y) {
		this.pos.x = x;
		this.pos.y = y;
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

	public abstract void attack(ArrayList<pz.Bullet> bulletArrayList);

}
