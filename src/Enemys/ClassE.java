package Enemys;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import ADT.DoubleCircularList;
import singleEnemys.Enemy;
import singleEnemys.TypeA;
import singleEnemys.TypeB;

public class ClassE extends row{
	private DoubleCircularList list;
	private int BossPoss;
	private int level;
	private int angle;
	private boolean BossInserting;
	public ClassE(int Width, int level) {
		super(Width, level);
		this.level = level;
		list = new DoubleCircularList();
		this.insert();
		this.insertBoss(level);
		this.setY();
		this.setName("Class E");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\ClassE.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		// TODO Auto-generated constructor stub
	}
	//Getters y Setters
		public DoubleCircularList getList() {
			return list;
		}
		public void setList(DoubleCircularList list) {
			this.list = list;
		}
		public int getBoss() {
			return BossPoss;
		}
		public void setBoss(int boss) {
			BossPoss = boss;
		}

	//Atributos
	public void insertBoss(int level) {
		BossInserting = true;
		DoubleCircularList lista = this.getList();
		int random = (this.getLength()/2);
		int PosX = lista.getValue(random).getPosX();
		TypeB Boss = new TypeB(PosX,level);
		BossPoss=random;
		lista.swap(Boss, random);
		this.setList(lista);
		BossInserting = false;
	}
	@Override
	public void insert() {
		for (int i = 0; i < this.getLength(); i++) {
			int PosX = this.getXconstant() + 53*i;
			Enemy aux = new TypeA(PosX,getLevel()) ;
			this.list.add(aux);
		}
	}
	@Override
	public void draw(Graphics g) {
		if (!this.list.empty()) {
			for (int i = 0; i < this.getLength(); i++) {
				Enemy aux = this.list.getValue(i);
				g.drawImage(aux.getImage() , aux.getRadialPosX(), aux.getRadialPosY(), aux.getSizeX(), aux.getSizeY(), null);
			}	
		}	
	}
	@Override
	public void update(int level) {//Actualiza el movimiento
		if (!BossInserting && !this.isEliminating()) {
			int value = 50;
			if (this.getLength()!=0) {
				if (getCont()==value){
					this.CircularMovement();
					angle++;
					
					
					for (int i = 0; i < this.getLength(); i++) {
						Enemy aux = this.list.getValue(i);
						aux.sumPosX(this.getDirec(),level);
					}
					if(list.getValue(0).getPosX() <= getMinX()){//Cambiar de acuerdo a velocidad
						this.setDirec(1);
						this.setPosY(this.getPosY() + 10*level);
					}
					if(list.getValue(this.getLength()-1).getPosX()+53 >= getMaxX()) {
						this.setDirec(-1);
						this.setPosY(this.getPosY() + 10*level);
					}
					setCont(0);
				}
				setCont(getCont() + 1);
			}
			else {
				this.setEmpty(true);
			}
		}		
	}
	public void CircularMovement() {
		double angleRad = Math.toRadians(angle);
		for (int i=0; i< this.getLength(); i++) {
			int radius = this.getList().getValue(this.getLength()/2).getPosX() - this.getList().getValue(i).getPosX();
			Enemy aux = this.list.getValue(i);
				aux.setRadialPosX(radius, angleRad);
				aux.setRadialPosY(radius, angleRad);
			
		}
	}
	public void setY(){
		for (int i=0; i< this.getLength(); i++) {
			Enemy aux = this.list.getValue(i);
			aux.setPosY(this.getPosY());
			
		}
	}	
	@Override
	public void setx(){
		for (int i = 0; i < this.getLength(); i++) {
			this.setXconstant(list.getValue(0).getPosX()); 
			int PosX = getXconstant() + 53*i;
			Enemy aux = list.getValue(i);
			aux.setPosX(PosX);
		}
		setCollision(false);
	}
	@Override
	public void collision(int bulletx, int bullety) {
		if(bullety == this.getPosY() && this.getLength() != 0){//Evaluamos si la bala está en el eje 7 de la hilera y si la lista no es vacia
			for (int i = 0; i < this.getLength(); i++) {//Creamos una variable que recorra la lista
				Enemy aux = list.getValue(i);//Obtenemos cada enemigo dentro de la lista
				if(aux.getPosX() <= bulletx && bulletx <= (aux.getPosX()+aux.getSizeX())) {//Evaluamos que la bala esté en su margen en X
					if (aux.getResistance() == 0) {//Si su resistencia es 0, entonces:
						this.list.delete(aux);
						this.setLength(this.getLength()-1);
						setCollision(true);
						this.setx();
						if (i == BossPoss) {
							if (this.getLength()!=0) {								
								this.insertBoss(level);
							}	
						}else if(i < BossPoss){
							BossPoss--;
						}
					}else {
						aux.minusRes(1);
					}
				}
			}
			
		}
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
}
