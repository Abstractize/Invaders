package Enemys;

import javax.swing.ImageIcon;

import ADT.CircularList;
import singleEnemys.Enemy;
import singleEnemys.TypeB;

public class ClassD extends CircularRow{

	public ClassD(int Width, int level) {
		super(Width, level);
		this.setName("Class D");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\ClassD.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insertBoss(int level) {
		CircularList lista = this.getList();
		int random = (int) ((Math.random() * lista.getLength()));
		int PosX = lista.getValue(random).getPosX();
		this.setBoss(random);
		TypeB Boss = new TypeB(PosX,level);
		lista.swap(Boss, random);
		this.setList(lista);
		this.resistence();
	}
	public void resistence() {
		for (int i = 0; i< this.getList().getLength(); i++ ){
			int random;
			if (i != this.getBoss()) {
				random = (int) (Math.random() * 3);
			}else {
				random = (int) (Math.random() * 5);
			}
				Enemy aux = this.getList().getValue(i);
				aux.setResistance(random);
				aux.setResistanceInit(random);
				aux.setImages();
				aux.setImage(aux.getIcon().getImage());
				this.getList().swap(aux, i);
		}
	this.setBoss(this.getList().BubbleSort(this.getBoss()));
	this.setx();
	}
}
