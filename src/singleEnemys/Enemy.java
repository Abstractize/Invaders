package singleEnemys;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	protected int PosX;
	protected int PosY;
	protected int sizeX;
	protected int sizeY;
	protected int resistance;
	
	public Enemy(int x, int y,int level) {
		PosX = x;
		PosY = y;
		sizeX = 25;
		sizeY = 25;
		resistance = 1 + (level-1);//incrementa de acuerdo al nivel
		
		
		
		}
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(PosX, PosY, sizeX, sizeY);
	}
	
	
	
	
	

//Getter y Setters
	public int getPosX() {
		return PosX;
	}

	public void setPosX(int posX) {
		PosX = posX;
	}

	public int getPosY() {
		return PosY;
	}

	public void setPosY(int posY) {
		PosY = posY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
}