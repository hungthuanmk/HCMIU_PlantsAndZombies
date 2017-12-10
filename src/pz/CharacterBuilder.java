package pz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.Position;

public class CharacterBuilder {

	public Plant createPlant(Class plantClass, Position pos) {
		try {
			Constructor constructor = plantClass.getConstructor(Position.class);
			return (Plant)constructor.newInstance(pos);
		} catch (NoSuchMethodException  | SecurityException        | InstantiationException | 
				 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("<WARNING:BUILDER:PLANT> CREATED NULL OBJ");
		return null;
	}
	
	public Zombie createZombie(Class zombieClass, Position pos) {
		try {
			Constructor constructor = zombieClass.getConstructor(Position.class);
			return (Zombie)constructor.newInstance(pos);
		} catch (NoSuchMethodException  | SecurityException        | InstantiationException | 
				 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("<WARNING:BUILDER:ZOMBIE> CREATED NULL OBJ");
		return null;
	}
	
}
