package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

public class Sunflower extends pz.Plant {
	
	private static int hp = 100;
	private static int attackInterval = 1000;
	//private static int damage = 0;

	public Sunflower(Position pos) {
		super("Sunflower", hp, 0, attackInterval, pos);
	}

	protected void loadAnimation() {
		try {
			for (int i=1; i<=30; i++)
				getAnimation().addFrame(new Image("res/Plants/SunFlower/Idle/"+i+".png"), 30);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void attack(ArrayList<pz.Bullet> bulletArrayList) {
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
