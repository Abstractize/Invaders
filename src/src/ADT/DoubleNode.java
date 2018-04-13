package ADT;

import singleEnemys.Enemy;

public class DoubleNode {
	private Enemy value;
	private DoubleNode next;
	private DoubleNode prev;
	
	public DoubleNode(){
		this.setValue(null);
		this.setNext(null);
		this.setPrev(null);
	}

	public Enemy getValue() {
		return value;
	}

	public void setValue(Enemy value) {
		this.value = value;
	}

	public DoubleNode getNext() {
		return next;
	}

	public void setNext(DoubleNode next) {
		this.next = next;
	}

	public DoubleNode getPrev() {
		return prev;
	}

	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
}
