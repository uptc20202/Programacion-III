package test;

import java.util.Comparator;

import model.BynaryTreeSearch;

public class TestTree {
	public static void main(String[] args) {
		BynaryTreeSearch<Integer> bynaryTreeSearch = 
				new BynaryTreeSearch<Integer>((x,y) -> (Integer)x - (Integer)y);
		
		bynaryTreeSearch.insert(2);
		bynaryTreeSearch.insert(4);
		bynaryTreeSearch.insert(5);
		bynaryTreeSearch.insert(6);
		bynaryTreeSearch.insert(8);
		bynaryTreeSearch.insert(78);
		bynaryTreeSearch.insert(98);
		bynaryTreeSearch.insert(22);
		bynaryTreeSearch.insert(7);
		
		
		for(Integer sheet2 : bynaryTreeSearch.showPostorder()) {
			System.out.print(sheet2+" ");
		}
		
		try {
			bynaryTreeSearch.detele(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n Elemento Eliminado \n");

		for(Integer sheet2 : bynaryTreeSearch.showPostorder()) {
			System.out.print(sheet2+" ");
		}
		
		
		System.out.println("Se encontro: "+bynaryTreeSearch.search((x,y) -> (Integer)x - (Integer)y, 7));
	}
}
