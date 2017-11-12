package pz.plant;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Position;

public class Sunflower extends pz.Plant {
	

	public Sunflower(Position pos) {
		super("Sunflower", 100, pos);
	}


	public void loadAnimation() {
		try {
			for (int i=1; i<=30; i++)
				getIdleAni().addFrame(new Image("res/Plants/SunFlower/Idle/"+i+".png"), 30);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void attack(ArrayList<pz.Bullet> bulletArrayList) {
		
	}

}
