package h_inherit_book;

import java.util.Scanner;
import h_inherit_book_sub.Item;

public class Main {

	public static void main(String[] args) {
		//Item i = new Item; 불가능.미완성 클래스는 객체생성이 안됨
		Item i = null;
		Scanner input = new Scanner(System.in);
		System.out.println("항목을 선택하세요(1.Book 2.Dvd 3.Cd)");
		int sel = input.nextInt();
		switch(sel){
			case 1: i = new Book("0001","자바","홍길동","엔코아"); break;
			case 2: i = new Dvd("0002","파이썬","감독","엔코아"); break;
			case 3: i = new Cd("0003","c++","작가"); break;
		}
		i.output();
		
//		Book b= new Book();
//		b.output();
//		Book b2 = new Book("0001","자바","홍길동","엔코아");
//		b2.output();
//		Dvd d = new Dvd("0002","파이썬","감독","엔코아");
//		d.output();
//		Cd c = new Cd("0003","c++","작가");
//		c.output();
	}

}
