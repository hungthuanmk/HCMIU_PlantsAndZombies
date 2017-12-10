package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet;

public class Wallnut extends pz.Plant {
	private static int hp = 3000;
	private static int attackInterval = 0;
	private static float scaleFactor = 1.0f;

	public Wallnut(Position pos) {
		super("Wallnut", hp, 0, attackInterval, pos);
	}

	@Override
	public void attack(ArrayList<Bullet> bulletArrayList) {
		
	}

	@Override
	public void move() {
		
	}

	@Override
	protected void loadAnimation() {
		try {
			for (int i=1; i<=12; i++)
				getAnimation().addFrame(new Image("res/Plants/WallNut/Idle2/"+i+".png"), 100);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
