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
}
