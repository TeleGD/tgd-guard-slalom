package entity.circle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.capacity.Capacity;

public class CapacityItem extends Item {

	protected Capacity capacityGranted;

	public CapacityItem(double x, double y) {
		super(x, y);
	}

	//-------------------------Get-----------------
	public Capacity getCapacityGranted() {
		return capacityGranted;
	}

	//-------------------------Set------------------
	public void setCapacityGranted(Capacity capacityGranted) {
		this.capacityGranted = capacityGranted;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}
	
}
