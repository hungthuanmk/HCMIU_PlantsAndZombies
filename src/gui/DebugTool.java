package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.Controller;

public class DebugTool {
	public static void showMousePosition(Graphics g) throws SlickException {
		if (Mouse.getX() < PZGUI.width - 100)
			g.drawString( String.format("[%d, %d]", Controller.getMouseX(), Controller.getMouseY()) , Controller.getMouseX() + 10, Controller.getMouseY());
		else
			g.drawString( String.format("[%d, %d]", Controller.getMouseX(), Controller.getMouseY()), Controller.getMouseX() - 100, Controller.getMouseY());
	}
}
