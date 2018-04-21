package Enemys;

import java.awt.Graphics;

import ADT.CircularList;
import Display.Display;
import game.Bullets;
import singleEnemys.Enemy;
import singleEnemys.TypeA;
import singleEnemys.TypeB;

public class CircularRow extends row{
	private CircularList list;
	private int BossPoss;
	private int level;
	public CircularRow(int Width, int level) {
		super(Width, level);
		this.level = level;
		list = new CircularList();
		this.insert();
		this.insertBoss(level);
		// TODO Auto-generated constructor stub
	}	
	//Getters y Setters
	public CircularList getList() {
		return list;
	}
	public void setList(CircularList list) {
		this.list = list;
	}
	public int getBoss() {
		return BossPoss;
	}
	public void setBoss(int boss) {
		BossPoss = boss;
	}
	public void insertBoss(int level) {
		CircularList lista = this.getList();
		int random = (int) ((Math.random() * lista.getLength()));
		int PosX = lista.getValue(random).getPosX();
		BossPoss=random;
		TypeB Boss = new TypeB(PosX,level);
		lista.swap(Boss, random);
		this.setList(lista);
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
				g.drawImage(aux.getImage() , aux.getPosX(), getPosY(), aux.getSizeX(), aux.getSizeY(), null);
			}	
		}	
	}
	@Override
	public void update(int level) {//Actualiza el movimiento
		if (!this.isEliminating()) {
			if (this.getLength()!=0) {
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
			}
			else {
				this.setEmpty(true);
			}
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
	}
	@Override
	public void collision(Bullets bullet,Display display) {
		int bullety = bullet.getPosY();
		int bulletx = bullet.getPosX();
		if (this.getLength()!= 0){
			if(bullety > this.getPosY() && this.getPosY()+50 > bullety){
				for (int i = 0; i < this.getLength(); i++) {
					Enemy aux = this.getList().getValue(i);
					if(aux.getPosX() <= bulletx && bulletx <= (aux.getPosX()+aux.getSizeX())) {
						bullet.setShoot(false);
						if (aux.getResistance() == 0) {
							display.setScore(display.getScore()+100);
							this.setEliminating(true);
							this.getList().delete(aux);
							this.setLength(this.getLength()-1);
							this.setx();
							if (this.getLength()!=0) {
								if (i == BossPoss) {
									display.setScore(display.getScore()+100);
									this.insertBoss(level);
								}else if(i < BossPoss) {
									BossPoss--;
								}
							}else {
								this.setEmpty(true);
							}
							this.setEliminating(false);
						}else {
							aux.minusRes(1);
						}
					}
				}
			}	
		}	
	}
}
