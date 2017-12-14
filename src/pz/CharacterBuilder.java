package pz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.Position;

import gui.PZGUI;
import gui.PlayUI;

/**
 * 
 * @author Nguyen Phan Hung Thuan
 *
 */
public class CharacterBuilder {

	@SuppressWarnings("rawtypes")
	/**
	 * Create a new plant with corresponding class
	 * @param plantClass	Plant class, ex Peashooter.class
	 * @param pos	Position
	 * @return	Plant
	 */
	public static Plant buildPlant(Class plantClass, Position pos) {
		try {
			@SuppressWarnings("unchecked")
			Constructor constructor = plantClass.getConstructor(Position.class);
			return (Plant)constructor.newInstance(pos);
		} catch (NoSuchMethodException  | SecurityException        | InstantiationException | 
				 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("<WARNING:BUILDER:PLANT> CREATED NULL OBJ");
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * Create a new plant with class, at position row index, column index
	 * @param plantClass	Plant class
	 * @param rowIdx	Row index
	 * @param colIdx	Column index
	 * @return	Plant
	 */
	public static Plant buildPlant(Class plantClass, int rowIdx, int colIdx) {
		Position pos = new Position(PlayUI.getPlantZonePosX() + PlayUI.getCellW()*colIdx,
									PlayUI.getPlantZonePosY() + PlayUI.getCellH()*rowIdx);
		Plant plant = buildPlant(plantClass, pos);
		plant.setPos(plant.getPos().x, plant.getPos().y);
		return plant;
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * Create a new zombie with corresponding class
	 * @param zombieClass	Zombie class
	 * @param pos	Position
	 * @return	Zombie
	 */
	public static Zombie buildZombie(Class zombieClass, Position pos) {
		try {
			@SuppressWarnings("unchecked")
			Constructor constructor = zombieClass.getConstructor(Position.class);
			return (Zombie)constructor.newInstance(pos);
		} catch (NoSuchMethodException  | SecurityException        | InstantiationException | 
				 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("<WARNING:BUILDER:ZOMBIE> CREATED NULL OBJ");
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * Create a new zombie with corresponding class
	 * @param zombieClass	Zombie class
	 * @param rowIdx	Row index
	 * @return	Zombie
	 */
	public static Zombie buildZombie(Class zombieClass, int rowIdx) {
		rowIdx = rowIdx < 0 ? 0 : rowIdx > 4 ? 4 : rowIdx;
		Position pos = new Position(PZGUI.getWidth(), PlayUI.getPlantZonePosY() + rowIdx*PlayUI.getCellH());
		Zombie zombie =  buildZombie(zombieClass, pos);
		zombie.setPos(zombie.getPos().x, zombie.getPos().y - (zombie.getHeight() - PlayUI.getCellH()/1.05f));
		return zombie;
	}
	
}
