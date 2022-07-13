package model;

public class BynaryTree<T> {
	private Node<T> root;
	
	public BynaryTree() {
		
	}
	
	public BynaryTree(Node<T> root,Node<T> left,Node<T> rigth) {
		this.root = root;
		root.setLeft(left);
		root.setRight(rigth);
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	private boolean isEmply() {
		return false;
	}
	
	public Node<T> getLeft() {
		return null;
	}
	public Node<T> getRigth() {
		return null;
	}
}
