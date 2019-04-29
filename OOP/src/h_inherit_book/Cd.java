package h_inherit_book;
import h_inherit_book_sub.Item;

public class Cd extends Item{
	String singer;
	
	Cd(){
		//System.out.println("Cd 기본생성자");
	}
	Cd(String no, String title, String singer){
		super(no,title);
		this.singer = singer;
		//System.out.println("Cd 인자생성자");
	}
	public void output() {
		System.out.println("Cd번호 : "+no);
		System.out.println("제목 : "+title);
		System.out.println("가수 : "+singer);
	}
}


