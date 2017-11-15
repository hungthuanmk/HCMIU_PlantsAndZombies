package com;

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
}
