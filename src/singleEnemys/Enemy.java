package singleEnemys;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Enemy {
	
	private int PosX;
	private int PosY;
	private int sizeX;
	private int sizeY;
	private int resistance;
	private int resistanceInit;
	private ImageIcon icon;
	private Image image;
	private int RadialPosX;
	private int RadialPosY;
	
	public Enemy(int x,int level) {
		PosX = x;
		sizeX = 50;
		sizeY = 50;
		this.setResistance(this.setHabitualResistance(level));
		this.setResistanceInit(this.getResistance());
		this.setImages();
		this.setImage(getIcon().getImage());
		}
	public void sumPosX(int sum, int level) {
		this.PosX += sum*level; 
	}
	public void minusRes(int value) {
		this.resistance-=value;
		this.setImages();
		this.setImage(getIcon().getImage());
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
	public int setHabitualResistance(int level) {
		return resistance;
	}
	public void setImages(){
	}
	public int getResistanceInit() {
		return resistanceInit;
	}
	public void setResistanceInit(int resistanceInit) {
		this.resistanceInit = resistanceInit;
	}
	public int getRadialPosX() {
		return RadialPosX;
	}
	public void setRadialPosX(int radius, double angle) {
		RadialPosX = (int) (radius* Math.cos(angle)) + PosX;
		System.out.println(RadialPosX);
	}
	public int getRadialPosY() {
		return RadialPosY;
	}
	public void setRadialPosY(int radius, double angle) {
		RadialPosY = (int) (radius* Math.sin(angle)) + PosY;
		System.out.println(RadialPosY);
	}
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int posY) {
		PosY = posY;
	}
}