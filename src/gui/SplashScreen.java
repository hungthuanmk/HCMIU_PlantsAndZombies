package gui;

import java.util.Vector;
import java.util.Random;
import com.SSound;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class SplashScreen extends BasicGameState {
	
	public Image testImg;
	public Image pea;
	public Image logo;
	public Image playButton;
	public Color filter = new Color(255, 255, 255, 1f);
	
	int x=0;
	SpriteSheet sun;
	Animation sunAni;
	Vector<Animation> sunArray = new Vector<Animation>();
	
	public SplashScreen(int state) {
		SSound.play("res/main_theme.ogg",false, 1f, 1f);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gc.getGraphics().setAntiAlias(PZGUI.AA);
		testImg = new Image("res/wallpaper.jpg");
		logo = new Image("res/pvz_logo.png");
		pea = new Image("res/sun.png");
		playButton = new Image("res/Button/PlayDemo.png");
		sun = new SpriteSheet("res/sunSprite.png",500,500);
		sunAni = new Animation(sun, 300);
		sunArray.clear();
		sunArray.add(new Animation(new SpriteSheet("res/sunSprite.png",500,500), 100));
		
		System.out.print("Init");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		testImg.drawWarped(0, 0, 0, 768, 1366, 768, 1366, 0);
		logo.draw(200, 50, 940, 143);
		pea.draw(x, 100, 0.5f, new Color(1,1,1, 0.4f)); //Transparent test
		sunAni.draw(x, 100);
		playButton.draw(420, 520, 485, 98, filter);
		
		Random r = new Random();
		for (Animation a:sunArray) {
			//a.draw(r.nextInt(1366-500), r.nextInt(768-500));
			a.draw(500, x, 100, 100);
		}
				
		//gc.sleep(50);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		x++;
		int mouseX = Mouse.getX();
		int mouseY = 768 - Mouse.getY();
		if (mouseX >= 420 && mouseX <= 420+485 && mouseY >= 520 && mouseY <= 520+98){
			filter = new Color(100, 100, 100, 0.5f);
			if (Mouse.isButtonDown(0))
				sbg.enterState(1);
		}
		else 
			filter = new Color(255, 255, 255, 1f); 	
	}
	
	public int getID() {
		return 0;
	}
}
