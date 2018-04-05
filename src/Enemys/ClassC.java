package Enemys;

import javax.swing.ImageIcon;

public class ClassC extends SingleRow{

	public ClassC(int Width, int level) {
		super(Width, level);
		this.setName("Class C");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\Invaders-master\\src\\images\\ClassC.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		// TODO Auto-generated constructor stub
	}

}
