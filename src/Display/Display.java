package Display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import Enemys.*;
import game.*;

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
	
	//private int totalBricks = 21;
	//Timer
	private Timer timer;
	private int delay = 0;
	//Jugador
	Player player;
	Bullets bullet;
	//Enemigos
	Basic enemies;
	
	public Display(int width, int heigth) {
		Width = width;
		Heigth = heigth;
		Level = 1;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
		//Jugador
		player = new Player();
		bullet = new Bullets(player.getPosX(),player.getPosY());
		//Enemigos
		enemies = new Basic(Width, Level);
	}
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);//color
		g.fillRect(Width*1/4, 0, Width/2, Heigth);//size
		//Player_Applets
		g.setColor(Color.gray);//color
		g.fillRect(0, 0, Width/4, Heigth);//size
		g.setColor(Color.gray);//color
		g.fillRect(Width*3/4, 0, Width*1/4, Heigth);//size
		
		//Player
		player.paint(g);
		bullet.paint(g);
		//Enemies
		enemies.draw(g);
		
		
		g.dispose();
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		bullet.update(player.getCentX(),player.getPosY());
		enemies.update(Level);
		enemies.collision(bullet.getPosX(), bullet.getPosY());
		repaint();
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			bullet.setShoot(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.moveRigth();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.moveLeft();
		}
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

