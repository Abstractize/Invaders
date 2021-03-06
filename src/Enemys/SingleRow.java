package Enemys;

import java.awt.Graphics;

import ADT.List;
import Display.Display;
import game.Bullets;
import singleEnemys.Enemy;
import singleEnemys.TypeA;

public abstract class SingleRow extends row {
	private List list;
	
	public SingleRow(int Width, int level) {
		super(Width, level);
		list = new List();
		this.insert();
		// TODO Auto-generated constructor stub
	}
	//getters y setters
		public List getList(){
			return list;
		}
		public void setList(List l) {
			this.list=l;
	}
	//Metodos que usan las listas
	@Override
	public void insert() {
		for (int i = 0; i < this.getLength(); i++) {
			int PosX = this.getXconstant() + 53*i;
			Enemy aux = new TypeA(PosX,getLevel()) ;
			this.list.add(aux);
		}
	}
	@Override
	public void draw(Graphics g) {
		if (!this.list.empty()) {
			for (int i = 0; i < this.getLength(); i++) {
				Enemy aux = this.list.getValue(i);
				g.drawImage(aux.getImage() , aux.getPosX(), getPosY(), aux.getSizeX(), aux.getSizeY(), null);
			}	
		}
	}
	@Override
	public void update(int level) {//Funci�n que da movimiento a las hileras
		if (!this.isEliminating()) {
			if (!this.list.empty()) {
					for (int i = 0; i < this.getLength(); i++) {//Movimiento en X
						Enemy aux = this.list.getValue(i);
						aux.sumPosX(this.getDirec(),level);
					}
					//Movimiento en Y
					if(list.getValue(0).getPosX() < getMinX()){//Cambiar de acuerdo a velocidad
						this.setDirec(1);
						this.setPosY(this.getPosY() + 10);
					}
					if(list.getValue(this.getLength()-1).getPosX()+50 > getMaxX()) {
						this.setDirec(-1);
						this.setPosY(this.getPosY() + 10);
					}
			}
			else {
				this.setEmpty(true);
			}
		}
	}
	@Override
	public void setx(){
		for (int i = 0; i < this.getLength(); i++) {
			this.setXconstant(list.getValue(0).getPosX()); 
			int PosX = getXconstant() + 53*i;
			Enemy aux = list.getValue(i);
			aux.setPosX(PosX);
		}
	}
	@Override
	public void collision(Bullets bullet, Display display) {
		int bullety = bullet.getPosY();
		int bulletx = bullet.getPosX();
		if(bullety > this.getPosY() && this.getPosY()+50 > bullety &&this.getLength() != 0){
			for (int i = 0; i < this.getLength(); i++) {
				Enemy aux = list.getValue(i);
				if(aux.getPosX() <= bulletx && bulletx <= (aux.getPosX()+35)) {
					bullet.setShoot(false);
					if (aux.getResistance() == 0) {
						display.setScore(display.getScore()+100);
						this.setEliminating(true);
						this.list.delete(aux);
						this.setLength(this.getLength()-1);
						this.setx();
						this.setEliminating(false);
					}else {
						aux.minusRes(1);
					}
				}
			}
		}
	}
}