package model.vo;

public class Customer {
	String CuTel;				// 고객 전화번호
	String CuName;		// 고객명
	String PName;			// 상품명
	String PCount;		    // 상품개수
	String ResDate;		// 날짜
	public String getCuTel() {
		return CuTel;
	}
	public void setCuTel(String cuTel) {
		CuTel = cuTel;
	}
	public String getCuName() {
		return CuName;
	}
	public void setCuName(String cuName) {
		CuName = cuName;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public String getPCount() {
		return PCount;
	}
	public void setPCount(String pCount) {
		PCount = pCount;
	}
	public String getResDate() {
		return ResDate;
	}
	public void setResDate(String resDate) {
		ResDate = resDate;
	}
	


}
