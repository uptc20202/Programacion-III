package resources;

import java.util.Comparator;

public class SimpleList<T> {

	private Node<T> head;
	private Comparator<T> comparator;
	
	public SimpleList(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		this.comparator = comparator;
		
	}

	public void insert(T data) {
		if(head == null){
			head = new Node<T>(data);
		}else{
			Node<T> aux = head;
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(new Node<T>(data));
		}
	}
	
	public boolean exist(Node<T> data) {
		Node<T> aux = head;
		while(aux.getNext() != null) {
			if(comparator.compare(aux.getValue(), data.getValue())==0) {
				return true;
			}
			aux = aux.getNext();
		}
		if(aux.equals(data)) {
			return true;
		}
		return false;
	}
	
	public void remove(T data) {
		if(head.getValue()!=data) {
			Node aux = head;
			Node aux2 = head.getNext();
			
			while(aux2 != null) {
				if(aux2.getValue()==data&&aux2.getNext() != null) {
					aux.setNext(aux2.getNext()); 
				}
				aux = aux.getNext();
				aux2 = aux2.getNext();
			}
			
		}else {
			head = head.getNext();
		}
	}
	
	public void removeCompañeroMiguel(int data) {
		boolean status = true;
		if(head != null) {
			
		}

	
	}
	
	
	public boolean isEmply() {
		return head==null;
	}
	
	public String show() {
		Node aux = head;
		String data= String.valueOf(aux.getValue());
		
		while(aux.getNext() != null) {
			aux = aux.getNext();
			data = data+" "+aux.getValue();
		}
		return data;
	}
}
