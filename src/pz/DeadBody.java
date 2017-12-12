package pz;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.Position;

import gui.PZGUI;

public class DeadBody {

	private Animation ani = new Animation();
	private Position pos;
	
	public DeadBody(Class _class, Position pos) {
		pos = pos;
		loadAnimation(_class);
	}
	
	private float getWidth() {
		return ani.getWidth() * PZGUI.getResolutionRateWidth();
	}
	
	private float getHeight() {
		return ani.getHeight() * PZGUI.getResolutionRateHeight();
	}
	
	/**
	 * Draw the animation in only one drame cycle, return whether end of one cycle or not
	 * @return	True when still be in draw cycle, false at the end of cycle
	 */
	public boolean draw() {
		if (ani.getFrame() < ani.getFrameCount()) {
			ani.draw(pos.x, pos.y, getWidth(), getHeight());
			return true;
		}
		return false;
	}

	protected void loadAnimation(Class _class) {
		//setAnimation(ani);
		
	}


}
