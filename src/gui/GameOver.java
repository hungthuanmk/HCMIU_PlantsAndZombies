package gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.Controller;

public class GameOver extends BasicGameState {
<<<<<<< HEAD
	private static Text text;
	
	private static Image background;
	private static Image newGameButton;
	private static Image exitGameButton;
	
=======
>>>>>>> AnimationLoader
	
	public GameOver(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
<<<<<<< HEAD
		text = new Text(50.0f);
		background = new Image("res/Map/GameOver.png");
		newGameButton = new Image("res/UI/GOver_NewGame_Button.png");
		exitGameButton = new Image("res/UI/GOver_ExitGame_Button.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackground(g);
		showExitGameButton(g);
		showNewGameButton(g);
=======
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
>>>>>>> AnimationLoader
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	// Show Background
	private void showBackground(Graphics g) throws SlickException {
		float rate 		= 1.14f;
		float width 	= background.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height 	= background.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		
		background.draw(0, 0, width, height);
	}
	
	// Show Button
	private void showNewGameButton(Graphics g) throws SlickException {
		float rate = 1.14f;
		float posX = 435 * PZGUI.getResolutionRateWidth();
		float posY = 430 * PZGUI.getResolutionRateHeight();
		float width = newGameButton.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = newGameButton.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		
		newGameButton.draw(posX, posY, width, height);
		
		if (Controller.mouseInArea(posX, posY, posX + width, posY + height)) {
			newGameButton.draw(posX, posY, width, height, new Color(0, 0, 0, 100));
		}
	}
	
	private void showExitGameButton(Graphics g) throws SlickException {
		float rate = 1.14f;
		float posX = 885 * PZGUI.getResolutionRateWidth();
		float posY = 430 * PZGUI.getResolutionRateHeight();
		float width = newGameButton.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = newGameButton.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		
		exitGameButton.draw(posX, posY, width, height);
		
		if (Controller.mouseInArea(posX, posY, posX + width, posY + height)) {
			exitGameButton.draw(posX, posY, width, height, new Color(0, 0, 0, 100));
		}
	}
	
	public int getID() {
		return 3;
	}
}
