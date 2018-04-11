package Enemys;

//Abstract Factory
public interface Factory {
	public SingleRow createSingleRow(int Width,int level);
	public row createOther(int Width,int level);
	public CircularRow createCircularRow(int Width,int level);
}
