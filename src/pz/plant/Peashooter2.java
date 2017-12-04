package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

//import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import gui.PZGUI;
import pz.Bullet;

//import pz.Bullet.*;

public class Peashooter2 extends pz.Plant {
	
	private static int hp = 100;
	private static int damage = 20;
	private static int attackInterval = 300;
	private static float scaleFactor = 0.2f;
	public Peashooter2(Position pos) {
		super("Peashooter2", hp, damage, attackInterval, pos);
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
			bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getAnimation().getWidth() * scaleFactor * 0.8f * PZGUI.resolutionRateWidth) , 
														  (getPos().y + getAnimation().getHeight() * scaleFactor * 0.15f * PZGUI.resolutionRateHeight), 
														  getDamage()));
		}
		else
			if (getFramePassed() == getAttackInterval()+10) {
				bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getAnimation().getWidth() * scaleFactor * 0.8f * PZGUI.resolutionRateWidth) , 
						  (getPos().y + getAnimation().getHeight() * scaleFactor * 0.15f * PZGUI.resolutionRateHeight), 
						  getDamage()));
				setFramePassed(0);
			}
		
		setFramePassed(getFramePassed()+1)	;
	}

	@Override
	public void move() {

	}
}
