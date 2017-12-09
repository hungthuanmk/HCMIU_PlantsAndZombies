package gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Seed {
	private Class 	_class;
	private Image 	img;
	private Integer money;
	
	public Seed(Class _class, Image img, Integer money) {
		this._class = _class;
		this.img 	= img;
		this.money  = money;
	}
	
	public Seed(Class _class, String img, Integer money) {
		this._class = _class;
		try {
			this.img = new Image(img);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.money  = money;
	}
	
	
	
}
