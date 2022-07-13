package test;

import java.util.Iterator;

import model.GroupStores;
import model.Product;
import model.Store;
import model.Student;
import resources.DoubleList;

public class TestStore {
	
	public static void main(String[] args) {
		
		GroupStores groupStores = new GroupStores();
		groupStores.addStore(new Store("Tunja","Centro"));
		groupStores.addStore(new Store("Duitama","Centro"));
		groupStores.addStore(new Store("Sogamoso","Centro"));
		groupStores.addStore(new Store("Cucuta","Centro"));
		groupStores.addStore(new Store("Paipa","Centro"));
		groupStores.addStore(new Store("Medellin","Centro"));
		groupStores.addStore(new Store("Manizales","Centro"));
		
		groupStores.addProductToStore(new Product("Jabon",65235,2300), "Tunja");
		groupStores.addProductToStore(new Product("Rejilla",69823,39900), "Tunja");
		groupStores.addProductToStore(new Product("Tanque",62543,599900), "Tunja");
		groupStores.addProductToStore(new Product("Rejilla",69823,39900), "Tunja");
		groupStores.addProductToStore(new Product("Jabon",65235,2300), "Tunja");
		groupStores.addProductToStore(new Product("Rejilla",69823,39900), "Tunja");
		groupStores.addProductToStore(new Product("Tanque",62543,599900), "Tunja");
		groupStores.addProductToStore(new Product("Avion",69898,39900), "Tunja");
		groupStores.addProductToStore(new Product("Elefante-Juguete",34534,2300), "Tunja");
		groupStores.addProductToStore(new Product("Rejilla",69823,39900), "Tunja");
		groupStores.addProductToStore(new Product("Tanque",62543,599900), "Tunja");
		groupStores.addProductToStore(new Product("Rejilla",69823,39900), "Tunja");
		
		
//		System.out.println(groupStores.showProduct(65235));
//		
		System.out.println(groupStores.showInventary());
//		
//		groupStores.toSell("Sogamoso", 69823);
//		
//		System.out.println(groupStores.showInventary());
		for(Store store:groupStores.getListStores()) {
			System.out.println(store);
		}
		System.out.println(groupStores.searchStore("Tunja").showProducts());

	}

}
