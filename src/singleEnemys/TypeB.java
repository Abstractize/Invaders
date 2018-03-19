package singleEnemys;

import java.awt.Color;
import java.awt.Graphics;

public class TypeB extends Enemy{//Boss

	public TypeB(int x, int y, int level) {
		super(x, y, level);
		sizeX = 30;
		sizeY = 30;
		resistance = 2 + (level-1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
	}

}
