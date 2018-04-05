package ADT;

import singleEnemys.Enemy;

public class CircularList {
	//Atributos
	private Nodo head;
	private Nodo tail;
	private int length;
	
	
	//Validador de Lista Vacia
	public boolean empty(){
		return head == null;
	}
		
		//Getters y Setters
	public Nodo getHead(){
		return head;
	}
	public void setHead(Nodo head) {
		this.head = head;
	}
	public Nodo getTail() {
		return tail;
	}

	public void setTail(Nodo tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	//Metodos
	public void add(Enemy value){//Agregar un miembro a la hilera al final
		Nodo New = new Nodo();
		New.setValue(value);
		if (empty()){
			tail = New;
			head = New;
			New.setNext(tail);
		}else{
			tail.setNext(New);
			New.setNext(head);
			tail = New;
		}
	length++;
	}
	public boolean search(Enemy reference){
			Nodo aux = head;
			boolean flag=false;
			do {
				if (reference == aux.getValue()) {
					flag = true;
				}
				else {
					aux = aux.getNext();
				}	
			}while(aux != head && flag != true);
		return flag;
		}
		public void delete(Enemy reference){//Elimina un miembro por referencia
			if (search(reference)){
				if (head.getValue() == reference){
					head = head.getNext();
				}
				else{
					Nodo aux = head;
					while(aux.getNext().getValue() != reference){
						aux = aux.getNext();
					}
					Nodo next = aux.getNext().getNext();
					aux.setNext(next);
				}
				length--;
			}
		}

		public void erase(){//Elimina la lista
			head = null;
			length = 0;
		}
		public int position(Enemy reference) {
			int cont = 0;
			if (search(reference)) {
				Nodo aux = head;
				while (reference != aux.getValue()) {
					cont++;
					aux=aux.getNext();
				}
			}
			return cont;
		}
		public Enemy getValue(int pos) {//Obtener valor por referencia
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
		public void swap(Enemy reference,int pos) {
			if(pos >= 0 && pos < length) {
				if (pos == 0){
					head.setValue(reference);
				}else {
					Nodo aux = head;
					for (int i = 0; i < pos; i++) {
						aux = aux.getNext();
					}
					aux.setValue(reference);
				}
			}
		}
		
}
