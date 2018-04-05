package singleEnemys;

import javax.swing.ImageIcon;

public class TypeA extends Enemy {

	public TypeA(int x, int level) {
		super(x, level);
		setIcon(new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\wall.jpg"));
		image = getIcon().getImage();
		// TODO Auto-generated constructor stub
	}

}
