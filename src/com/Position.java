package com;

import org.newdawn.slick.Animation;

import pz.Bullet;
import pz.Zombie;

public class Position {
	public float x=0, y=0; 
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString()
	{
		return "X:" +  Float.toString(x) + " Y:" + Float.toString(y);
	}
	public static boolean isInteract(Bullet a1, Zombie a2) {
		float topLeftX1 = a1.getPos().x;
		float topLeftY1 = a1.getPos().y;
		float botRightX1 = topLeftX1 + a1.getAnimation().getWidth();
		float botRightY1 = topLeftY1 + a1.getAnimation().getHeight();
		float topLeftX2 = a2.getPos().x;
		float topLeftY2 = a2.getPos().y;
		float botRightX2 = topLeftX2 + a2.getAnimation().getWidth();
		float botRightY2 = topLeftY2 + a2.getAnimation().getHeight();
		
		return (topLeftX1 > topLeftX2 && topLeftX1 < botRightX2   &&
				topLeftY1 > topLeftX2 && topLeftY1 < botRightY2   );
	}
}
