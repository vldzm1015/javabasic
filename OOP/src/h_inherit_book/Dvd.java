package h_inherit_book;
import h_inherit_book_sub.Item;
public class Dvd extends Item{
	String acter;
	String director;
	Dvd(){
		//System.out.println("Dvd 기본생성자");
	}
	Dvd(String no, String title, String acter, String director){
		super(no,title);
		this.acter = acter;
		this.director = director;
		//System.out.println("Dvd 인자생성자");
	}
	public void output() {
		System.out.println("책번호 : "+no);
		System.out.println("제목 : "+title);
		System.out.println("배우 : "+acter);
		System.out.println("감독 : "+director);
	}
}


