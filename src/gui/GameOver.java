package gui;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.ini4j.InvalidFileFormatException;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import com.Controller;

public class GameOver extends BasicGameState {
	private static Text text;
	
	private static Image background;
	private static Image newGameButton;
	private static Image exitGameButton;
	
	public GameOver(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		text = new Text(60.0f);
		background = new Image("res/Map/GameOver.png");
		newGameButton = new Image("res/UI/GOver_NewGame_Button.png");
		exitGameButton = new Image("res/UI/GOver_ExitGame_Button.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		showBackground(g);
		showExitGameButton(gc, g);
		showNewGameButton(sbg, g);
		int highScore = PZGUI.getHighestPoint();
		int score = SunUI.getSunCollected();
		String scoreStr = SunUI.getSunCollected().toString();
		if (score >= highScore) {
			try {
				PZGUI.setHighestPoint(score);
			} catch (InvalidFileFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scoreStr += " (NEW RECORD)";
		}
		
		text.render(755 * PZGUI.getResolutionRateWidth(), 275 * PZGUI.getResolutionRateHeight(), scoreStr);
		
		text.render(755 * PZGUI.getResolutionRateWidth(), 375 * PZGUI.getResolutionRateHeight(), String.format("%d",PZGUI.getHighestPoint()));
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
	private void showNewGameButton(StateBasedGame sbg, Graphics g) throws SlickException {
		float rate = 1.14f;
		float posX = 435 * PZGUI.getResolutionRateWidth();
		float posY = 470 * PZGUI.getResolutionRateHeight();
		float width = newGameButton.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = newGameButton.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		
		newGameButton.draw(posX, posY, width, height);
		
		if (Controller.mouseInArea(posX, posY, posX + width, posY + height)) {
			newGameButton.draw(posX, posY, width, height, new Color(0, 0, 0, 100));
			if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
				SunUI.getSunManager().clear();
				SunUI.setSunCollected(50);
				SunUI.setFramePassed(0);
				sbg.getState(2);
				sbg.enterState(2);
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void showExitGameButton(GameContainer gc, Graphics g) throws SlickException {
		float rate = 1.14f;
		float posX = 885 * PZGUI.getResolutionRateWidth();
		float posY = 470 * PZGUI.getResolutionRateHeight();
		float width = newGameButton.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = newGameButton.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		
		exitGameButton.draw(posX, posY, width, height);
		
		if (Controller.mouseInArea(posX, posY, posX + width, posY + height)) {
			exitGameButton.draw(posX, posY, width, height, new Color(0, 0, 0, 100));
			if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
				gc.exit();
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getID() {
		return 3;
	}
}
