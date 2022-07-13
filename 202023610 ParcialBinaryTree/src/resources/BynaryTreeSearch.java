package resources;

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
            if(comparator.compare(node.getData(),data) > 0){
                node.setLeft(insert(node.getLeft(),data) );
            }else if(comparator.compare(node.getData(),data) < 0){
                node.setRight(insert(node.getRight(),data));
            }
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
	
	
	public void detele(T d) throws Exception{
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
