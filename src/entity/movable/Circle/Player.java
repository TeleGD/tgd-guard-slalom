package entity.movable.Circle;

import org.newdawn.slick.Image;

public class Player extends Character {

	protected Array<Capacity> inventaire;
	
	public Player(double x, double y, double sx, double sy, Image im, Array<Capacity> inv) {
		super(x, y, sx, sy, im);
		this.inventaire=inv;
	}

	//--------------------------Get-------------------
	
	public Array<Capacity> getInventaire() {
		return inventaire;
	}

	//-------------------------Set--------------------
	
	public void setInventaire(Array<Capacity> inventaire) {
		this.inventaire = inventaire;
	}

	@Override
	public int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}