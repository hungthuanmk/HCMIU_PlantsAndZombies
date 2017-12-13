package com;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * 
 * @author Nguyen Phan Hung Thuan
 *
 */
public class SSound {
	private Sound snd;
	/**
	 * Initialize sound
	 * @param snd	Sound filename
	 */
	public SSound(String snd) {this.setSound(snd);}
	
	/**
	 * Set sound file
	 * @param snd	Sound filename
	 */
	public void setSound(String snd) {
		try {
			this.snd = new Sound(snd);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get sound file
	 * @return	Sound
	 */
	public Sound getSound() {return this.snd;}
	
	/**
	 * Play sound
	 * @param looping	Looping
	 * @param pitch	Pitch
	 * @param volume	Volume
	 */
	public final void play(boolean looping, float pitch, float volume) {
		if (looping == false)
			this.getSound().play(pitch, volume);
		else
			this.getSound().loop(pitch, volume);
	}
	
	/**
	 * Play sound
	 * @param looping	Looping
	 */
	public final void play(boolean looping) { this.play(looping, 1f, 1f);}	
	/**
	 * Play sound one time
	 */
	public final void play() 				{ this.play(false, 1f, 1f);  }
	
	/**
	 * Stop sound
	 */
	public final void stop() {this.getSound().stop();}
	
	/**
	 * Play sound
	 * @param snd	Sound filename
	 * @param looping	Looping
	 * @param pitch	Pitch
	 * @param volume	Volume
	 */
	public static final void play(String snd, boolean looping, float pitch, float volume) {	
		try {
			Sound s = new Sound(snd);
			if (looping == true)
				s.loop(pitch, volume);
			else
				s.play(pitch, volume);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Play sound
	 * @param snd	Sound filename
	 * @param looping	Looping
	 */
	public static final void play(String snd, boolean looping) {play(snd, looping, 1f, 1f);}
	/**
	 * Play sound
	 * @param snd	Sound filename
	 */
	public static final void play(String snd) {play(snd, false, 1f, 1f);}

}
