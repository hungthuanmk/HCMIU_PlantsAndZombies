package pz.plant;

import java.util.ArrayList;

import com.Position;

import gui.AnimationLoader;

import pz.Bullet;

public class Peashooter2 extends pz.Plant {
	
	private static int _hp = 100;
	private static int _damage = 20;
	private static int _attackInterval = 100;
	private static boolean _attackCoolDown = false;

	public Peashooter2(Position pos) {
		super("Peashooter2", _hp, _damage, _attackInterval, pos);
	}
	
	@Override
	protected void loadAnimation() {
		setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/PeaShooter2/Idle", 30));
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		if ((getAnimation().getFrame() == 16 || getAnimation().getFrame() == 27) && _attackCoolDown == false) {
			bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f) , 
														  (getPos().y + getHeight() * 0.15f), 
														  getDamage()));
			_attackCoolDown = true;
		}
		
		if (getAnimation().getFrame() == 18 || getAnimation().getFrame() == 29) {
			_attackCoolDown = false;
		}
		
	}

	@Override
	public void move() {

	}
}
