package gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameOver extends BasicGameState {
	private static Text text;
	public GameOver(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		text = new Text(100.0f);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		text.render(PZGUI.getWidth()/2, PZGUI.getHeight()/2, "GAMEOVER");
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public int getID() {
		return 3;
	}
}
