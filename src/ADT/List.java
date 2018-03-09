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
	//Validador de Lista Vacia
	public boolean empty(){
		return head == null;
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
	//Métodos
	public void movement(){//Movimiento de las Naves
		
	}
	public void delete(){//Eliminar un miembro de la hilera
		
	}
	public void add(){//Agregar un miembro a la hilera
		
	}
	
}
