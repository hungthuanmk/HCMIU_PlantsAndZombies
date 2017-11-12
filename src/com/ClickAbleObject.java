package com;

public class ClickAbleObject {
	private int posX;
	private int posY;
	private int edgeY;
	
	private int width;
	private int height;
	private boolean isClicked = false;
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getEdgeY() {
		return edgeY;
	}

	public void setEdgeY(int edgeY) {
		this.edgeY = edgeY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public ClickAbleObject(){
		
	}
	
	public boolean isClicked(){
		if (isClicked == true){
			//System.out.println("This isClicked true");
			return true;
		}			
		else{
			//System.out.println("This isClicked false");
			return false;
		}			
	}
}
