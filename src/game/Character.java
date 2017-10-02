package game;

public class Character {
	
//	private boolean running = true;
	
	private String name;
	private Position pos;
	private String img; 
	private int hp = 0;
	private int damage = 0;
	private int speed = 0;
	private int attackInterval=100;
	//private Direction dir = Direction.LEFT; 
	//private Thread thread;
	
	public Character(String name) {
		
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected void setName(String S) {
		this.name = S;
	}
	
	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void move() {
		Position newPos = new Position(this.getPos().x + this.speed, this.getPos().y);
		this.setPos(newPos);
	}
	
	public void draw() {
		//TODO: draw image to GUI
	}


}

