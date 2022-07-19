package resource;

import java.util.ArrayList;
import java.util.Comparator;

public class BynaryTreeSearch<T> {
	private Node<T> root;
	private Comparator comparator;
	
	
	
	public BynaryTreeSearch(Comparator comparator) {
		super();
		this.comparator = comparator;
	}

	public void insert(T data){ //TODO
        root = insert(root,data);
    }
	
	private Node<T> insert(Node<T>node,T data){
        if(node  == null){
            node = new Node<>(data);
            return  node;
        }else{
            if(comparator.compare(node.getData(),data) < 0){
                node.setLeft(insert(node.getLeft(),data) );
            }else if(comparator.compare(node.getData(),data) > 0){
                node.setRight(insert(node.getRight(),data));
            }
        }
        return node;
    }
	
	public T search(Comparator comparator, T sheet) {
		if(comparator.compare(root.getData(), sheet)==1) {
			return root.getData();
		}
		if(root.getLeft()!=null){
			return searchPreorder( comparator,root.getLeft(),sheet);
        }
		if(root.getRight()!=null){
			return searchPreorder(comparator,root.getRight(),sheet);
        }
		return null;
	}
	
	private T searchPreorder(Comparator comparator,Node<T> node,T sheet) {
		if(comparator.compare(node.getData(), sheet)==1) {
			return node.getData();
		}
		if(node.getLeft()!= null){
			return searchPreorder(comparator,node.getLeft(), sheet);
		}
		if(node.getRight()!= null){
			return searchPreorder(comparator,node.getRight(), sheet);
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
	
	public void detele(T data) throws Exception{
		root = detele(root,data);
	}
	
	private Node<T> detele(Node<T> node, T data) throws Exception {
		if(node == null) {
			throw new Exception("Nodo no encontrado");
		}else {
			if(comparator.compare(node.getData(), data)<0) {
				Node<T> der  = detele(node.getLeft(),data);	
				node.setRight(der);
			}else {
				Node q = node;
				if(q.getLeft()==null) {
					node = q.getLeft();
				}else {
					q = remplace(q);
				}
				q = null;
			}
		}
		return node;
		
	}
	
	private Node<T> remplace(Node<T> node){
		Node a,p;
		p = node;
		a= node.getLeft();
		while(a.getLeft()!=null) {
			p=a;
			a = a.getRight();
		}
		node.setData((T)a.getData());
		if(p==node) {
			p.setLeft(a.getLeft());
		}else {
			p.setRight(a.getLeft());
		}
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
