package model.vo;

public class Reserve {
	String ccustTel;		// 고객전화번호
	String ccustCName;			// 고객명
	String ccustPname;			// 상품명
	int ccustPcount;		// 상품개수
	String ccustResdate;		// 예약날짜

	public Reserve() {
		
	}
	
public Reserve(String ccustTel, String ccustCName, String ccustPname, int ccustPcount, String ccustResdate) {
		super();
		this.ccustTel = ccustTel;
		this.ccustCName = ccustCName;
		this.ccustPname = ccustPname;
		this.ccustPcount = ccustPcount;
		this.ccustResdate = ccustResdate;
	}

public String getCcustTel() {
	return ccustTel;
}

public void setCcustTel(String ccustTel) {
	this.ccustTel = ccustTel;
}

public String getCcustCName() {
	return ccustCName;
}

public void setCcustCName(String ccustCName) {
	this.ccustCName = ccustCName;
}

public String getCcustPname() {
	return ccustPname;
}

public void setCcustPname(String ccustPname) {
	this.ccustPname = ccustPname;
}

public int getCcustPcount() {
	return ccustPcount;
}

public void setCcustPcount(int ccustPcount) {
	this.ccustPcount = ccustPcount;
}

public String getCcustResdate() {
	return ccustResdate;
}

public void setCcustResdate(String ccustResdate) {
	this.ccustResdate = ccustResdate;
}


}
