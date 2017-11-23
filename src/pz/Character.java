package pz;

import java.util.ArrayList;

import com.Position;

import gui.PZGUI;

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
	private float speed = 0;

	// private int attackInterval = 100;

	public Character(String name, int hp, Position pos) {
		setName(name);
		setHp(hp);
		setPos(pos);
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

	public void setPos(float x, float y) {
		this.pos.x = x;
		this.pos.y = y;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public abstract void move();
	public abstract void attack(ArrayList<pz.Bullet> bulletArrayList);

}
