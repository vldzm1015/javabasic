package h_inherit_book;
//자식클래스
import h_inherit_book_sub.Item;
public class Book extends Item {
	String writer;
	String publisher;
	Book(){
		//super(); 
		// ^ 없으면 자동으로 들어옴.
		// 있으면 자동 생성 안함.
		//System.out.println("Book 기본생성자");
	}
	Book(String no, String title, String writer, String publisher){
		//직접호출 = this , 부모호출 = super
		super(no,title);
//		super.no = no;
//		super.title = title;
		this.writer = writer;
		this.publisher = publisher;
		//System.out.println("Book 인자생성자");
	}
	public void output() {
		System.out.println("책번호 : "+ no);
		System.out.println("제목 : "+ title);
		System.out.println("작가 : "+writer);
		System.out.println("출판사 : "+publisher);
	}
}
