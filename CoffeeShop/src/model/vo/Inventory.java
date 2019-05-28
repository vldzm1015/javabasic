package model.vo;

public class Inventory {
	
	int inventoryNo;					// 인벤토리번호
	String inventoryPname;			// 인벤토리명
	int price;				// 가격
	String exdate;					// 유통기한
	
	
	public int getInventoryNo() {
		return inventoryNo;
	}
	public void setInventoryNo(int inventoryNo) {
		this.inventoryNo = inventoryNo;
	}
	public String getInventoryPname() {
		return inventoryPname;
	}
	public void setInventoryPname(String inventoryPname) {
		this.inventoryPname = inventoryPname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExdate() {
		return exdate;
	}
	public void setExdate(String exdate) {
		this.exdate = exdate;
	}
	
	

}
