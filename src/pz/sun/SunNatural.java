package pz.sun;

import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import gui.PZGUI;
import pz.Sun;

public class SunNatural extends Sun {
	
	public SunNatural(Animation ani) throws SlickException {
		super(ani, 0, 0, 0);
		setPosX(ThreadLocalRandom.current().nextInt((int)(420*PZGUI.getResolutionRateWidth()), (int)(PZGUI.getResolutionRateHeight()*1350)));
		setPosY(-98);
		setEdgeY(ThreadLocalRandom.current().nextInt((int)(100*PZGUI.getResolutionRateWidth()), (int)(750*PZGUI.getResolutionRateHeight())));
	}

	@Override
	public void updateSun() {
		clickOn();
		if (isClicked() == false) {
			if (getPosY() < getEdgeY())
				setPosY(getPosY()+1);
			else {
				if (getFramePass() <= getStayTimeInFrame())	
					setFramePass(getFramePass()+1);
				else
					setDone(true);
			}
		}
		else {
			if (getPosX() > 30) {
				setPosX(getPosX() - getPosX()/20f);
				setPosY(getPosY() - getPosY()/20f);
			}
			else
				setDone(true);
		}	
		
	}

}
