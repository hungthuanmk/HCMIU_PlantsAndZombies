package pz;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import com.Clickable;

import gui.PZGUI;
import gui.SunUI;

public abstract class Sun implements Clickable{
	private float posX;
	private float posY;
	private float edgeY;
	
	private float width  = 80 * PZGUI.getResolutionRateWidth();
	private float height = 80 * PZGUI.getResolutionRateHeight();
	
	private int framePass;
	private int stayTimeInFrame = 60*10; // fps * second
	
	private boolean isClicked = false;
	private boolean isDone    = false;
	private Animation animation;
	
	public float getPosX() 			 					{return posX;}
	public void  setPosX(float posX) 					{this.posX = posX;}

	public float getPosY() 			 					{return posY;}
	public void  setPosY(float posY) 					{this.posY = posY;}

	public float  getEdgeY() 							{return edgeY;}
	public void   setEdgeY(float edgeY) 				{this.edgeY = edgeY;}
		
	public float getWidth() 							{return width;}
	public void  setWidth(float width)  				{this.width = width;}

	public float getHeight() 			  				{return height;}
	public void  setHeight(float height)  				{this.height = height;}

	public int  getFramePass() 							{return framePass;}
	public void setFramePass(int framePass) 			{this.framePass = framePass;}

	public int getStayTimeInFrame() 					{return stayTimeInFrame;}
	public void setStayTimeInFrame(int stayTimeInFrame) {this.stayTimeInFrame = stayTimeInFrame;}

	public Animation getAnimation() 				    {return animation;}
	public void      setAnimation(Animation animation)  {this.animation = animation;}

	public void setClicked(boolean isClicked) 			{this.isClicked = isClicked;}
	public void setDone(boolean isDone) 				{this.isDone = isDone;}

	public Sun(Animation ani, float posX, float posY, float edgeY) throws SlickException{
		this.posX = posX;
		this.posY = posY;
		this.edgeY = edgeY;
		ani.stop();
		this.animation = ani;
		this.animation.start(); // I think it can restart the animation
		framePass = 0;		
	}
	
	public void drawSun() throws SlickException{
		animation.draw(posX, posY, width, height);
	}
	
	public void drawStopSun() throws SlickException{
		animation.getCurrentFrame().draw(posX, posY, width, height);
	}
	
	public abstract void updateSun();
	
	public boolean isClicked(){
		if (isClicked == true){
			return true;
		}			
		else{
			return false;
		}			
	}
	
	protected void clickOn(){
		if (Mouse.getX() >= posX && Mouse.getX() <= posX + width && PZGUI.getHeight() - Mouse.getY() >= posY && PZGUI.getHeight() - Mouse.getY() <= posY + height) {
			
			if (Mouse.isButtonDown(0) && isClicked == false)
			{
				SunUI.gainSun(50);
				isClicked = true;
			}
		}
	}

	public boolean isDone() {
		return isDone;
	}

	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		
	}	
}
