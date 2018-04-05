package Enemys;

import javax.swing.ImageIcon;

public class Basic extends SingleRow{

	public Basic(int Width, int level) {
		super(Width, level);
		this.setName("Basic");
		ImageIcon icon = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\Invaders-master\\src\\images\\BASIC.png");
		this.setIcon(icon);
		this.setClassimage(icon.getImage());
		// TODO Auto-generated constructor stub
	}
	
}
