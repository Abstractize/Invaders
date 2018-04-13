package Enemys;

public class ModifiedFactory implements Factory{
	@Override
	public SingleRow createSingleRow(int Width,int level) {
		// TODO Auto-generated method stub
		return new ClassA(Width, level);
	}
	@Override
	public row createOther(int Width, int level) {
		// TODO Auto-generated method stub
		return new ClassE(Width, level);
	}

	@Override
	public CircularRow createCircularRow(int Width, int level) {
		// TODO Auto-generated method stub
		return new ClassD(Width, level);
	}
}
