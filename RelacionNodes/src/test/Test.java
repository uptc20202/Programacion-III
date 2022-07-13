package test;

import java.util.Comparator;
import java.util.Iterator;

import model.Student;
import model.StudentComparator;
import resources.DoubleList;
import resources.Node;
import resources.SimpleList;

public class Test {
	
	public static void main(String[] args) {
		DoubleList<Student> SimpleList = new DoubleList<Student>((x,y)-> x.getCode()-y.getCode());
		
		SimpleList.insert(new Student("Juan",123));
		SimpleList.insert(new Student("lucas",1323));
		SimpleList.insert(new Student("martin",1223));
//		numberSimpleList.insert(4);
//		numberSimpleList.insert(5);
//		numberSimpleList.insert(6);
//		numberSimpleList.insert(22);
//		SimpleList.remove(new Node(new Student("Juan",123)));
		
		Iterator<Student> iterator = SimpleList.iterator();
		
		while(iterator.hasNext()) {
			Student student = iterator.next();
			student.setCode(student.getCode()*100);
		}
		
		System.out.println(SimpleList.show());
		System.out.println("El valor "+new Node(new Student("Juan",123))+ (SimpleList.exist(new Node(new Student("Juan",123)))?" Si":" No") + " se encuentra en la lista");
	}
}
