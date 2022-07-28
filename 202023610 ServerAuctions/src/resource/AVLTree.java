package resource;

import java.util.ArrayList;
import java.util.Comparator;

public class AVLTree<T> {
	private Node<T> root;
	private Comparator comparator;
	
	
	
	public AVLTree(Comparator comparator) {
		super();
		this.comparator = comparator;
	}
	
	public int obtainFe(Node node) {
		if(node == null) {
			return -1;
		}else {
			return node.getFe();
		}
	}
	
	public Node leftRotation(Node node) {
		Node aux=node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node.setFe(Math.max(obtainFe(node.getLeft()), obtainFe(node.getRight()))+1);
		aux.setFe(Math.max(obtainFe(aux.getLeft()), obtainFe(aux.getRight()))+1);
		return aux;
	}
	
	public Node rightRotation(Node node) {
		Node aux= node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node.setFe(Math.max(obtainFe(node.getRight()), obtainFe(node.getLeft()))+1);
		aux.setFe(Math.max(obtainFe(aux.getRight()), obtainFe(aux.getLeft()))+1);
		return aux;
		
	}
	
	public Node leftDoubleRotation(Node node) {
		Node aux;
		node.setLeft(rightRotation(node.getLeft()));
		aux = leftRotation(node);
		return aux;
	}
	
	public Node rightDoubleRotation(Node node) {
		Node aux;
		node.setRight(leftRotation(node.getRight()));
		aux = rightRotation(node);
		return aux;
	}
	
	public Node insert(Node newNode, Node subTree) {
		Node newDad = subTree;
		if(comparator.compare(newNode.getData(),subTree.getData()) < 0) {
			if(subTree.getLeft()==null) {
				subTree.setLeft(newNode);
			}else {
				subTree.setLeft(insert(newNode,subTree.getLeft()));
				if((obtainFe(subTree.getLeft())-obtainFe(subTree.getRight())==2)) {
					if (comparator.compare(newNode.getData(),subTree.getLeft().getData()) < 0) {
						newDad = leftRotation(subTree);
					}else {
						newDad = leftDoubleRotation(subTree);
					}
				}
			}
		}else if(comparator.compare(newNode.getData(),subTree.getData()) > 0) {
			if(subTree.getRight()==null) {
				subTree.setRight(newNode);
			}else {
				subTree.setRight(insert(newNode,subTree.getRight()));
				if((obtainFe(subTree.getRight())-obtainFe(subTree.getLeft())==2)) {
					if(comparator.compare(newNode.getData(),subTree.getRight().getData()) > 0) {
						newDad = rightRotation(subTree);
					}else {
						newDad = rightDoubleRotation(subTree);
					}
				}
			}
		}
		if((subTree.getLeft()==null)&&(subTree.getRight() != null)) {
			subTree.setFe(subTree.getRight().getFe()+1);
		}else if((subTree.getRight()==null)&&(subTree.getLeft()!=null)) {
			subTree.setFe(subTree.getLeft().getFe()+1);
		}else {
			subTree.setFe(Math.max(obtainFe(subTree.getLeft()),obtainFe(subTree.getRight()))+1); 
		}
		return newDad;
	}
	
	public void insert(T data) {
		Node newNode = new Node(data);
		if(root==null) {
			root=newNode;
		}else {
			root = insert(newNode,root);
		}
	}
	
	public void detele(T data) {
		root = deteleAVL(root, data);
	}
	
	private Node deteleAVL(Node node,T data) {
		if (node == null) {
			return null;
		}
		
		if(comparator.compare(node.getData(),data) > 0) {
			node.setLeft(deteleAVL(node.getLeft(),data));
		}else if(comparator.compare(node.getData(),data) < 0) {
			node.setRight(deteleAVL(node.getRight(),data));
		}else {
			if((node.getLeft()==null) || (node.getRight()==null)) {
				Node temp = null;
				if(temp == node.getLeft()) {
					temp = node.getRight();
				}else {
					temp = node.getLeft();
				}
				
				if(temp == null) {
					node = null;
				}else {
					node = temp;
				}
			}else {
				Node temp = findMax(node.getLeft());
				
				node.setData(temp.getData());
				
				node.setLeft(deteleAVL(node.getLeft(),(T) temp.getData()));
			}
		}
		
		if(node == null) {
			return node;
		}
		
		node.setFe(Math.max(obtainFe(node.getLeft()), obtainFe(node.getRight()))+1);
		
		int fe = obtainFe(node);
		
		if(fe > 1 && obtainFe(node.getLeft()) >= 0) {
			return rightRotation(node);
		}
		
		if(fe < -1 && obtainFe(node.getRight()) <= 0) {
			return leftRotation(node);
		}
		
		if(fe > 1 && obtainFe(node.getLeft()) < 0) {
			node.setLeft(leftRotation(node.getLeft()));
			return rightRotation(node);
		}
		
		if(fe < -1 && obtainFe(node.getRight()) > 0) {
			node.setRight(rightRotation(node.getRight()));
			return leftRotation(node);
		}
		
		return node;
	}
	

	
	public T search(Comparator comparator, T sheet){ //TODO
        return search(comparator,root,sheet);
    }
	
	
	private T search(Comparator comparator,Node<T>node,T data){
		if(node==null) {
			return null;
		}
        if(comparator.compare(node.getData(), data)==0){
            return node.getData();
        }else{
            if(comparator.compare(node.getData(),data) > 0){
                return search(comparator,node.getLeft(),data);
            }else if(comparator.compare(node.getData(),data) < 0){
                return search(comparator,node.getRight(),data);
            }
        }
        return null;
    }
	
	public ArrayList<T> showPreorder() {
		ArrayList<T> sheet = new ArrayList<T>();
		
		if(isEmply()) {
			return sheet;
		}
		sheet.add(root.getData());
		
		if(root.getLeft()!=null){
			showPreorder(root.getLeft(), sheet);
        }
		if(root.getRight()!=null){
        	showPreorder(root.getRight(), sheet);
        }
		
		return sheet;
	}
	
	private void showPreorder(Node<T> node, ArrayList<T> sheet) {
		ArrayList<T> sheet1 = sheet;
		sheet1.add(node.getData());
		if(node.getLeft()!= null){
			showPreorder(node.getLeft(), sheet1);
		}
		if(node.getRight()!= null){
        	showPreorder(node.getRight(), sheet1);
        }
	}
	
	public ArrayList<T> showInorder() {
		ArrayList<T> sheet = new ArrayList<T>();
		if(isEmply()) {
			return sheet;
		}
		
		if(root.getLeft()!=null){
			showInorder(root.getLeft(), sheet);
        }
		
		sheet.add(root.getData());
		
		if(root.getRight()!=null){
			showInorder(root.getRight(), sheet);
        }
		
		return sheet;
	}
	
	private void showInorder(Node<T> node, ArrayList<T> sheet) {
		ArrayList<T> sheet1 = sheet;
		
		if(node.getLeft()!= null){
			showInorder(node.getLeft(), sheet1);
		}
		
		sheet1.add(node.getData());
		
		if(node.getRight()!= null){
			showInorder(node.getRight(), sheet1);
        }
	}
	
	public ArrayList<T> showPostorder() {
		ArrayList<T> sheet = new ArrayList<T>();
		
		
		if(root.getLeft()!=null){
			showPostorder(root.getLeft(), sheet);
        }
		if(root.getRight()!=null){
			showPostorder(root.getRight(), sheet);
        }
		
		sheet.add(root.getData());
		
		return sheet;
	}
	
	private void showPostorder(Node<T> node, ArrayList<T> sheet) {
		ArrayList<T> sheet1 = sheet;
		
		if(node.getLeft()!= null){
			showPostorder(node.getLeft(), sheet1);
		}
		
		if(node.getRight()!= null){
			showPostorder(node.getRight(), sheet1);
        }
		
		sheet1.add(node.getData());
	}
	
	
	
	public Node findMax(Node node) {
		if(node  == null) {
			return null;
		}
		
		Node work = node;
		
		while(work.getRight() != null) {
			work = work.getRight();
		}
		
		return work;
	}
	
	public void detele1(T d) throws Exception{
        root=detele(root,d);
	}

	protected Node detele(Node n, T d) throws Exception{
		if (n==null)
			throw new Exception("Nodo no encontrado");
		else
			if (comparator.compare(n.getData(),d)< 0){
				Node der = detele(n.getRight(),d);
				n.setRight(der);
			}
			else
				if (comparator.compare(n.getData(),d)> 0){
					Node izq=detele(n.getLeft(),d);
					n.setLeft(izq);
				}
				else{
					Node q = n;
					if (q.getLeft()==null)
						n=q.getRight();
					else
						if (q.getRight()==null)
                    n=q.getLeft();
                else
                    q=replace(q);
					q=null;
				}

		return n;
	}
	
	


	private Node replace(Node act){
		Node a,p;
		p=act;
		a=act.getLeft();
		while (a.getRight()!=null){
			p=a;
			a= a.getRight();
		}
		act.setData(a.getData());
		if (p==act)
			p.setLeft(a.getLeft());
		else
			p.setRight(a.getLeft());
		return a;
	}
	
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	private boolean isEmply() {
		return root==null;
	}
	
	
	
}
