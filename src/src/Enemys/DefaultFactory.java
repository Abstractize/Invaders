package Enemys;

public class DefaultFactory implements Factory{

	@Override
	public SingleRow createSingleRow(int Width,int level) {
		// TODO Auto-generated method stub
		return new Basic(Width, level);
	}
	@Override
	public ClassB createOther(int Width, int level) {
		// TODO Auto-generated method stub
		return new ClassB(Width, level);
	}

	@Override
	public CircularRow createCircularRow(int Width, int level) {
		// TODO Auto-generated method stub
		return new ClassC(Width, level);
	}
}
