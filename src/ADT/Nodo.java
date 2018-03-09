package ADT;

public class Nodo {
	private int value;
	private Nodo next;
	
	public Nodo(){
		this.setValue(0);
		this.setNext(null);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
}
