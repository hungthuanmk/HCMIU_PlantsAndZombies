package com;

import pz.*;

public class Position {
	public float x=0, y=0; 
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString()
	{
		return "X:" +  x + " Y:" + y;
	}
	
	public static boolean isIntersect(Bullet bullet, Zombie zombie) {
		float topLeftX1 = bullet.getPos().x;
		float topLeftY1 = bullet.getPos().y;
		float botRightX1 = topLeftX1 + bullet.getWidth();
		float botRightY1 = topLeftY1 + bullet.getHeight();
		float topLeftX2 = zombie.getPos().x;
		float topLeftY2 = zombie.getPos().y;
		float botRightX2 = topLeftX2 + zombie.getWidth();
		float botRightY2 = topLeftY2 + zombie.getHeight();
		
		return (topLeftX1 > topLeftX2 && topLeftY1 > topLeftY2   &&
				botRightX1 < botRightX2 && botRightY1 < botRightY2   );
	}
	
	public static boolean isInteract(Zombie zombie, Plant plant) {
		float topLeftX1 = zombie.getPos().x + zombie.getWidth()*0.33f;
		float topLeftY1 = zombie.getPos().y;
		float botRightX1 = topLeftX1 + zombie.getWidth();
		float botRightY1 = topLeftY1 + zombie.getHeight();
		float topLeftX2 = plant.getPos().x;
		float topLeftY2 = plant.getPos().y;
		float botRightX2 = topLeftX2 + plant.getWidth();
		float botRightY2 = topLeftY2 + plant.getHeight();
		
		return (topLeftX1 < botRightX2  &&
				topLeftY1 < topLeftY2 && botRightY1 > botRightY2   );
	}
}
