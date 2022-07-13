package resources;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
	
	private Node<T> top;
	
	public Stack() {
		super();
	}

	public void push(T data) {
		Node aux = new Node(data);
		aux.setNext(top);
		top = aux;
	}
	
	public T pop() {
		Node<T> aux = top;
		top = aux.getNext();
		return aux.getValue();
	}
	
	public T peek() {
		return top.getValue();
		
	}
	
	public boolean isEmpty() {
		return (top==null);
		
	}
	
	public boolean exist(T data) {
		Node<T> aux = top;
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
			Node<T> actual = top;
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
