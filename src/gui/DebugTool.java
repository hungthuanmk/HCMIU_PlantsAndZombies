package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DebugTool {
	public static void showMousePosition(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (Mouse.getX() < PZGUI.width - 100)
			g.drawString(String.format("[%d, %d]", Mouse.getX(), PZGUI.height - Mouse.getY()), Mouse.getX() + 10, PZGUI.height - Mouse.getY());
		else
			g.drawString(String.format("[%d, %d]", Mouse.getX(), PZGUI.height - Mouse.getY()), Mouse.getX() - 100, PZGUI.height - Mouse.getY());
	}
}
