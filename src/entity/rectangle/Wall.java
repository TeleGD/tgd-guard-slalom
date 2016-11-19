package entity.rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import fr.interfaces.Rectangle;

public class Wall extends EntityRectangle {

	protected Image img;

	public Wall(double x, double y, Image img) {
		super(x, y);
		this.img = img;
	}
	
	public Wall (int nbrTuilesX, int nbrTuilesY, Image tuileTop, Image tuile){
		super(x,y);
		this.x=nbrTuilesX*32;
		this.y=nbrTuilesY*32;
	}

	//----------------------------Get---------------
	
	public Image getImg() {
		return img;
	}

	//----------------------------Set---------------
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		arg3.setColor(Color.red);
		arg3.fillRect((float)x, (float)y, (float)width, (float)height);
		
		
	}
}
