package Enemys;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import ADT.DoubleList;
import Display.Display;
import game.Bullets;
import singleEnemys.Enemy;
import singleEnemys.TypeA;
import singleEnemys.TypeB;

public class ClassB extends row{
	private DoubleList list;
	private int BossPoss;
	private int swap=0;
	private boolean swapping;

	public ClassB(int Width, int level) {
		super(Width, level);
		swapping = false;
		list = new DoubleList();
		this.insert();
		this.setName("Class B");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\ClassB.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		this.insertBoss(level);
		// TODO Auto-generated constructor stub
	}
	public DoubleList getList(){
		return this.list;
	}
	public void setList(DoubleList l) {
		this.list=l;
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
	public void update(int level) {
		if (!swapping && !this.isEliminating()) {
			int value = 50;
			if (!this.list.empty()) {
				this.swap();
				if (getCont()==value){
					for (int i = 0; i < this.getLength(); i++) {
						Enemy aux = this.list.getValue(i);
						aux.sumPosX(this.getDirec(),level);
					}
					if(list.getValue(0).getPosX() < getMinX()){//Cambiar de acuerdo a velocidad
						this.setDirec(1);
						this.setPosY(this.getPosY() + 10*level);
					}
					if(list.getValue(this.getLength()-1).getPosX()+53 > getMaxX()) {
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
	public void swap() {
		if (this.getLength() > 1){
			swapping = true;
			if (5000 == swap) {
				int random = (int) (Math.random() * this.list.getLength());
				this.list.swap(random, BossPoss);
				BossPoss = random;
				swap=0;
			} else {
				swap++;
			}
		}	
		swapping = false;
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
	public void collision(Bullets bullet, Display display) {
		int bullety = bullet.getPosY();
		int bulletx = bullet.getPosX();
		if(bullety == this.getPosY() && this.getLength() != 0){
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
						if (i == BossPoss) {
							display.setScore(display.getScore()+100);
							this.setEmpty(true);
							this.getList().erase();
						}else if(i < BossPoss) {
							BossPoss--;
						}
						this.setEliminating(false);
					}else {
						aux.minusRes(1);
					}
				}
			}
		}
	}
	public void insertBoss(int level) {
		 DoubleList lista = this.getList();
		 int random = (int) ((Math.random() * lista.getLength()));
		 int PosX = lista.getValue(random).getPosX();
		 TypeB Boss = new TypeB(PosX,level);
		 BossPoss=random;
		 lista.swap(Boss, random);
		 this.setList(lista);
		 
	}

}
