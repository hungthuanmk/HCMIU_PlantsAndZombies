package pz;

import org.newdawn.slick.Animation;

import com.Position;

/**
 * 
 * @author Nguyen Phan Hung Thuan
 *
 */
public interface CharacterI {
    Animation getAnimation(); 
	void      setAnimation(Animation ani);    
	
	int  	  getAttackInterval();		
	void      setAttackInterval(int attackInterval); 
	
	int 	  getFramePassed();
	void 	  setFramePassed(int framePassed);
	
	String    getName(); 		 	 
	void      setName(String name); 

	Position  getPos(); 		
	void      setPos(Position pos); 	 
	void      setPos(float x, float y);

	Integer   getHp(); 			
	void      setHp(Integer hp); 	 

	int       getDamage(); 	      
	void      setDamage(int damage);

	float     getSpeed(); 		     
	void      setSpeed(float speed);

	float 	  getWidth();
	float 	  getHeight();

	void 	  move();
	void 	  draw(boolean updateImg);
}
