package Enemys;

import javax.swing.ImageIcon;

public class ClassD extends SingleRow{

	public ClassD(int Width, int level) {
		super(Width, level);
		this.setName("Class D");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\ClassD.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		// TODO Auto-generated constructor stub
	}

}
