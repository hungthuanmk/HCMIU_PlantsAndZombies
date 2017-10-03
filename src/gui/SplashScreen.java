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
		//Sound snd = new Sound("res/0831.ogg");
		//snd.loop();
		//snd.play();
		 testImg = new Image("res/wallpaper.jpg");
		 pea = new Image("res/sun.png");
		// gc.setMouseCursor(new Cursor(), arg1, arg2);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	//	Image testImg = new Image("res/wallpaper.jpg");
		testImg.drawWarped(0, 0, 0, 768, 1366, 768, 1366, 0);
		//g.drawImage(pea, x, 100);
		g.setAntiAlias(true);
		pea.draw(x, 100, 0.5f, new Color(1,1,1, 0.65f)); //Transparent test
		//pea.draw(x, 100, 0.5f);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_SPACE)) {
			
			
			//sbg.enterState(1);
		}
		else
			mouse = "No input";
		gc.sleep(5);
		x++;
	}
	
	public int getID() {
		return 0;
	}
}
