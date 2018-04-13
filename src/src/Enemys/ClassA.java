package Enemys;

import javax.swing.ImageIcon;

import ADT.List;
import Display.Display;
import game.Bullets;
import singleEnemys.*;

public class ClassA extends SingleRow {
	private int BossPoss;
	public ClassA(int Width, int level) {
		super(Width, level);
		this.setName("Class A");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\ClassA.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		this.insertBoss(level);
		// TODO Auto-generated constructor stub
	}
	public void insertBoss(int level) {
		 List lista = this.getList();
		 int random = (int) ((Math.random() * lista.getLength()));
		 int PosX = lista.getValue(random).getPosX();
		 TypeB Boss = new TypeB(PosX,level);
		 lista.swap(Boss, random);
		 BossPoss=random;
		 this.setList(lista); 
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
}
