package gui;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashScreen extends BasicGameState {
	
	public String mouse = "No input yet!";
	public Image testImg;
	public Image pea;
	int x=0;
	
	public SplashScreen(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Sound snd = new Sound("res/main_theme.ogg"); // Why it play twice ?
		//snd.loop(); 
		snd.play();
		testImg = new Image("res/wallpaper.jpg");
		pea = new Image("res/peashooter.png");
		 
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//Image testImg = new Image("res/wallpaper.jpg");
		testImg.drawWarped(0, 0, 0, 768, 1366, 768, 1366, 0);
		//g.drawImage(pea, x, 100);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_SPACE)) {
			mouse = "Space is pressed!";
			sbg.enterState(1);
		}
		else
			mouse = "No input";
		gc.sleep(100);
		x+=10;
	}
	
	public int getID() {
		return 0;
	}
}
