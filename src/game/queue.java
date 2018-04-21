package game;

public class queue {
	//Cola de Balas
	private Nodo head=null;
	private int length=0;
	//Verificación de Cola vacía
	public boolean empty(){//Validar que la cola esté vacia
		return head == null;
	}
	//Agregar elemento a la cola
	public void enqueue(Bullets value){//Agregar un miembro a la hilera al final
		Nodo New = new Nodo();
		New.setValue(value);
		if (empty()){
			head = New;
		}
		else{
			Nodo aux = head;
			while(aux.getNext() != null){
				aux=aux.getNext();
			}
			aux.setNext(New);
		}
		length++;
	}
	//Eliminar el primer elemento de la cola
	public void dequeue() {
		head = head.getNext();
		length--;
	}
	//Obtener el primer elemento de la cola
	public Bullets peek() {
		return head.getValue();
	}
	
	
	//Otros
	public Bullets getValue(int pos) {//Obtener valor por referencia
		if(pos >= 0 && pos < length) {
			if (pos == 0){
				return head.getValue();
			}else {
				Nodo aux = head;
				for (int i = 0; i < pos; i++) {
					aux = aux.getNext();
				}
				return aux.getValue();
			}
		}else {
			return null;
		}
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
	

}
