package model.vo;

public class Sales {
	
	int salnum; 		// 판매번호
	String ccustTel;		// 고객전화번호
	int inventoryNo;	//상품번호
	int ccustPcount;		// 상품개수
	int price;				// 가격
	String exdate;	// 유통기한
	
	
	public int getSalnum() {
		return salnum;
	}
	public void setSalnum(int salnum) {
		this.salnum = salnum;
	}
	public String getCcustTel() {
		return ccustTel;
	}
	public void setCcustTel(String ccustTel) {
		this.ccustTel = ccustTel;
	}
	public int getInventoryNo() {
		return inventoryNo;
	}
	public void setInventoryNo(int inventoryNo) {
		this.inventoryNo = inventoryNo;
	}
	public int getCcustPcount() {
		return ccustPcount;
	}
	public void setCcustPcount(int ccustPcount) {
		this.ccustPcount = ccustPcount;
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
