package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;

//import pz.Bullet.*;

public class Peashooter3 extends pz.Plant {
	
	private static int _hp = 100;
	private static int _damage = 20;
	private static int _attackInterval = 100;
	//private static float scaleFactor = 0.2f;
	public Peashooter3(Position pos) {
		super("Peashooter3", _hp, _damage, _attackInterval, pos);
	}
	
	@Override
	protected void loadAnimation() {
		try {
			for (int i=1; i<=30; i++)
				getAnimation().addFrame(new Image("res/Plants/PeaShooter/Idle/"+i+".png"), 30);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		if (getFramePassed() == getAttackInterval()) {
			bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f) , 
														  (getPos().y + getHeight() * 0.15f), 
														  getDamage()));
		}
		else
			if (getFramePassed() == getAttackInterval()+10) {
				bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f) , 
						  									  (getPos().y + getHeight() * 0.15f), 
						  									  getDamage()));
				
			}
			else
				if (getFramePassed() == getAttackInterval()+20) {
					bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f) , 
							  									  (getPos().y + getHeight() * 0.15f), 
							  									  getDamage()));
					setFramePassed(0);
				}
		
		setFramePassed(getFramePassed()+1);
	}

	@Override
	public void move() {

	}
}