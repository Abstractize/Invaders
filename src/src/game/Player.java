package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;




public class Player {
	private int PosX;
	private int PosY;
	private int pixel_length;
	private int pixel_heigth;		
	private int Width;
	private boolean left, right,shoot;
	private ImageIcon icon;
	private Image image;
	private queue charger;
	private int cont;
	
	public Player(){
		pixel_length = 100;
		pixel_heigth = 100;
		PosX = 683-(pixel_length/2);
		PosY = 610;
		Width = 1366;
		icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\MexicanHat.png");
		image = icon.getImage();
		charger = new queue();
		cont = 0;
	}
	public void update() {
		if (!left && right) {
			moveRigth();
		}
		if (!right && left) {
			moveLeft();
		}
		for (int i=0;i<charger.getLength();i++) {
			charger.getValue(i).update(this.getCentX(), PosY,this);
		}
		if (shoot) {
			if (cont == 0) {
				Bullets aux = new Bullets(this.getCentX(), this.PosY);
				charger.enqueue(aux);
				cont = 	100;
			}cont--;
			
		}
	}
	public void paint(Graphics g) {
		g.drawImage(image, PosX, PosY, pixel_length, pixel_heigth, null);
		for (int i=0;i<charger.getLength();i++) {
			charger.getValue(i).paint(g);
		}

	}
	public void moveRigth() {
			int validate = (Width*3/4)- pixel_length;
			if(PosX >= validate) {
				PosX = validate;
			}else {
				PosX+= 1;
			}
	}
	public void moveLeft() {
		int validate = (Width/4);
			if(PosX < validate) {
				PosX = validate ;
			}else {
				PosX-= 1;
		}
	}
	public int getCentX() {
		return PosX + 25;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Getters y Setters
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
	

	public int getPixel_length() {
		return pixel_length;
	}

	public void setPixel_length(int pixel_length) {
		this.pixel_length = pixel_length;
	}

	public int getPixel_heigth() {
		return pixel_heigth;
	}

	public void setPixel_heigth(int pixel_heigth) {
		this.pixel_heigth = pixel_heigth;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isShoot() {
		return shoot;
	}
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public queue getBullets() {
		return charger;
	}
	public void setBullets(queue bullets) {
		this.charger = bullets;
	}

}
