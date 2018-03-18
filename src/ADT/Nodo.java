package ADT;

import singleEnemys.Enemy;

public class Nodo {
	private Enemy value;
	private Nodo next;
	
	public Nodo(){
		this.setValue(null);
		this.setNext(null);
	}

	public Enemy getValue() {
		return value;
	}

	public void setValue(Enemy value) {
		this.value = value;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
