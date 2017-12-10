package pz.bullet;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.Clickable;
import com.Position;

import pz.Bullet;
import pz.Zombie;

public class BSunflower extends Bullet implements Clickable{
	
	private float x;
	private float y;
	private float initX, initY;
	private static int damage = 0;
	private static int speed = 10;
	private static int height = 40;

	public BSunflower(Position pos) {
		super(damage, speed, pos);
		//x = getPos().x;
		x = (float) Math.sqrt(height);
		y = 0;
		initX = getPos().x;
		initY = getPos().y;
	}
	
	public void move() {
			y = -x*x + height;
			if (y >= 0) 
				x -= 0.1f;
			setPos(initX + x - getWidth()/2, initY - y);
	}
	
	protected void loadAnimation() {
		try {
			for (int i=1; i<=6; i++)
				//setAnimation();
				getAnimation().addFrame(new Image("res/Sun Sprite/Sun "+i+".png").getScaledCopy(0.1f), 200);
		} catch (SlickException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void onClicked() {
		// inscrease Sun
		
	}

	@Override
	public void attack(ArrayList<Zombie> zombieList, ArrayList<Bullet> bulletList) {
		
		
	}

}
