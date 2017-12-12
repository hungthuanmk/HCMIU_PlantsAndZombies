package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Controller;

/**
 * 
 * @author Nguyen Thanh Xuan Tung
 *
 */
public class DebugTool {
	
	/**
	 * Draw cursor coordinate
	 * @param g Graphics get from render process
	 * @throws SlickException
	 */
	public static void showMousePosition(Graphics g) throws SlickException {
		if (Mouse.getX() < PZGUI.getWidth() - 100)
			g.drawString( String.format("[%d, %d]", Controller.getMouseX(), Controller.getMouseY()) , Controller.getMouseX() + 10, Controller.getMouseY());
		else
			g.drawString( String.format("[%d, %d]", Controller.getMouseX(), Controller.getMouseY()), Controller.getMouseX() - 100, Controller.getMouseY());
	}
}
