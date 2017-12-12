package gui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
		
//		String plantDir = "res/Plants/";
//		String zombieDir = "res/ZombieTest/";
//		String[] plantFolder = getFolders(plantDir);
//		String[] zombieFolder = getFolders(zombieDir);
//		System.out.println(Arrays.toString(plantFolder));
//		for (int i=0; i<plantFolder.length; i++) {
//			String[] imgs = getFiles(plantDir+plantFolder[i]+"/Idle/");
//			if (imgs.length != 0) {
//				try {
//					AnimationItem item = new AnimationItem(Class.forName("pz.plant."+plantFolder[i]));
//					for (int k=0; k<imgs.length; k++) {
//						item.getAni().addFrame(new Image(plantDir + plantFolder[i] +"/Idle/" + imgs[k]), 30);
//					}
//					aniList.add(item);
//				} catch (ClassNotFoundException e) {
//					//e.printStackTrace();
//					System.out.println("<ERROR:ANIMATION> NOT FOUND CLASS "+plantFolder[i]);
//					continue;
//				} catch (SlickException e) {
//					e.printStackTrace();
//				}
//				
//			}			
//			System.out.println("LOADED " + Arrays.toString(imgs) + " -> " + plantFolder[i]);
//		}
//		
//		System.out.println(Arrays.toString(zombieFolder));
//		for (int i=0; i<zombieFolder.length; i++) {
//			String[] imgs = getFiles(zombieDir+zombieFolder[i]+"/walk/");
//			if (imgs.length != 0) {
//				try {
//					AnimationItem item = new AnimationItem(Class.forName("pz.zombie."+zombieFolder[i]));
//					for (int k=0; k<imgs.length; k++) {
//						item.getAni().addFrame(new Image(zombieDir + zombieFolder[i] +"/walk/" + imgs[k]), 30);
//					}
//					aniList.add(item);
//				} catch (ClassNotFoundException e) {
//					//e.printStackTrace();
//					System.out.println("<ERROR:ANIMATION> NOT FOUND CLASS "+zombieFolder[i]);
//					continue;
//				} catch (SlickException e) {
//					e.printStackTrace();
//				}
//				
//			}			
//			System.out.println("LOADED " + Arrays.toString(imgs) + " -> " + zombieFolder[i]);
//		}
//		
		
		AnimationLoader.getAnimationFromFolder("res/Plants/PeaShooter/Idle", 30);
		AnimationLoader.getAnimationFromFolder("res/Plants/SunFlower/Idle", 50);
		AnimationLoader.getAnimationFromFolder("res/Plants/Torchwood/Idle", 100);
		AnimationLoader.getAnimationFromFolder("res/Plants/WallNut/Idle2", 100);
		AnimationLoader.getAnimationFromFolder("res/ZombieTest/FemaleZombie/walk", 110);
		AnimationLoader.getAnimationFromFolder("res/ZombieTest/MaleZombie/walk", 110);
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

//	public static void main(String[] args) {
//		new AnimationLoader();
//	}
	
}
