package ADT;

import singleEnemys.Enemy;

public class DoubleCircularList {
	//Atributos
		private DoubleNode head;
		private DoubleNode tail;
		private int length;
		
		
		//Validador de Lista Vacia
		public boolean empty(){
			return head == null;
		}
			
		//Getters y Setters
		public DoubleNode getHead(){
			return head;
		}
		public void setHead(DoubleNode head) {
			this.head = head;
		}
		public DoubleNode getTail() {
			return tail;
		}

		public void setTail(DoubleNode tail) {
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
			DoubleNode New = new DoubleNode();
			New.setValue(value);
			if (empty()){
				tail = New;
				head = New;
				New.setNext(head);
				New.setPrev(tail);
			}else{
				tail.setNext(New);
				New.setNext(head);
				New.setPrev(tail);
				tail = New;
			}
		length++;
		}
		public boolean search(Enemy reference){
			DoubleNode aux = head;
			boolean flag=false;
			do {
				if (reference == aux.getValue()) {
					flag = true;
				}else {
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
					}else{
						head = head.getNext();
					}
					
				}
				else{
					DoubleNode aux = head;
					while(aux.getNext().getValue() != reference){
						aux = aux.getNext();
					}
					DoubleNode next = aux.getNext().getNext();
					aux.setNext(next);
					if (next != null) {
						next.setPrev(aux);
					}
				}
				length--;
			}
		}

			public void erase(){//Elimina la lista
				head = null;
				tail = null;
				length = 0;
			}
			
			public int position(Enemy reference) {
				int cont = 0;
				if (search(reference)) {
					DoubleNode aux = head;
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
						DoubleNode aux = head;
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
						DoubleNode aux = head;
						for (int i = 0; i < pos; i++) {
							aux = aux.getNext();
						}
						aux.setValue(reference);
					}
				}
			}	
}
