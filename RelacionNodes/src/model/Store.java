package model;

import java.util.Iterator;

import resources.DoubleList;
import resources.Node;

public class Store {
	
	private String name;
	private String address;
	private DoubleList<Product> inventary;
	
	public Store(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.inventary = new DoubleList<Product>((x,y)-> x.getCode() - y.getCode());
	}
	
	public void addProduct(Product product) {
		inventary.insertSort(product,inventary.getComparator());
	}
	
	public Product showProduct(int code) {
		Iterator<Product> iterator = inventary.iterator();
		
		while(iterator.hasNext()) {
			Product product = iterator.next();
			if(product.getCode() == code ) {
				return product;
			}
		}	
		return null;
	}
	
	public String showProducts() {
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Product> iterator = inventary.iterator();
		
		while(iterator.hasNext()) {
			sb.append(iterator.next()+"\n");
		}
			
		return sb.toString();
	}


	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public DoubleList<Product> getInventary() {
		return inventary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setInventary(DoubleList<Product> inventary) {
		this.inventary = inventary;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + ", address=" + address  + "]";
	}
	
	public void toSell(int code) {
		inventary.remove(new Node(showProduct(code)));
		
	}
	
	
	
	

}
