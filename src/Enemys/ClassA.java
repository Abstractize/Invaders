package Enemys;

import javax.swing.ImageIcon;

import ADT.List;
import singleEnemys.*;

public class ClassA extends SingleRow {

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
		 Boss.setListPos(random);
		 lista.swap(Boss, random);
		 this.setList(lista);
		 
	}

}
