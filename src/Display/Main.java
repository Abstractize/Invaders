package Display;

import javax.swing.JFrame;

class Main {
	public static void main(String[] args) {
		 int WIDTH = 1366;
		 int HEIGTH = 768;
		 //Creación de la Ventana
		 JFrame obj = new JFrame();
		 Display gamePlay = new Display(WIDTH,HEIGTH);
		 obj.setBounds(0,0,WIDTH,HEIGTH);//Largo y ancho (?
		 obj.setTitle("Taco Invaders");//Titulo
		 obj.setResizable(false);//
		 obj.setVisible(true);//Visibilidad
		 obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Forma de Cerrar la ventana
		 obj.add(gamePlay);
	}
}
