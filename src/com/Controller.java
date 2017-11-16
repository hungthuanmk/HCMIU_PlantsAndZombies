package com;

import org.lwjgl.input.Mouse;

import gui.PZGUI;

public class Controller {
	public static int getMouseX() {
		return Mouse.getX();
	}
	public static int getMouseY() {
		return PZGUI.height - Mouse.getY();
	}
	public static Position getMousePos() {
		return new Position(getMouseX(), getMouseY());
	}
	public static boolean mouseInArea(float topLeftX, float topLeftY, float botRightX, float botRightY) {
		float mX = getMouseX(), mY = getMouseY();
		if (mX >= topLeftX && mX <= botRightX)
			if (mY >= topLeftY && mY <= botRightY)
				return true;
		return false;
	}
}
