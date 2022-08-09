package model;

import java.util.ArrayList;
import java.util.Comparator;

public class ValidateTable {
	
	public ValidateTable() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<String[]> fillTable(String datasTable) {
		// TODO Auto-generated method stub
		ArrayList<String[]> datasTables = datasTables = new ArrayList<String[]>();
		if(!datasTable.equalsIgnoreCase("")) {
			String[] newStr = datasTable.split(";");
			
			
	        for (String auctions:newStr) {
	        	String[] dataAuctions = auctions.split(",");
	        	datasTables.add(dataAuctions);
	        }
		}  
		return datasTables;
	}
	
	public Object [][] fillOverallTable(ArrayList<String[]> datasTables) {
		Object[][] datas = new Object [datasTables.size()][];
		
		for( int i = 0; i < datasTables.size(); i++) {
			String[] datas2 = datasTables.get(i);
			String[] datas3 = new String[4];
			
			
				for( int j = 0; j < datas3.length; j++) {
				
        			datas3[j] = 
        					datas2[j];
				
        		}
				
			datas[i]=datas3;
		}
		
		return datas;
	}
	
	public ArrayList<String[]> fillTableSort(String datasTable) {
		ArrayList<String[]> datasTables = fillTable(datasTable);
		datasTables.sort(new Comparator<String[]>() {
		    @Override
		    public int compare(String[] o1, String[] o2) {
		        return Integer.parseInt(o1[2])- Integer.parseInt(o2[2]);
		    }
		});
		
		return datasTables;
	}
}
