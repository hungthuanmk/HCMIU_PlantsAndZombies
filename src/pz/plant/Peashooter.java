package pz.plant;

import java.util.ArrayList;

import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

import pz.Bullet.*;

public class Peashooter extends pz.Plant {
	

	public Peashooter(Position pos) {
		super("Peashooter", 100, pos);
	}
	
	public void loadAnimation() throws SlickException {
		getIdleAni().addFrame(new Image("res/Plants/PeaShooter/Idle/1.png"), 200);
	}

	public void attack(ArrayList<pz.Bullet> bulletArrayList) {
		pz.Bullet pea = new pz.bullet.BPeaShooter(this.getPos().x, this.getPos().y);
		bulletArrayList.add(pea);
	}

}
