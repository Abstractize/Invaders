package Enemys;

import java.awt.Graphics;

import ADT.List;
import singleEnemys.Enemy;
import singleEnemys.TypeA;

public abstract class row {
	private int PosY;
	private int length;
	private int Level;
	private int Xconstant;
	private List list;
	private int MinX;
	private int MaxX;
	private int direc;
	private int cont=0;
	
	public row(int Width, int level) {
		list = new List();
		PosY = 0;
		length = 5 + 2*(level-1);
		Level = level;
		Xconstant = (Width/2)-(30*length/2) ;
		MinX = Width/4;
		MaxX = Width*3/4;
		direc = 1;
		this.insert();
	}
	
	public void insert() {
		for (int i = 0; i < length; i++) {
			int PosX = Xconstant + 30*i;
			Enemy aux = new TypeA(PosX,Level) ;
			this.list.add(aux);
		}
	}
	public void draw(Graphics g) {
		for (int i = 0; i < length; i++) {
			Enemy aux = this.list.getValue(i);
			g.setColor(aux.getImage());
			g.fillRect(aux.getPosX(),PosY,aux.getSizeX(),aux.getSizeY());
			}
	}
	public void update(int level) {
		int value = 30 - (level-1);
		if (cont==value){
			for (int i = 0; i < length; i++) {
				Enemy aux = this.list.getValue(i);
				aux.sumPosX(this.direc);
			}
			if(list.getValue(0).getPosX() == MinX){//Cambiar de acuerdo a velocidad
				this.direc = 1;
				this.PosY +=10;
			}
			if(list.getValue(length-1).getPosX()+30 == MaxX) {
				this.direc = -1;
				this.PosY +=10;
			}
			cont = 0;
		}
		cont++;
	}
	public void setx(){
		for (int i = 0; i < length; i++) {
			this.Xconstant = list.getValue(0).getPosX()+20; 
			int PosX = Xconstant + 30*i;
			Enemy aux = list.getValue(i);
			aux.setPosX(PosX);
		}
	}
	public void collision(int bulletx, int bullety) {
		if(bullety == this.PosY && length != 0){
			for (int i = 0; i < length; i++) {
				Enemy aux = list.getValue(i);
				if(aux.getPosX() <= bulletx && bulletx <= (aux.getPosX()+aux.getSizeX())) {
					this.list.delete(aux);
					length --;
					this.setx();
							
					
				}
			}
			
		}
	}

}
