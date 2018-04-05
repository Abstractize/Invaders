package singleEnemys;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Enemy {
	protected int PosX;
	protected int sizeX;
	protected int sizeY;
	protected int resistance;
	private ImageIcon icon;
	protected Image image;
	
	public Enemy(int x,int level) {
		PosX = x;
		sizeX = 50;
		sizeY = 50;
		
		
		resistance = (level-1);//incrementa de acuerdo al nivel		
		}
	public void sumPosX(int sum, int level) {
		this.PosX += sum*level; 
	}
	public void minusRes(int value) {
		this.resistance-=value;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}