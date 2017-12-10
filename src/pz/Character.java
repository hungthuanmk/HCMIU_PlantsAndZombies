package pz;

import org.newdawn.slick.Animation;
import com.Position;

abstract class Character implements CharacterI{

	private String   name;
	private Position pos;
	private Animation ani = new Animation();
	private int  	 hp     = 10000;
	private int      damage = 0;
	private float    speed  = 0;
	private int      attackInterval;
	private int		 framePassed = 0;
	
	public int 	getFramePassed() 				{return framePassed;}
	public void setFramePassed(int framePassed) {this.framePassed = framePassed;}

	public void		 setAnimation(Animation ani) 	  {this.ani = ani;}
	public Animation getAnimation() 			 	  {return ani;}
	
	public int  	getAttackInterval() 				  {return attackInterval;}
	public void     setAttackInterval(int attackInterval) {this.attackInterval = attackInterval;}
	
	public String   getName() 		 	 {return name;}
	public void     setName(String name) {this.name = name;}

	public Position getPos() 			 	 {return pos;}
	public void     setPos(Position pos) 	 {this.pos = pos;}
	public void     setPos(float x, float y) {this.pos = new Position(x,y);}

	public Integer  getHp() 			 {return hp;}
	public void     setHp(Integer hp) 	 {this.hp = hp;}

	public int      getDamage() 	      {return damage;}
	public void     setDamage(int damage) {this.damage = damage;}

	public float    getSpeed() 		      {return speed;}
	public void     setSpeed(float speed) {this.speed = speed;}
	
	/**
	 * Character constructor
	 * @param name	Name
	 * @param hp	Health power
	 * @param damage	Damage
	 * @param attackInterval	Attack interval
	 * @param pos	Position
	 */
	public Character(String name, Integer hp, int damage, int attackInterval, Position pos) {
		setName(name);
		setHp(hp);
		setDamage(damage);
		setAttackInterval(attackInterval);
		setPos(pos);
	}

	public abstract float getWidth();
	public abstract float getHeight();

	public abstract void move();
	public abstract void draw(boolean updateImg);
	
	protected abstract void loadAnimation();
}
