package Enemys;


public class Factory {
	int random;
	row enemy;
	public Factory(int width, int level) {
		// TODO Auto-generated constructor stub
	}
	public row create(int width, int level) {
		random = (int) ((Math.random() * 5) + 1);
		System.out.println(random);
		if (random == 1) {
			enemy = new Basic(width,level);
		}else if(random == 2) {
			enemy = new ClassA(width, level);
		}else if(random == 3) {
			enemy = new ClassB(width,level);
		}else if (random == 4) {
			enemy = new ClassC(width,level);
		}else if (random == 5) {
			enemy = new ClassD(width,level);
		}else if (random == 6) {
			enemy = new ClassE(width,level);
		}
		return enemy;


		
	}

}
