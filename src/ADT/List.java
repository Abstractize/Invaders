package ADT;

public class List {
	//Atributos
	private Nodo head;
	private int length;
	//Constructor
	public List(){
		setHead(null);
		setLength(0);
	}
	//Getters y Setters
	public Nodo getHead() {
		return head;
	}

	public void setHead(Nodo head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	//M�todos
}
