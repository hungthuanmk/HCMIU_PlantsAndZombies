package gui;

import java.util.Vector;
import java.util.Random;
import com.SSound;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashScreen extends BasicGameState {
	
	public Image testImg;
	public Image pea;
	int x=0;
	SpriteSheet sun;
	Animation sunAni;
	Vector<Animation> sunArray = new Vector<Animation>();
	
	public SplashScreen(int state) {
		//SSound.play("res/0831.ogg",false, 1f, 1f);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.getGraphics().setAntiAlias(PZGUI.AA);
		testImg = new Image("res/wallpaper.jpg");
		pea = new Image("res/sun.png");
		sun = new SpriteSheet("res/sunSprite.png",500,500);
		sunAni = new Animation(sun, 300);
		sunArray.clear();
		sunArray.add(new Animation(new SpriteSheet("res/sunSprite.png",500,500), 300));	 
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		testImg.drawWarped(0, 0, 0, 768, 1366, 768, 1366, 0);
		//pea.draw(x, 100, 0.5f, new Color(1,1,1, 0.65f)); //Transparent test
		//sunAni.draw(x, 100);
		Random r = new Random();
		for (Animation a:sunArray) {
			a.draw(r.nextInt(1366-500), r.nextInt(768-500));
		}
		
		//gc.sleep(50);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	}
	
	public int getID() {
		return 0;
	}
}
