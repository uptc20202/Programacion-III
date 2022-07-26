package resource;

import java.util.Iterator;

public class Queve<T> implements Iterable<T>{
	private Node<T> front;
	
	public void push(T data) {
		if(front == null){
			front = new Node<T>(data);
		}else{
			Node<T> aux = front;
			while(aux.getRight() != null) {
				aux = aux.getRight();
				
			}
			aux.setRight(new Node<T>(data));
			aux.getRight().setLeft(aux);
		}
	}
	
	public T poll() {
		Node<T> aux = front;
		front = aux.getRight();
		return aux.getData();
	}
	
	public T peek() {
		return front.getData();
	}
	
	public boolean isEmply() {
		return (front==null);
	}
	
	public boolean exist(T data) {
		Node<T> aux = front;
		while(aux.getRight()!=null) {
			if(aux.getData() == data) {
				return true;
			}
			aux = aux.getRight();
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
				T data = actual.getData();
				actual = actual.getRight();
				return data;
			}
			
		};
		return myIterator;
	}
}
