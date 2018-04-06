package Enemys;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public abstract class row {
	private String name;
	private Image classimage;
	private ImageIcon icon;
	private int PosY;
	private int length;
	private int Level;
	private int Xconstant;
	private int MinX;
	private int MaxX;
	private int direc;
	private int cont=0;
	private boolean collision;
	private boolean eliminating;
	private boolean empty;
	
	public row(int Width, int level) {
		setCollision(false);
		setPosY(150);
		length = 5 + 2*(level-1);
		setLevel(level);
		setXconstant((Width/2)-(53*length/2)) ;
		setMinX(Width/4);
		setMaxX(Width*3/4);
		setDirec(1);
	}
	//Metodos
	public void insert() {//Cambian los tipos de listas
		
	}
	public void draw(Graphics g) {
		
	}
	public void update(int level) {
		
	}
	public void setx(){
	}
	public void collision(int bulletx, int bullety) {
	}
	
	
	//getters y setters
	public int getLength() {
		return length;
	}

	public void setLength(int collision) {
		this.length = collision;
	}
	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int posY) {
		PosY = posY;
	}
	public int getXconstant() {
		return Xconstant;
	}
	public void setXconstant(int xconstant) {
		Xconstant = xconstant;
	}
	public int getMinX() {
		return MinX;
	}
	public void setMinX(int minX) {
		MinX = minX;
	}
	public int getMaxX() {
		return MaxX;
	}
	public void setMaxX(int maxX) {
		MaxX = maxX;
	}
	public int getDirec() {
		return direc;
	}
	public void setDirec(int direc) {
		this.direc = direc;
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.setLength(0);
		this.empty = empty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getClassimage() {
		return classimage;
	}
	public void setClassimage(Image classimage) {
		this.classimage = classimage;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public boolean isEliminating() {
		return eliminating;
	}
	public void setEliminating(boolean eliminating) {
		this.eliminating = eliminating;
	}

}
