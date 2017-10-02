package game;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.Animation;

public class PandZ extends BasicGame {
	
	private boolean showFPS = true;
	private int score = 0;
	private int sun = 100;
	private Image img;
	
	public PandZ(String gameName) {
		super(gameName);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSun() {
		return sun;
	}

	public void setSun(int sun) {
		this.sun = sun;
	}
	

	@Override
	public void init(GameContainer gc) throws SlickException {
	 	gc.setShowFPS(this.showFPS);
		this.img = new Image("res/b.gif");	
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Nguyen Phan Hung Thuan", 10, 100);
		g.drawOval(100, 200, 200, 100);
		this.img.drawCentered(100, 100);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new PandZ("TNT Plants VS Zombies Clone - HCMIU"));
			appgc.setDisplayMode(1366, 768, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(PandZ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
