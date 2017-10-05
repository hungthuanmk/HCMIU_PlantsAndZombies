package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.SSound;

public class Menu extends BasicGameState {
		
	public Menu(int state) {
			
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
				
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		sbg.enterState(2);
	}
	
	public int getID() {
		return 1;
	}
}
