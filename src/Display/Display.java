package Display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import Enemys.*;
import game.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Display extends JPanel implements KeyListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//variables de juego
	//private int score = 0;
	private int Level;
	private int Width;
	private int Heigth;
	private int Cont;
	private boolean play;
	
	//private int totalBricks = 21;
	//Timer
	private Timer timer;
	private int delay = 0;
	//Jugador
	private Player player;
	private Bullets bullet;
	//Enemigos
	private row enemies;
	private row next;
	//imagenes
	private ImageIcon icon;
	private Image bg;
	
	public Display(int width, int heigth) {
		play=false;
		Width = width;
		Heigth = heigth;
		Level = 1;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		Cont=3;
		//Jugador
		player = new Player();
		bullet = new Bullets(player.getPosX(),player.getPosY());
		//Enemigos
		enemies = Factory.create(Width,Level);
		next = Factory.create(Width, Level);
		//imagenes
		icon = BackGroundFactory.create(Width, Heigth);
		bg = icon.getImage();
	}
	public void paint(Graphics g) {
		//background
		g.drawImage(bg , Width*1/4, 0, Width/2, Heigth, this);
		g.setColor(Color.gray);//color
		g.fillRect(0, 0, Width/4, Heigth);//size
		g.setColor(Color.gray);//color
		g.fillRect(Width*3/4, 0, Width*1/4, Heigth);//size
		
		//Player
		player.paint(g);
		bullet.paint(g);
		//Enemies
		enemies.draw(g);
		//Font Displays
		g.drawImage(enemies.getClassimage(), 0, 0, null);
		g.drawImage(next.getClassimage(), 0, 100, null);
		
		
		g.dispose();
		}
	public void update(){
		if (enemies.isEmpty()){
			if (Cont == 0) {
				Level++;
				bg = icon.getImage();
				Cont = 3+((Level-1)*2);
		}else {
			Cont--;
			enemies=next;
			next=Factory.create(Width,Level);
			icon = BackGroundFactory.create(Width, Heigth);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (play){
			timer.start();
			bullet.update(player.getCentX(),player.getPosY(),enemies.isCollision());
			enemies.update(Level);
			enemies.collision(bullet.getPosX(), bullet.getPosY());
			this.update();
			repaint();
			// TODO Auto-generated method stub
			}
		
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.setPlay(true);
			bullet.setShoot(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			this.setPlay(true);
			player.moveRigth();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			this.setPlay(true);
			player.moveLeft();
		}
		// TODO Auto-generated method stub
	}
	private void setPlay(boolean b) {
		play = b;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		// TODO Auto-generated method stub
		
	}
	
	
	

}

