package test;

import model.AVLTree;

public class Test {
	public static void main(String[] args) {
		AVLTree<Integer> bynaryTreeSearch = 
				new AVLTree<Integer>((x,y) -> (Integer)x - (Integer)y);
		
		bynaryTreeSearch.insert(2);
		bynaryTreeSearch.insert(4);
		bynaryTreeSearch.insert(5);
		bynaryTreeSearch.insert(6);
		bynaryTreeSearch.insert(8);
		bynaryTreeSearch.insert(78);
		bynaryTreeSearch.insert(98);
		bynaryTreeSearch.insert(22);
		bynaryTreeSearch.insert(7);
		
		for(Integer sheet2 : bynaryTreeSearch.showInorder()) {
			System.out.print(sheet2+" ");
		}
		
		try {
			bynaryTreeSearch.detele(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n Elemento Eliminado \n");

		for(Integer sheet2 : bynaryTreeSearch.showInorder()) {
			System.out.print(sheet2+" ");
		}
		
		
		
	}

}
