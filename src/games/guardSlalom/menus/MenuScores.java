package games.guardSlalom.menus;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuScores extends Menu {

	private int ID;

	public int getID() {
		return this.ID;
	}

	private static ArrayList<Long> scores;
	private boolean rendered = false;

	public static void readScores() throws IOException{
		scores = new ArrayList<Long>();
		FileReader fr = new FileReader("res"+File.separator+"data"+File.separator+"guardSlalom"+File.separator+"scores.txt");
		BufferedReader br = new BufferedReader(fr);

		String list ="";
		String currentLine = "";
		String[] listPrime;
		while((currentLine = br.readLine()) != null) {
				list += currentLine;
		}
		listPrime = list.split(";");
		for(String s : listPrime){
			if(!s.isEmpty())scores.add(Long.parseLong(s));
		}
		scores.sort(Comparator.naturalOrder());
		br.close();
	}

	public static void saveScores() throws IOException{
		FileWriter fw = new FileWriter("res"+File.separator+"data"+File.separator+"guardSlalom"+File.separator+"scores.txt",false);
		PrintWriter pw = new PrintWriter(fw);

		for(Long l : scores){
			pw.print(l+";");
			System.out.println("Added "+l);
		}
		pw.println();
		pw.close();

	}

	public MenuScores(int ID) {
		super(11,500,200);
		this.ID = ID;
		scores = new ArrayList<Long>();
		selection = 10;
		for(int i = 1; i<=10; i++){
			items[i-1] = ""+i+" : ";
		}
		items[10] = "Quitter";
		nom = "Tableau des scores";
	}

	public static void addScore(Long l) throws IOException{
		readScores();
		scores.add(l);
		scores.sort(Comparator.naturalOrder());
		saveScores();
	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ESCAPE){
			game.enterState(4 /* MenuFin */, new FadeOutTransition(), new FadeInTransition());
		}
		if(key == Input.KEY_S){
			try {
				saveScores();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.keyPressed(key, c);
	}

	@Override
	public void execOption(){
		switch (selection) {
		case 10:
			game.enterState(4 /* MenuFin */, new FadeOutTransition(),	new FadeInTransition());
			break;
		default:
			break;
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g){
		if(!rendered){
			for(int i = 1; i<=10; i++){
				items[i-1] = ""+i+" : ";
				if(scores.size()>=i) items[i-1] += scores.get(i-1);
			}
			rendered = true;
		}

		super.render(arg0, arg1, g);
	}

	public static void reset(){

	}

}