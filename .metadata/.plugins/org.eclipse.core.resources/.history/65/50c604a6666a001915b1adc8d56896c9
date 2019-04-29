package h_inherit_book_sub;

//부모클래스
public abstract class Item {
	protected String no;
	protected String title;
	public Item(){
		 System.out.println("Item 기본생성자");
	}
	
	public Item(String no, String title){
		this.no=no;
		this.title=title;
		System.out.println("Item 인자생성자");		
	}
	public abstract void output();
	// 함수표시{}는 아무일도 하지 않지만 완벽한 함수 구현
	// 클래스와 메소드에 abstract 붙여줘야함
	// 자식클래스에서 무조건 overriding시켜서 완성해야함
}
