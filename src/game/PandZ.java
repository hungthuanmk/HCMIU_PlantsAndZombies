package game;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
//import javax.swing.*;

public class PandZ extends JFrame {
	
	public PandZ(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("D:\\IT\\Icon\\pen_icon.png").getImage());
		setTitle(title);
		setSize(800, 600);
		setResizable(false);
		setLocation(300, 50);
		setVisible(true);
		
		JLabel lb = new JLabel("Hello World!");
		add(lb);
		
	}

	public static void main(String[] args) {
		PandZ game = new PandZ("Plants & Zombies - HCMIU TTNT Team 2017");
	}

}
