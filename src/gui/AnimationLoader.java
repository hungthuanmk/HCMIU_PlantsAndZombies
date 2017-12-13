package gui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import pz.CharacterBuilder;
import pz.plant.*;
import pz.zombie.FemaleZombie;
import pz.zombie.MaleZombie;
import pz.zombie.NhiZombie;

/**
 * 
 * @author Nguyen Phan Hung Thuan
 *
 */
public class AnimationLoader {

	public static ArrayList<AnimationItem> aniList = new ArrayList<>();
	
	/**
	 * Initialize all ANIMATIONS
	 */
	public AnimationLoader() {
		
		CharacterBuilder.buildPlant(Peashooter.	  class, null);
		CharacterBuilder.buildPlant(Peashooter2.  class, null);
		CharacterBuilder.buildPlant(Peashooter3.  class, null);
		CharacterBuilder.buildPlant(Sunflower.	  class, null);
		CharacterBuilder.buildPlant(Torchwood.	  class, null);
		CharacterBuilder.buildPlant(Wallnut.	  class, null);
		CharacterBuilder.buildPlant(Bloomerang.	  class, null);
		
		CharacterBuilder.buildZombie(MaleZombie.  class, null);
		CharacterBuilder.buildZombie(FemaleZombie.class, null);
		CharacterBuilder.buildZombie(NhiZombie.	  class, null);
		
		//loadResources("res"); /
	}
	
	/**
	 * Load all resources in directory and subdirectory 
	 * @param directory Directory
	 */
	private void loadResources(String directory) {
		String[] folders = getFolders(directory);
	
		AnimationLoader.getAnimationFromFolder(directory, 50);
			
		System.out.println(">>" + directory);
	
		for (int i=0; i<folders.length; i++) 
			loadResources(directory + "/" + folders[i]);	
	}
	
	/**
	 * Get Animation by load all PNG file in specific folder by name order
	 * @param directory	Images folder
	 * @param duration	Duration of each frame
	 * @return	Animation
	 */
	public static Animation getAnimationFromFolder(String directory, int duration) {
		Animation temp = new Animation();
		String[] imgs = getFiles(directory, "png");
		for (int i=0; i<imgs.length; i++) {
			try {
				temp.addFrame(new Image(directory+"/"+imgs[i]), duration);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}
	
	/**
	 * Get Animation by finding loaded Animation as Class name
	 * @param _className Class
	 * @return	Animation
	 */
	public static Animation getAnimation(Class _className) {
		for (int i=0; i<aniList.size(); i++) {
			//if (aniList.get(i).get_class().getSimpleName().equals(_className.getSimpleName())) {
			if (aniList.get(i).get_class() == _className) {
				return aniList.get(i).getAni().copy();
			}
		}
		return null;
	}
	
	/**
	 * Get all folders name in specific directory
	 * @param directory Directory
	 * @return	String[] folders name
	 */
	private static String[] getFolders(String directory) {
		File f = new File(directory);
		String[] dirs = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory();
			}
		});
		return dirs;
	}
	
	/**
	 * Get all file in a directory with file extention filder
	 * @param directory Directory
	 * @param extension File extension filder
	 * @return	String[] files name
	 */
	private static String[] getFiles(String directory, String extension) {
		File f = new File(directory);
		String[] dirs = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (getFileExtension(name).equals(extension.toLowerCase()))
					return true;	
				return false;
			}
		});
		return dirs;
	}
	
	/**
	 * Get file's extension
	 * @param fileName File's name
	 * @return	String file extenstion
	 */
	private static String getFileExtension(String fileName) {
		try {
			return fileName.substring(fileName.lastIndexOf(".")+1);
		}
		catch (Exception e) {
			return "";
		}
	}
	
}
