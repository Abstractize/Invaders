package Display;

import javax.swing.ImageIcon;

public interface BackGroundFactory {
	public static ImageIcon create(int width, int level) {
		int random = (int) ((Math.random() * 5) + 1);
		ImageIcon bg= null;
		if (random == 1) {
			bg = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\bg.jpg");
		}else if(random == 2) {
			bg = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\bg2.jpg");
		}else if(random == 3) {
			bg = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\bg3.jpg");
		}else if (random == 4) {
			bg = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\bg4.jpg");
		}else if (random == 5) {
			bg = new ImageIcon("D:\\Users\\Gabo\\Escritorio\\Proyectos\\Invaders\\src\\images\\bg5.jpg");
		}
		return bg;


		
	}

}
