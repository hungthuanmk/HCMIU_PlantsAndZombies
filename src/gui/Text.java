package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
 
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

/**
 * 
 * @author Nguyen Thanh Xuan Tung
 *
 */
public class Text {
	
	private static String fontDir = "res/Fonts/FbUsv8C5eI.ttf";
	private static boolean antiAlias = true;
	private InputStream inputStream = null;
	private Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
	private TrueTypeFont font = new TrueTypeFont(awtFont, antiAlias);
	
	/**
	 * Initialize text with size
	 * @param size	Text size
	 */
	public Text(Float size) {
		inputStream = ResourceLoader.getResourceAsStream(fontDir);
		try {
			awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			font = new TrueTypeFont(awtFont.deriveFont(size * PZGUI.getResolutionRateHeight()), antiAlias);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Draw string
	 * @param x	X
	 * @param y	y
	 * @param whatchars	Text
	 */
	public void render(float x, float y, String whatchars) {
		font.drawString(x, y, whatchars);
	}
	
	/**
	 * Draw string with specific color
	 * @param x	X
	 * @param y	Y
	 * @param whatchars	Text
	 * @param color	Color
	 */
	public void render(float x, float y, String whatchars, Color color) {
		font.drawString(x, y, whatchars, color);
	}
	
}
