package Enemys;

import javax.swing.ImageIcon;

import singleEnemys.Enemy;

public class ClassD extends CircularRow{

	public ClassD(int Width, int level) {
		super(Width, level);
		this.setName("Class D");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\ClassD.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		this.resistence();
		// TODO Auto-generated constructor stub
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
