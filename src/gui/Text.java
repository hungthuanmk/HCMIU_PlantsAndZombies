package gui;

import java.awt.Font;
import java.io.InputStream;
 
//import org.lwjgl.LWJGLException;
//import org.lwjgl.input.Mouse;
//import org.lwjgl.opengl.Display;
//import org.lwjgl.opengl.DisplayMode;
//import org.lwjgl.opengl.GL11;
 
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Text {
	private static String fontDir = "res/Fonts/FbUsv8C5eI.ttf";
	
	private static Text instance = null;
	private static boolean antiAlias = true;
	
	private static Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
	private static TrueTypeFont font35 = new TrueTypeFont(awtFont, antiAlias);
	private static TrueTypeFont font70 = new TrueTypeFont(awtFont, antiAlias);
	private static InputStream inputStream;
	
	private static void loadFont() {
		try {
            inputStream = ResourceLoader.getResourceAsStream(fontDir);
             
            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font35 = new TrueTypeFont(awtFont.deriveFont(35.0f * PZGUI.resolutionRateHeight), antiAlias);
            font70 = new TrueTypeFont(awtFont.deriveFont(70.0f * PZGUI.resolutionRateHeight), antiAlias);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    
    public Text() {
    	loadFont();
    }

    public static void render35(float x, float y, String whatchars) {
        font35.drawString(x, y, whatchars);
    }
    
    public static void render35(float x, float y, String whatchars, Color color){
    	font35.drawString(x, y, whatchars, color);
    }
    
    public static void render70(float x, float y, String whatchars) {
        font70.drawString(x, y, whatchars);
    }
    
    public static void render70(float x, float y, String whatchars, Color color){
    	font70.drawString(x, y, whatchars, color);
    }
}
