package model;

import java.util.ArrayList;

public class ValidateTable {
	
	private ArrayList<String[]> datasTables;
	private String user;
	
	
	public ValidateTable() {
		super();
		datasTables = new ArrayList<String[]>();
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<String[]> fillTable(String datasTable, String user) {
		// TODO Auto-generated method stub
		if(!datasTable.equalsIgnoreCase("")) {
			this.user = user;
			String[] newStr = datasTable.split(";");
			
			
	        for (String auctions:newStr) {
	        	String[] dataAuctions = auctions.split(",");
	        	datasTables.add(dataAuctions);
	        }
		}  
		return datasTables;
	}
	
	public Object [][] fillOverallTable() {
		Object[][] datas = new Object [datasTables.size()][];
		
		for( int i = 0; i < datasTables.size(); i++) {
			String[] datas2 = datasTables.get(i);
			String[] datas3 = new String[3];
			
			
				for( int j = 0; j < datas3.length; j++) {
				
        			datas3[j] = 
        					datas2[j];
				
        		}
				
			datas[i]=datas3;
		}
		
		return datas;
	}
	
	public Object [][] fillUserTable() {
		int length =0;
		
		
		for( int i = 0; i < datasTables.size(); i++) {
			if(datasTables.get(i)[3].equalsIgnoreCase(user)) {
				length++;
			}
		}
		
		Object[][] datas = new Object [length][];
		
		for( int i = 0; i < datasTables.size(); i++) {
			if(datasTables.get(i)[3].equalsIgnoreCase(user)) {
			String[] datas2 = datasTables.get(i);
			String[] datas3 = new String[3];
			for( int j = 0; j < datas3.length; j++) {
        			datas3[j] = datas2[j];
        	}
			datas[i]=datas3;
			}
		}	
		
		return datas;
	}
}
