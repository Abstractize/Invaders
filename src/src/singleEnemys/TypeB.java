package singleEnemys;

import javax.swing.ImageIcon;

public class TypeB extends Enemy{//Boss
	public TypeB(int x, int level) {
		super(x, level);
		this.setResistanceInit(this.getResistance());
		// TODO Auto-generated constructor stub
	}
	@Override
	public int setHabitualResistance(int level) {
		int res;
		if (level<=3) {//incrementa de acuerdo al nivel	
			res = level;
		}else {//La mayor resistencia será 5 disparos
			res = 4;
		}
		return res;
	}
	@Override
	public void setImages(){
		if (this.getResistance() == this.getResistanceInit()) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\Hamburger.png"));
		}else if (this.getResistance() == 3) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\Hamburger2.png"));
		}else if (this.getResistance() == 2) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\Hamburger3.png"));
		}else if (this.getResistance() == 1) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\Hamburger4.png"));
		}else if (this.getResistance() == 0) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\Hamburger5.png"));
		}
	}
}	