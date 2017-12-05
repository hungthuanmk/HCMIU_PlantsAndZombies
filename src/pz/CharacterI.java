package pz;

import org.newdawn.slick.Animation;

import com.Position;

public interface CharacterI {
	public Animation getAnimation(); 
	public void      setAnimation(Animation ani);    
	
	public int  	getAttackInterval();		
	public void     setAttackInterval(int attackInterval); 
	
	public String   getName(); 		 	 
	public void     setName(String name); 

	public Position getPos(); 		
	public void     setPos(Position pos); 	 
	public void     setPos(float x, float y);

	public Integer  getHp(); 			
	public void     setHp(Integer hp); 	 

	public int      getDamage(); 	      
	public void     setDamage(int damage);

	public float    getSpeed(); 		     
	public void     setSpeed(float speed);

	public float getWidth();
	public float getHeight();

	public void move();
	public void draw();
}
