package model;

import java.util.Comparator;
import java.util.Iterator;

import resources.DoubleList;
import resources.Node;

public class GroupStores {
	
	private DoubleList<Store> listStores;
	
	public GroupStores() {
		super();
		this.listStores = new DoubleList<Store>((x,y)-> x.getName().equals((y.getName()))?0:1 );
	}
	
	
	public Store searchStore( String nameStore) {
		Iterator<Store> iterator = listStores.iterator();
		
		while(iterator.hasNext()) {
			Store store = iterator.next();
			if(store.getName().equals(nameStore)) {
//				listStores.getObject().addProduct(product);
				return store;
			}
		}
		return null;
	}
	
	public void addProductToStore(Product product, String nameStore) {
		searchStore(nameStore).addProduct(product);		
	}
	
	public Product showProduct(int code) {
		Iterator<Store> iterator = listStores.iterator();
		
		while(iterator.hasNext()) {
			Product product = iterator.next().showProduct(code);
			if(product !=null) {
				return product;
			}
		}
		return null;
	}
	
	public Product showProductToSore(String nameStore,int code) {
		return searchStore(nameStore).showProduct(code);	
	}
	
	
	public String showInventary() {
		StringBuilder sb = new StringBuilder();
		long value = 0;
		Iterator<Store> iterator = listStores.iterator();
		
		while(iterator.hasNext()) {
			
			Iterator<Product> iterator2 = iterator.next().getInventary().iterator();
			while(iterator2.hasNext()) {
				Product product = iterator2.next(); 
				sb.append(product+"\n");
				value = value+product.getValue();
			}
		}
		sb.append("El valor total del inventario es $"+value);
			
		return sb.toString();
	}

	
	public void addStore(Store store) {
		listStores.insertSort(store,  new Comparator<Store>() {
            @Override
            public int compare(Store t1, Store t2) {
                return t1.getName().compareToIgnoreCase(t2.getName());
            }
        });
	}
	
	public void toSell(String nameStore,int code) {
		searchStore(nameStore).toSell(code);
	}
	
	public Comparator comparatorByAlphabet(){
        Comparator<Store> comparator = new Comparator<Store>() {
            @Override
            public int compare(Store t1, Store t2) {
                return t1.getName().compareToIgnoreCase(t2.getName());
            }
        };
        return comparator;
    }
	
	public DoubleList<Store> getListStores(){
		return listStores;
	}
	
}
