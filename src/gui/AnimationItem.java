package gui;

import org.newdawn.slick.Animation;

public class AnimationItem {
	
	private Animation ani = new Animation();
	private Class  _class = null;

	/**
	 * Create AnimationItem with specific Animation and Class
	 * @param ani	Animation
	 * @param _class	Class
	 */
	public AnimationItem(Animation ani, Class _class) {
		this.ani = ani;
		this._class = _class;
	}
	
	/**
	 * Create AnimationItem with specific Class and default Animation
	 * @param _class	Class
	 */
	public AnimationItem(Class _class) {
		this._class = _class;
	}
	
	/**
	 * Get default Animation
	 * @return	Animation
	 */
	public Animation getAni()  		   { return ani; }
	/**
	 * Set Animation for AnimationItem
	 * @param ani Animation
	 */
	public void setAni(Animation ani)  { this.ani = ani; }

	/**
	 * Get Class of AnimationItem
	 * @return Class
	 */
	public Class get_class() 		    {return _class;}
	/**
	 * Set Class for AnimationItem
	 * @param _class Class
	 */
	public void set_class(Class _class) {this._class = _class;}
}
