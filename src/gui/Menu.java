package gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	int x=50, y=50;
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Hello Plant Vs. Zombie", x, y);
		g.drawRect(x, y, 200, 20);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		x = (int)(Math.random() * 1366 + 1);
		y = (int)(Math.random() * 768 + 1);
	}
	
	public int getID() {
		return 1;
	}
}
