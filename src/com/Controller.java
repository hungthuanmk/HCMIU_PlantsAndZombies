package com;

import org.lwjgl.input.Mouse;

import gui.PZGUI;

public class Controller {
	/**
	 * Get X coordinate of cursor
	 * @return X, from left to right
	 */
	public static int getMouseX() {
		return Mouse.getX();
	}
	/**
	 * Get Y coordinate of cursor
	 * @return Y, from top to bottom
	 */
	public static int getMouseY() {
		return PZGUI.getHeight() - Mouse.getY();
	}
	/** 
	 * Get cursor coordinate
	 * @return Cursor coordinate: Position
	 */
	public static Position getMousePos() {
		return new Position(getMouseX(), getMouseY());
	}
	/**
	 * Check whether the cursor is in the specific or not
	 * @param topLeftX	X, area topLeft
	 * @param topLeftY  Y, area topLeft
	 * @param botRightX	X, area botRight
	 * @param botRightY Y, area botRight
	 * @return	boolean
	 */
	public static boolean mouseInArea(float topLeftX, float topLeftY, float botRightX, float botRightY) {
		float mX = getMouseX(), mY = getMouseY();
		if (mX >= topLeftX && mX <= botRightX)
			if (mY >= topLeftY && mY <= botRightY)
				return true;
		return false;
	}
}
