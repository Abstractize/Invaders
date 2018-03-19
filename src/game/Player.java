package game;

import java.awt.Color;
import java.awt.Graphics;
//import java.net.URL;



public class Player {
	private int PosX;
	private int PosY;
	private int pixel_length;
	private int pixel_heigth;		
	private int Width;
	
	
	public Player(){
		pixel_length = 50;
		pixel_heigth = 50;
		PosX = 683-(pixel_length/2);
		PosY = 610;
		Width = 1366;

	}
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(PosX, PosY, pixel_length, pixel_heigth);

	}
	public void moveRigth() {
			int validate = (Width*3/4)- pixel_length;
			if(PosX >= validate) {
				PosX = validate;
			}else {
				PosX+= 20;
			}
	}
	public void moveLeft() {
		int validate = (Width/4);
			if(PosX < validate) {
				PosX = validate ;
			}else {
				PosX-= 20;
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

}
