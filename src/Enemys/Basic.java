package Enemys;

import java.awt.Graphics;

import ADT.List;
import singleEnemys.Enemy;
//import singleEnemys.TypeA;

public class Basic{
	int PosY;
	int length;
	int Level;
	int large;
	int Xconstant;
	List list;
	
	public Basic(int Width,int Heigth, int level) {
		PosY = 0;
		length = 5 + (2*(level-1));
		large = 30*length;//num Pixeles x los elementos que va a tener
		Level = level;
		Xconstant = (Width/2)-(large/2) ;
		this.insert();
	}
	
	public void insert() {//Error aca
		for (int i = 0; i <= length; i++) {
			int PosX = Xconstant + large*(i/length);
			Enemy aux = new Enemy(PosX,PosY,Level) ;
			list.add(aux);
		}
	}
	public void draw(Graphics g) {
		int ilen = length;
		while (ilen!= 0) {
			Enemy enemy = list.getValue(ilen);
			enemy.draw(g);
			ilen=-1;
		}
		
			
	}

}
