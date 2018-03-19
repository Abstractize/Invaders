package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Bullets extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int PosX;
	private int PosY;
	private int PosXinit;
	private int PosYinit;
	private int sizeX;
	private int sizeY;
	private boolean shoot;
	
	public Bullets(int x,int y) {
		PosX=x;
		PosY=y;
		PosX = PosXinit;
		PosY = PosYinit;
		sizeX=5;
		sizeY=15;
		shoot = false;
		
		
	}
	@Override
	public void paint(Graphics g) {
		if (shoot) {
			g.setColor(Color.red);
			g.fillRect(PosX, PosY, sizeX, sizeY);	
		}
	
}
	public void update(int x,int y) {
		if (shoot){
			PosY-=1;
		}
		if (PosY == 0) {
			shoot= false;
		}
		if (!shoot) {
			PosY=y;
			PosX=x;
		}
	}

	
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int posY) {
		PosY = posY;
	}
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
	public boolean isShoot() {
		return shoot;
	}
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
}
