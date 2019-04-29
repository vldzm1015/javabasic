package zz_ex00;

public class CompactDisc extends Product {
	String title;
	String singer;

	CompactDisc(){
		super();
	}
	CompactDisc(int productID, String description, String producer, 
			int price,String title, String singer){
		super(productID, description, producer, price);
		this.title=title;
		this.singer=singer;
	}
	
	public void showInfo() {
		System.out.println("상품ID : "+productID);
		System.out.println("상품설명 : "+description);
		System.out.println("생산자 : "+producer);
		System.out.println("가격: "+price);
		System.out.println("제목 : "+title);
		System.out.println("가수 : "+singer);
	}
}

