package com;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SSound {
	private Sound snd;
	public SSound(String snd) {
		this.setSound(snd);
	}
	
	public void setSound(String snd) {
		try {
			this.snd = new Sound(snd);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public Sound getSound() {
		return this.snd;
	}
	
	public final void play(boolean looping, float pitch, float volume) {
		if (looping == false)
			this.getSound().play(pitch, volume);
		else
			this.getSound().loop(pitch, volume);
	}
	
	public final void play(boolean looping) {
		this.play(looping, 1f, 1f);
	}
	
	public final void play() {
		this.play(false, 1f, 1f);
	}
	
	public final void stop() {
		this.getSound().stop();
	}
	
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
	
	public static final void play(String snd, boolean looping) {
		play(snd, looping, 1f, 1f);
	}
	
	public static final void play(String snd) {
		play(snd, false, 1f, 1f);
	}

}
