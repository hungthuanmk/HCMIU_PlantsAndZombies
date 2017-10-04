package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	int x = 0, y = 0;
	Animation blo = new Animation();
	
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		int time=100;
		blo.addFrame(new Image("res/Zombie/male/Walk (1).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (2).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (3).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (4).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (5).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (6).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (7).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (8).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (9).png"), time);
		blo.addFrame(new Image("res/Zombie/male/Walk (10).png"), time);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		blo.draw(Mouse.getX() - 200 , 768 - 200 - Mouse.getY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		x++;
	}
	
	public int getID() {
		return 1;
	}
}
