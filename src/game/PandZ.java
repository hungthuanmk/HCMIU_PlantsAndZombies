package game;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
//import javax.swing.*;

public class PandZ extends JFrame implements Runnable {
	
	private int score = 0;
	private int sun = 100;
	private int targetFPS = 60;
	
	public PandZ(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("D:\\IT\\Icon\\pen_icon.png").getImage());
		setTitle(title);
		setSize(800, 600);
		setResizable(false);
		setLocation(300, 50);
		setVisible(true);
		
		JLabel lb = new JLabel("Hello World!");
		//add(lb);	
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
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String[] args) {
		//Thread game = new Thread(PandZ("Plants & Zombies - HCMIU TNT Team 2017"));
		PandZ game = new PandZ("Plants & Zombies - HCMIU TNT Team 2017");
	}

}
