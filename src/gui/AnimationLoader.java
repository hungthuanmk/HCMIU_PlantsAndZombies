package gui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AnimationLoader {

	public static ArrayList<AnimationItem> aniList = new ArrayList<>();
	
	public AnimationLoader() {
		
		String plantDir = "res/Plants/";
		String zombieDir = "res/ZombieTest/";
		String[] plantFolder = getFolders(plantDir);
		String[] zombieFolder = getFolders(zombieDir);
		System.out.println(Arrays.toString(plantFolder));
		for (int i=0; i<plantFolder.length; i++) {
			String[] imgs = getFiles(plantDir+plantFolder[i]+"/Idle/");
			if (imgs.length != 0) {
				try {
					AnimationItem item = new AnimationItem(Class.forName("pz.plant."+plantFolder[i]));
					for (int k=0; k<imgs.length; k++) {
						item.getAni().addFrame(new Image(plantDir + plantFolder[i] +"/Idle/" + imgs[k]), 30);
					}
					aniList.add(item);
				} catch (ClassNotFoundException e) {
					//e.printStackTrace();
					System.out.println("<ERROR:ANIMATION> NOT FOUND CLASS "+plantFolder[i]);
					continue;
				} catch (SlickException e) {
					e.printStackTrace();
				}
				
			}			
			System.out.println("LOADED " + Arrays.toString(imgs) + " -> " + plantFolder[i]);
		}
		
		System.out.println(Arrays.toString(zombieFolder));
		for (int i=0; i<zombieFolder.length; i++) {
			String[] imgs = getFiles(zombieDir+zombieFolder[i]+"/walk/");
			if (imgs.length != 0) {
				try {
					AnimationItem item = new AnimationItem(Class.forName("pz.zombie."+zombieFolder[i]));
					for (int k=0; k<imgs.length; k++) {
						item.getAni().addFrame(new Image(zombieDir + zombieFolder[i] +"/walk/" + imgs[k]), 30);
					}
					aniList.add(item);
				} catch (ClassNotFoundException e) {
					//e.printStackTrace();
					System.out.println("<ERROR:ANIMATION> NOT FOUND CLASS "+zombieFolder[i]);
					continue;
				} catch (SlickException e) {
					e.printStackTrace();
				}
				
			}			
			System.out.println("LOADED " + Arrays.toString(imgs) + " -> " + zombieFolder[i]);
		}
		
	}
	
	public static Animation getAnimation(Class _className) {
		for (int i=0; i<aniList.size(); i++) {
			//if (aniList.get(i).get_class().getSimpleName().equals(_className.getSimpleName())) {
			if (aniList.get(i).get_class() == _className) {
				return aniList.get(i).getAni().copy();
			}
		}
		return null;
	}
	
	
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
	
	private static String[] getFiles(String directory) {
		File f = new File(directory);
		String[] dirs = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//if (getFileExtension(name).equals("png"))
					return true;	
				//return false;
			}
		});
		return dirs;
	}
	
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
