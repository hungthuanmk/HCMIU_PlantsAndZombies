package game;

public class Character {
	public enum Direction {LEFT, RIGHT};
	
	private String name;
	private int x, y;
	private int hp = 0;
	private Direction dir = Direction.LEFT; 
	
	protected String getName() {
		return this.name;
	}
	
	protected void setName(String S) {
		this.name = S;
	}
	
	public Character() {
		
	}
}
