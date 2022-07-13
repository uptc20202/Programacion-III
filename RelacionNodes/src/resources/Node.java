package resources;

public class Node <T>{

	private T data;
	private Node<T> next;
	private Node<T> back;//Nuevo nodo
	
	public Node<T> getBack() {
		return back;
	}

	public void setBack(Node<T> back) {
		this.back = back;
	}

	public Node(T data) {
		this.data = data;	
	}
	
	public T getValue(){
		return data;
	}
	
	@Override
	public String toString() {
		return " [data=" + data + "]";
	}

	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}