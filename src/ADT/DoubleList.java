package ADT;

import singleEnemys.Enemy;

public class DoubleList {
	//Atributos
		private DoubleNode head;
		private int length;
		//Constructor

		//Validador de Lista Vacia
		public boolean empty(){
			return head == null;
		}
		
		//Getters y Setters
		public DoubleNode getHead() {
			return head;
		}

		public void setHead(DoubleNode head) {
			this.head = head;
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
				head = New;
			}
			else{
				DoubleNode aux = head;
				while(aux.getNext() != null){
					aux=aux.getNext();
				}
				aux.setNext(New);
				New.setPrev(aux);
			}
			length++;
		}
		public boolean search(Enemy reference){
			DoubleNode aux = head;
			boolean flag=false;
			while (aux != null && flag != true){
				if (reference == aux.getValue()){
					flag = true;
				}
				else{
					aux = aux.getNext();
				}
			}
		return flag;
		}
		public int position(Enemy reference){
			int pos = 0;
			if (search(reference)){
				if (!(head.getValue() == reference)){
					DoubleNode aux = head;
					while(aux.getValue() != reference){
						aux = aux.getNext();
						pos++;
					}
				}
			}
			return pos++;		
		}
		public void delete(Enemy reference){//Elimina un miembro por referencia
			if (search(reference)){
				if (head.getValue() == reference){
					head = head.getNext();
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
			length = 0;
		}
		public Enemy getValue(int pos) {//Obtener valor por referencia
			if(pos >= 0 && pos < length) {
				if (pos == 0){
					return head.getValue();
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
		public void setValue(int pos,Enemy reference) {//Obtener valor por referencia
			if(pos >= 0 && pos < length) {
				if (pos == 0){
					head.setValue(reference);
				}else {
					DoubleNode aux = head;
					for (int i = 0; i < pos; i++) {
						aux = aux.getNext();
					}
					aux.setValue(reference);
				}
			}
			
		}
		public void swap(Enemy reference,int pos) {
			if(pos >= 0 && pos < length) {
				if (pos == 0){
					head.setValue(reference);
				}else {
					DoubleNode aux = head;
					for (int i = 0; i < pos; i++) {
						aux = aux.getNext();
					}
					aux.setValue(reference);
				}
			}
		}
		public void swap(int pos,int BossPos) {//Cambio con el jefe.
			if(pos != BossPos) {
				Enemy Boss=this.getValue(BossPos);
				Enemy Other=this.getValue(pos);
				int posx = Other.getPosX();
				Other.setPosX(Boss.getPosX());
				Boss.setPosX(posx);
				this.setValue(BossPos, Other);
				this.setValue(pos,Boss);
				
				
			}
				
		}
		
}
