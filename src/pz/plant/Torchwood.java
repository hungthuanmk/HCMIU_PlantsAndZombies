package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;
import pz.Plant;

public class Torchwood extends Plant{
	private static int hp = 1000;
	private static int damage = 100;
	private static int attackInterval = 0;
	
	public Torchwood(Position pos) {
		super("Torchwood", hp, damage, attackInterval, pos);
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loadAnimation() {
		try {
			for (int i=1; i<=8; i++)
				getAnimation().addFrame(new Image("res/Plants/Torchwood/Idle/"+i+".png"), 100);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

}
