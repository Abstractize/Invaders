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
					if (tail.getValue()== reference) {
						head = null;
						tail = null;
					}else {
						head = head.getNext();
					}	
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
				}else if(pos == (length-1)){
					return tail.getValue();
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
				}else if(pos == (length-1)){
					tail.setValue(reference);
				}else {
					Nodo aux = head;
					for (int i = 0; i < pos; i++) {
						aux = aux.getNext();
					}
					aux.setValue(reference);
				}
			}
		}
		
		public int BubbleSort(int pos) {//Ordenar enemigos por resistencia
			boolean sorted = false;
			while (!sorted){//mientras no está acomodado
				sorted=true;
				for(int index = 0 ; index < length-1; index++){
					if (this.getValue(index).getResistance() > this.getValue(index+1).getResistance()) {
						sorted = false;//no está acomodado
						//Cambios
						Enemy hold;
						hold = this.getValue(index+1);
						this.swap(this.getValue(index), index+1);
						this.swap(hold, index);
						if (index == pos) {//Si el jefe es la posición, se mueve 1 espacio
							pos++;
						}else if(index+1== pos) {//Si el jefe está después de la posición se mueve 1 espacio
							pos--;
						}
					}
				}
			}
			return (pos);
		}
}
