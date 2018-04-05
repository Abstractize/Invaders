package singleEnemys;

import javax.swing.ImageIcon;

public class TypeB extends Enemy{//Boss
	private int ListPos;
	public TypeB(int x, int level) {
		super(x, level);
		resistance = 2 + (level-1);
		this.setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\wall2.jpg"));
		image = this.getIcon().getImage();
		// TODO Auto-generated constructor stub
	}
	public int getListPos() {
		return ListPos;
	}
	public void setListPos(int listPos) {
		ListPos = listPos;
	}
}	