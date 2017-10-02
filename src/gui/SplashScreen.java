package gui;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashScreen extends BasicGameState {
	
	public String mouse = "No input yet!";
	
	public SplashScreen(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Sound snd = new Sound("res/0831.ogg");
		snd.loop();
		//snd.play();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Image testImg = new Image("res/wallpaper.jpg");
		testImg.drawWarped(0, 0, 0, 768, 1366, 768, 1366, 0);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_SPACE)) {
			mouse = "Space is pressed!";
			sbg.enterState(1);
		}
		else
			mouse = "No input";		
	}
	
	public int getID() {
		return 0;
	}
}
