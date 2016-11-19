package fr.basic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.circle.Item;
import entity.movable.circle.Guard;
import entity.movable.circle.Player;
import entity.movable.Projectile;
import entity.rectangle.Wall;
import fr.util.Chrono;
import fr.vision.Area;
import fr.capacity.Capacity;

public class World extends BasicGameState{

	private int ID;
	private Chrono chrono;
	private Player player;
	private StateBasedGame game;
	private ArrayList<Wall> walls;
	private ArrayList<Guard> guards;
	private ArrayList<Item> items;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Area> areas;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		guards=new ArrayList<Guard>();
		guards.add(new Guard(100,100,1,1,null,this));
		
		walls = new ArrayList<Wall>();
		guards = new ArrayList<Guard>();
		items = new ArrayList<Item>();
		projectiles = new ArrayList<Projectile>();
		player = new Player(500., 300., 0., 0., null, new ArrayList<Capacity>(),this);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		for(Wall w : walls){
			w.render(arg0, arg1, arg2);
		}
		
		for(Guard g : guards){
			g.render(arg0, arg1, arg2);
		}
		
		for(Item i : items){
			i.render(arg0, arg1, arg2);
		}
		
		for(Projectile p : projectiles){
			p.render(arg0, arg1, arg2);
		}
		player.render(arg0, arg1, arg2);	
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		for(Wall w : walls){
			w.update(arg0, arg1, arg2);
		}
		
		for(Guard g : guards){
			g.update(arg0, arg1, arg2);
		}
		
		for(Item i : items){
			i.update(arg0, arg1, arg2);
		}
		
		for(Projectile p : projectiles){
			p.update(arg0, arg1, arg2);
		}
		player.update(arg0, arg1, arg2);
		
	}

	@Override
	public int getID() {
		return ID;
	}
	
	public void keyPressed(int key, char c){
		player.keyPressed(key,c);
	}
	
	public void keyReleased(int key, char c){
		player.keyReleased(key,c);
	}
	
	public void addWall(Wall w){
		walls.add(w);
	}
	
	public void addGuard(Guard g){
		guards.add(g);
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public void addProjectiles(Projectile p){
		projectiles.add(p);
	}
	
	public void addArea(Area a) {
		areas.add(a);
	}
	
	public ArrayList<Wall> getWalls(){
		return walls;
	}
	
	public ArrayList<Guard> getGuards(){
		return guards;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public ArrayList<Area> getAreas() {
		return areas;
	}
	
	public ArrayList<Entity> getEntities(){
		ArrayList<Entity> tmp = new ArrayList<Entity>();
		tmp.addAll(walls);
		tmp.addAll(guards);
		tmp.addAll(items);
		tmp.addAll(projectiles);
		return tmp;
	}
	
	public void reset(){
		
	}

}
