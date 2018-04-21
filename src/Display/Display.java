package Display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import Enemys.*;
import game.*;
import sockets.connector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Display extends JPanel implements KeyListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//variables de juego
	private int score;
	private int Level;
	private int Width;
	private int Heigth;
	private int Cont;
	private boolean play;
	private boolean phone;
	private boolean gameover;
	
	//Timer
	private Timer timer;
	private int delay = 0;
	//Jugador
	private Player player;
	//Enemigos
	private row enemies;
	private row next;
	//imagenes
	private ImageIcon icon;
	private ImageIcon panelIcon;
	private Image bg;
	private Image panel;
	private int updater;
	//Servidor
	connector c;
	
	public Display(int width, int heigth) {
		c = connector.getConnector(this);//Instanciamos el servidor
		c.start();//Iniciamos el Thread en el que está
		//Definimos Variables de juego
		play=false;
		phone=false;
		Width = width;
		Heigth = heigth;
		Level = 1;
		setScore(0);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		//Inicialización de un timer para eventos y juego;
		timer = new Timer(delay,this);
		timer.start();
		//Contador de enemigos en el nivel
		Cont=3;
		//Jugador
		player = new Player();
		//Enemigos
		enemies = ChooseEnemies();
		next = ChooseEnemies();
		//imagenes
		icon = BackGroundFactory.create(Width, Heigth);
		panelIcon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\BossWall2.jpg");
		bg = icon.getImage();
		panel = panelIcon.getImage(); 
	}
	public row ChooseEnemies() {//Funcion que llama al Abstract Factory para crear enemigos
		int random = (int) (Math.random()*2);
		int type = (int) (Math.random()*3);
		row row = null;
		Factory factory;
		if (random == 0) {
			factory = new DefaultFactory();
		}else {
			factory = new ModifiedFactory();
		}
		if (type == 0) {
			row = factory.createSingleRow(Width, Level);
		}
		else if (type == 1) {
			row = factory.createOther(Width, Level);
		}
		else if (type == 2) {
			row = factory.createCircularRow(Width, Level);
		}
		return row;
	}
	public void paint(Graphics g) {//Funcion para dibujar en pantalla
		//background
		g.setColor(Color.black);
		g.drawImage(panel , 0, 0, Width, Heigth, this);
		g.drawImage(bg , Width*1/4, 0, Width/2, Heigth, this);
		
		
		//Player
		player.paint(g);
		//Enemies
		enemies.draw(g);
		//Font Displays
		g.setColor(Color.white);
		g.setFont(new Font("JI Chimichanga", Font.PLAIN, 80));
		g.drawString("Enemies:", 10, 100);
		g.drawString(enemies.getName(), 30, 160);
		g.drawString("Next:", 10, 240);
		g.drawString(next.getName(), 30, 300);
		g.drawString("Score:", (Width*3/4)+10, 100);
		g.drawString(String.valueOf(score), (Width*3/4)+30, 160);
		g.drawString("Level:", (Width*3/4)+10, 240);
		g.drawString(String.valueOf(Level), (Width*3/4)+30, 300);
				
		//Game Over
		if (gameover) {
			g.drawString("GAME OVER", (Width/4)+180, Heigth/2);
			
		}
		
		g.dispose();
		}
	//Verifica el mensaje proveniente del Socket
	public void verifyMess(String message){
		if (phone){
			System.out.println("verify " + message);
			int msg = Integer.valueOf(message);
			if (msg == 1) {
				System.out.println("shoot");
				player.setShoot(true);
			}
			if (msg == 2) {
				player.setRight(true);
			}
			if (msg == 3) {
				player.setLeft(true);
			}
			if (msg == 0){
				player.setLeft(false);
				player.setRight(false);
				player.setShoot(false);
			}
		}
		
		
	}
	@SuppressWarnings("deprecation")
	public void update(){
		if (enemies.isEmpty()){
			if (Cont == 0) {
				Level++;
				bg = icon.getImage();
				Cont = 3+((Level-1)*2);
			}else {
				Cont--;
				enemies=next;
				next=ChooseEnemies();
				icon = BackGroundFactory.create(Width, Heigth);
			}
		}
		if (enemies.getPosY() > player.getPosY()) {
			gameover=true;
			play = false;
			c.stop();
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (play){
			verifyMess(c.getMessage());
			timer.start();
			player.update();
			if (!player.getBullets().empty()) {
				for (int i=0; i< player.getBullets().getLength(); i++) {
					 Bullets aux = player.getBullets().getValue(i);
					 enemies.collision(aux,this);
				}
			}
			enemies.update(Level);

			
			
			
			this.update();
			repaint();
			// TODO Auto-generated method stub
			}
		
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER){
			this.setPlay(true);
			this.setPhone(true);
		}
		if (key == KeyEvent.VK_SHIFT){
			this.setPlay(true);
		}
		if (key == KeyEvent.VK_SPACE) {
			
			player.setShoot(true);
		}
		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			
			player.setRight(true);
		}
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			
			player.setLeft(true);
		}
		// TODO Auto-generated method stub
	}
	private void setPlay(boolean b) {
		play = b;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
			if (key == KeyEvent.VK_SPACE) {
				player.setShoot(false);
			} 	
			if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				player.setRight(false);
			}
			if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				player.setLeft(false);
			}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		// TODO Auto-generated method stub	
	}
	//Getters y Setters
	public int getScore() {
		return score;
	}
	public int getLevel() {
		return Level;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getUpdater() {
		return updater;
	}
	public void setUpdater(int updater) {
		this.updater = updater;
	}
	public row getEnemies() {
		return enemies;
	}
	public row getNext() {
		return next;
	}
	public boolean isPhone() {
		return phone;
	}
	public void setPhone(boolean phone) {
		this.phone = phone;
	}
	
	
	

}

