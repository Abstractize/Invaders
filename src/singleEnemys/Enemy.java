package singleEnemys;

import java.awt.Color;

public abstract class Enemy {
	protected int PosX;
	protected int sizeX;
	protected int sizeY;
	protected int resistance;
	protected Color image;
	
	public Enemy(int x,int level) {
		PosX = x;
		sizeX = 25;
		sizeY = 25;
		setImage(Color.blue);
		
		resistance = 1 + (level-1);//incrementa de acuerdo al nivel		
		}
	public void sumPosX(int sum) {
		this.PosX += sum; 
	}
	public void collision(int bulletx, int bullety) {
		if(bulletx >= this.PosX && bulletx <= this.sizeX + this.PosX){
			
		}
	}

//Getter y Setters
	public int getPosX() {
		return PosX;
	}

	public void setPosX(int posX) {
		PosX = posX;
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

	public Color getImage() {
		return image;
	}

	public void setImage(Color image) {
		this.image = image;
	}
}