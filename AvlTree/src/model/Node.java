package model;

public class Node <T> {
	private T data;
	private int fe;
	private Node<T> left;
	private Node<T> right;
	
	
	public Node(T data) {
		super();
		this.data = data;
		this.fe = 0;
	}
	
	public T getData() {
		return data;
	}
	public Node<T> getLeft() {
		return left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public void setRight(Node<T> rigth) {
		this.right = rigth;
	}
	
	

	public int getFe() {
		return fe;
	}

	public void setFe(int fe) {
		this.fe = fe;
	}

	@Override
	public String toString() {
		return "Node [data=" + data;// + "\n, left=" + left + ", right=" + right + "]";
	}
	
	
}