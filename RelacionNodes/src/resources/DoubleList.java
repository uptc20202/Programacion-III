package resources;

import java.util.Comparator;
import java.util.Iterator;

public class DoubleList<T> implements Iterable<T> {

	private Node<T> head;
	private Comparator<T> comparator;
	private T object;
	
	public DoubleList(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		this.comparator = comparator;
		
	}

	public DoubleList() {
		// TODO Auto-generated constructor stub
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
			aux.getNext().setBack(aux);
		}
	}
	
	public void insertSort(T data,Comparator comparator2) {
		String city= "Duitama";
		System.out.println(city.compareToIgnoreCase("Sogamoso"));
		 Node<T> newNode = new Node<>(data);
	        Node<T> aux = head;
	        boolean placed = false;
	        if(head == null){  
	            head = newNode;
	        }else if(comparator.compare(head.getValue(), data) > 0){ 
	            head.setBack(newNode);
	            newNode.setNext(head);
	            head = newNode;
	        }
	        
	        while (aux != null && !placed){
	            if(comparator.compare(aux.getValue(),data) > 0){ 
	                aux.getBack().setNext(newNode); 
	                newNode.setNext(aux);
	                newNode.setBack(aux.getBack());
	                aux.setBack(newNode);
	                placed = true;
	            }else if(comparator.compare(aux.getValue(),data) < 0 && aux.getNext() == null){
	                aux.setNext(newNode);
	                newNode.setBack(aux);
	                placed = true;
	            }
	            aux = aux.getNext();
	        }

	}
	
	public void insertToSort(T data, Comparator comparator2) {
		
		if(head == null){
			head = new Node<T>(data);
		}else{
			
			Node<T> node = new Node<T>(data);
			Node<T> aux = head;
			
			if(head.getNext() == null) {
				System.out.println(node+"1");
				if(comparator2.compare(head.getValue(), data)>0) {
					System.out.println(comparator2.compare(head.getValue(), data));//Borrar
					node.setNext(aux);
					aux.setBack(node);
					head = node;
					System.out.println(node.getNext()+"2");//Borrar
					
				}else {
					head.setNext(node);
				}
				
			}
			
			System.out.println(node);
			while(aux.getNext() != null && aux!=head) {
				if(comparator2.compare(aux.getValue(), data)<0&& aux.getNext() != null) {
					aux = aux.getNext();	
				}else {
					aux.getBack().setNext(node);
					node.setNext(aux);
				}
				
			}
			if(comparator2.compare(aux.getValue(), data)<0) {
				aux.setNext(node);
				aux.getNext().setBack(aux);
			}
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
	
	public void remove(Node<T> data) {
		if(comparator.compare(head.getValue(), data.getValue())!=0) {
			Node<T> aux = head.getNext();
			//Node aux2 = head.getNext();
			
			while(aux != null) {
				if(comparator.compare(aux.getValue(), data.getValue())==0&&aux.getNext() != null) {
					aux.getBack().setNext(aux.getNext()); 
				}
				aux = aux.getNext();
			}
			
		}else {
			head = head.getNext();
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

	
	
	public Iterator<T> iterator() {
		Iterator<T> myIterator = new Iterator<T>() {
			Node<T> actual = head;
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
				setObject(data);
				return data;
			}
			
		};
		return myIterator;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	public T getObject() {
		return object;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}


}
