package singleEnemys;

import java.awt.Color;

public class TypeB extends Enemy{//Boss

	public TypeB(int x, int level) {
		super(x, level);
		image=Color.yellow;
		sizeX = 30;
		sizeY = 30;
		resistance = 2 + (level-1);
		// TODO Auto-generated constructor stub
	}
}	