package resources;

import java.util.Iterator;

public class Queve<T> implements Iterable<T>{
	private Node<T> front;
	
	public void push(T data) {
		if(front == null){
			front = new Node<T>(data);
		}else{
			Node<T> aux = front;
			while(aux.getNext() != null) {
				aux = aux.getNext();
				
			}
			aux.setNext(new Node<T>(data));
			aux.getNext().setBack(aux);
		}
	}
	
	public T poll() {
		Node<T> aux = front;
		front = aux.getNext();
		return aux.getValue();
	}
	
	public T peek() {
		return front.getValue();
	}
	
	public boolean isEmply() {
		return (front==null);
	}
	
	public boolean exist(T data) {
		Node<T> aux = front;
		while(aux.getNext()!=null) {
			if(aux.getValue() == data) {
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> myIterator = new Iterator<T>() {
			Node<T> actual = front;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return actual != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				T data = actual.getValue();
				actual = actual.getNext();
				return data;
			}
			
		};
		return myIterator;
	}
}
