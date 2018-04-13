package game;

public class Nodo {
	private Bullets value;
	private Nodo next;
	
	public Nodo(){
		this.setValue(null);
		this.setNext(null);
	}

	public Bullets getValue() {
		return value;
	}

	public void setValue(Bullets value) {
		this.value = value;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
