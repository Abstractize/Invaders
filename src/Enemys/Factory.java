package Enemys;

//Abstract Factory
public interface Factory {
	public static row create(int width, int level) {
		//int random = (int) ((Math.random() * 6) + 1);
		int random = 4;
		row enemy= null;
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
