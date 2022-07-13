package model;

import java.util.Comparator;

import resources.DoubleList;
import resources.Queve;

public class RootSort {
	private Queve<Queve> rootList;
	
	
	public RootSort() {
		super();
		this.rootList = new Queve<Queve>();
		for(int i = 1; i <= 6 ;i++) {
			rootList.push(new Queve<Integer>());
		}
		
	}
	
	public void insert(int number) {
		rootList.peek().push(number);;
	}

	public void sort() {
		for(int i = 3; i > 0 ;i--) {
			fillQueveZero();	
			sortBySweep(i);
		}
	}
	
	public void fillQueveZero() {
		Queve subQueve;
		subQueve = rootList.poll();
		rootList.push(subQueve);
		for(int z = 0; z < 5 ;z++) {
			Queve aux = rootList.poll();
			rootList.push(aux);
			boolean validate = true;
			while(validate) {
				try {
					subQueve.push(aux.poll());
				}catch(NullPointerException e) {
					validate = false;
				}
			}
			
		}
	}

	public void sortBySweep(int numberOfSweeps) {
		Queve subQueve;
		
		for(int i = 0; i < 6 ;i++) {
			subQueve = rootList.poll();
			rootList.push(subQueve);
			Integer value = (int) subQueve.peek();
			
			int valueCondition = value;
			boolean comprobateFront = true;
			try {
			do{	 
				subQueve.poll();
					String value2 =String.valueOf( String.valueOf(value).charAt(numberOfSweeps-1));
					if(Integer.parseInt(value2) != i) {
						rootList.peek().push(value);
						
					}else {
						if(comprobateFront) {
							valueCondition = value;
							comprobateFront=false;
						}
						subQueve.push(value);
						
					}
					value =(int) subQueve.peek();
					 
						
				
			}while(valueCondition != value);
				
			}catch(NullPointerException e) {
				System.out.println("NullPointerException caught");
			}
			

		}
	}
	
	

	public Queve<Queve> getRootList() {
		return rootList;
	}

	public void setRootList(Queve<Queve> rootList) {
		this.rootList = rootList;
	}
}
