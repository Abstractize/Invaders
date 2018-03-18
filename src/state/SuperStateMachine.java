package state;

import java.awt.Canvas;
import java.awt.Graphics2D;

public abstract class SuperStateMachine {

	public abstract void update(double delta);
	public abstract void draw(Graphics2D g);
	public abstract void init(Canvas canvas);
	

}