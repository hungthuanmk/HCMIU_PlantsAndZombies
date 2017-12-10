package gui;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class AnimationLoader {

//	private static Animation sun 		= new Animation();
//	private static Animation peashooter = new Animation();
	
	public AnimationLoader() {
		//listFilesForFolder("res/");
	}
	
	public static void listFilesForFolder(String folder) {
	   File f = new File(folder);
	   String[] dirs = f.list(new FilenameFilter() {
		   @Override
		   public boolean accept(File dir, String name) {
			   return true;
			   //return new File(dir, name).isDirectory();
		   }
	   });
	   System.out.println(Arrays.toString(dirs));
	}

	public static void main(String[] args) {
		listFilesForFolder("res/");
	}
	
	
}
