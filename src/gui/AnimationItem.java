package gui;

import org.newdawn.slick.Animation;

public class AnimationItem {
	private Animation ani = new Animation();
	private Class  _class = null;

	public AnimationItem(Animation ani, Class _class) {
		this.ani = ani;
		this._class = _class;
	}
	
	public AnimationItem(Class _class) {
		this._class = _class;
	}
	
	public Animation getAni() {return ani;}
	public void setAni(Animation ani) {this.ani = ani;}

	public Class get_class() {return _class;}
	public void set_class(Class _class) {this._class = _class;}
}
