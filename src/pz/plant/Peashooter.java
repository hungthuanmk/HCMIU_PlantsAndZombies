package pz.plant;

import java.util.ArrayList;

import pz.Bullet.*;

public class Peashooter extends pz.Plant {

	public Peashooter() {
		super("Peashooter");
	}

	public void attack(ArrayList<pz.Bullet> bulletArrayList) {
		pz.Bullet pea = new pz.bullet.BPeaShooter(this.getPos().x, this.getPos().y);
		bulletArrayList.add(pea);
	}

}
