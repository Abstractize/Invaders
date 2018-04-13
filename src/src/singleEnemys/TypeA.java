package singleEnemys;

import javax.swing.ImageIcon;

public class TypeA extends Enemy {

	public TypeA(int x, int level) {
		super(x, level);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int setHabitualResistance(int level) {
		int res;
		if (level<=3) {//incrementa de acuerdo al nivel	
			res = level-1;
		}else {//La mayor resistencia será 3 disparos
			res = 2;
		}
		return res;
	}
	@Override
	public void setImages(){
		if (this.getResistance() == 2) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\wall.jpg"));
		}else if (this.getResistance() == 1) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\wall2.jpg"));
		}else if (this.getResistance() == 0) {
			this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\wall3.jpg"));
		}
	}
}
