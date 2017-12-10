package gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Seed {
	@SuppressWarnings("rawtypes")
	private Class 	_class;
	private Image 	img;
	private Integer money;
	
	@SuppressWarnings("rawtypes")
	public Class get_class() 		    {return _class;       }
	@SuppressWarnings("rawtypes")
	public void set_class(Class _class) {this._class = _class;}

	public Image getImg() 			    {return img;          }
	public void setImg(Image img)       {this.img = img;      }

	public Integer getMoney()           {return money;        }
	public void setMoney(Integer money) {this.money = money;  }

	@SuppressWarnings("rawtypes")
	public Seed(Class _class, Image img, Integer money) {
		this._class = _class;
		this.img = img;
		this.money = money;
	}

	@SuppressWarnings("rawtypes")
	public Seed(Class _class, String img, Integer money) {
		this._class = _class;
		try {
			this.img = new Image(img);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.money = money;
	}

}
