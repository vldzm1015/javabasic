package zz_ex00;
//ISBN번호, 저자, 책제목 
public class Book extends Product {
	protected int ISBN;
	protected String author;
	protected String title;
	
	public Book(){
		super();
	}

	public Book(int productID, String description, String producer, int price, 
			int ISBN, String author, String title){
		super(productID,description,producer,price);
		this.ISBN=ISBN;
		this.author=author;
		this.title=title;
	}
	      
	public void showInfo() {
		System.out.println("상품ID : "+productID);
		System.out.println("상품설명 : "+description);
		System.out.println("생산자 : "+producer);
		System.out.println("가격 : "+price);
		System.out.println("ISBN : "+ISBN);
		System.out.println("저자 : "+author);
		System.out.println("제목 : "+title);
	}
}
