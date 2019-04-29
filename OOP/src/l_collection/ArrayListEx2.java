package l_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx2 {

	public static void main(String[] args) {
		ArrayList<Student> data = method();
//		일반 for문		
//		for (int i = 0; i < args.length; i++) {
//			Student s = (Student)data.get(i);
//		향상된 for문
//		for( Student s : data) {	
//			System.out.println(s);
//		}
		// 표준화출력
		// Enumeration - > Iterator
		Iterator<Student> it = data.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
		
	}
	static ArrayList<Student> method() {
		Student a = new Student("홍길자",20);
		Student b = new Student("홍길숙",30);
		Student c = new Student("홍길동",40);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(a);
		list.add(b);
		list.add(c);
		return list;
	}
}

class Student{
	String name;
	int age;
	Student(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	public String toString() {
		return name +" 학생은 "+age+"점 입니다.";
	}
}