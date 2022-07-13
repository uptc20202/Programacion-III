package test;

import model.RootSort;
import resources.Queve;

public class testRoot {
	
	public static void main(String[] args) {
		RootSort rootSort = new RootSort();
		
		rootSort.insert(442);
		rootSort.insert(503);
		rootSort.insert(312);
		rootSort.insert(145);
		rootSort.insert(250);
		rootSort.insert(341);
		rootSort.insert(325);
		rootSort.insert(102);
		rootSort.insert(420);
		rootSort.insert(143);
		
		for(Queve<Integer> queve:rootSort.getRootList()) {
			for(int a:queve) {
				System.out.print(a+" ");
			}
		}
		
		rootSort.sort();
		
		for(Queve<Integer> queve:rootSort.getRootList()) {
			for(int a:queve) {
				System.out.print(a+" ");
			}
		}
	}

}
