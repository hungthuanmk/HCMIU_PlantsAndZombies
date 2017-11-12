package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet.*;

public class Peashooter extends pz.Plant {

	public Peashooter(Position pos) {
		super("Peashooter", 100, pos);
	}
	
	public void loadAnimation() {
		try {
			for (int i=1; i<=30; i++)
				getIdleAni().addFrame(new Image("res/Plants/PeaShooter/Idle/"+i+".png"), 30);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attack(ArrayList<pz.Bullet> bulletArrayList) {
		pz.Bullet pea = new pz.bullet.BPeashooter(this.getPos().x, this.getPos().y);
		bulletArrayList.add(pea);
	}
	

}
