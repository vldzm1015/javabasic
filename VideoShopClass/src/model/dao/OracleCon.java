package model.dao;

public class OracleCon {
	static OracleCon con = null;
	
	private OracleCon() throws Exception{
		//1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("단 한번");
		
	}

	public static void getInstance()throws Exception{
		if (con==null) {
			con= new OracleCon();
		}
	}
}
