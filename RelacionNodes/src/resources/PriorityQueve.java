package resources;
import java.util.ArrayList;

public class PriorityQueve<T> {
	private ArrayList<Queve> queveList;
	
	public PriorityQueve() {
		queveList =new ArrayList<Queve>();
	}
	
	public void push(int numberPriority,T data) {
		if(queveList.size()>0 &&queveList.get(numberPriority-1) != null) {
			queveList.get(numberPriority-1).push(data);
		}else {
			queveList.add(new Queve());
			push(numberPriority,data);
		}
	}
	
	public T poll() {
		for(int i = 0; i <  queveList.size(); i++) {
			if(queveList.get(i) != null) {
				return  (T) queveList.get(i).poll();
			}
		}
		return null;
	}
	
	public T peek() {
		for(int i = 0; i <  queveList.size(); i++) {
			if(queveList.get(i) != null) {
				return  (T) queveList.get(i).peek();
			}
		}
		return null;
	}
	
	public boolean isEmply() {
		return (peek()==null);
	}
	
	public boolean exist(T data) {
		for(int i = 0; i <  queveList.size(); i++) {
			if(queveList.get(i) != null) {
				return queveList.get(i).exist(data);
			}
		}
		return false;
	}
	
	

}
