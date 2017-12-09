package pz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.Position;

import pz.plant.Peashooter;

public class PlantBuilder {

	public Plant createPlant(Class plantClass, Position pos) {
		try {
			Constructor constructor = plantClass.getConstructor(Position.class);
			return (Plant)constructor.newInstance(pos);
		} catch (NoSuchMethodException  | SecurityException        | InstantiationException | 
				 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("<WARNING> CREATED NULL OBJ");
		return null;
	}
	
}
