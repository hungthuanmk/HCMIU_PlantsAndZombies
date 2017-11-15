package pz.plant;

import java.util.ArrayList;

//import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;

//import pz.Bullet.*;

public class Peashooter extends pz.Plant {
	
	private static int hp = 100;
	private static int damage = 20;
	private static int attackInterval = 300;

	public Peashooter(Position pos) {
		super("Peashooter", hp, damage, attackInterval, pos);
	}
	
	@Override
	protected void loadAnimation() {
		try {
			for (int i=1; i<=30; i++)
				getIdleAni().addFrame(new Image("res/Plants/PeaShooter/Idle/"+i+".png"), 30);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		if (getFramePassed() > getAttackInterval()) {
			bulletArrayList.add(new pz.bullet.BPeashooter(getPos().x + 100, getPos().y+20, damage));
			setFramePassed(0);
		}
		setFramePassed(getFramePassed()+1)	;
	}
}
