package game;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class PandZ extends BasicGame {
	
	private int score = 0;
	private int sun = 100;
	private int targetFPS = 60;
	
	public PandZ(String gameName) {
	/*	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("D:\\IT\\Icon\\pen_icon.png").getImage());
		setTitle(title);
		setSize(800, 600);
		setResizable(false);
		setLocation(300, 50);
		setVisible(true);
		
		JLabel lb = new JLabel("Hello World!");
		add(lb);	
		*/
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
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Howdy!", 10, 10);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new PandZ("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(PandZ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
