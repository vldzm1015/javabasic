package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.SalesDao;


public  class SalesModel implements SalesDao{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.161:1521:orcl";
	String user = "dbtry";
	String pass = "dbtry";
	Connection con = null;


	public SalesModel() throws Exception{
		// 1. 드라이버로딩
		OracleCon.getInstance();
	}

	// 결제
	public void coffePay(ArrayList list) throws Exception {
		//2.연결객체
		Connection con = DriverManager.getConnection(url, user, pass);


		//3. sql 문장
		String sql1 ="INSERT INTO Sales(SALNUM,  IVNUM,SCOUNT, DDATE) "
				+ "  VALUES(SEQ_SALNUM.nextval, (SELECT ivnum FROM Inventory WHERE pname=? ),?,SYSDATE)";

		//4.전송 객체
		PreparedStatement st1 = con.prepareStatement(sql1);

		for (int i = 0; i < list.size(); i++) {
			ArrayList temp = (ArrayList)list.get(i);
			st1.setString(1,(String)temp.get(0));
			st1.setInt(2,(Integer) temp.get(1));		

			//5. 전송z
			st1.executeUpdate();
		}


		//6. 닫기
		st1.close();

		//--------------------------------------------------------

		//3. sql 문장
		String sql2 =" UPDATE INVENTORY SET  PCOUNT=PCOUNT-?   " + 
				" WHERE IVNUM=(SELECT ivnum FROM Inventory WHERE pname=?)";
		//4.전송 객체
		PreparedStatement st2 = con.prepareStatement(sql2);

		for (int i = 0; i < list.size(); i++) {
			ArrayList temp = (ArrayList)list.get(i);
			st2.setInt(1,(Integer) temp.get(1));		
			st2.setString(2,(String)temp.get(0));

			//5. 전송z
			st2.executeUpdate();
		}
		//6. 닫기
		st2.close();

		con.close();
	}

	// 환불
	public void coffereturn(ArrayList list) throws Exception {
		//2.연결객체
		Connection con = DriverManager.getConnection(url, user, pass);


		//3. sql 문장
		String sql1 =" UPDATE SALES SET  SCOUNT=SCOUNT-?   " + 
				" WHERE IVNUM=(SELECT ivnum FROM Inventory WHERE pname=?)";

		PreparedStatement st1= con.prepareStatement(sql1);

		for (int i = 0; i < list.size(); i++) {
			ArrayList temp = (ArrayList)list.get(i);
			st1.setInt(1,(Integer) temp.get(1));		
			st1.setString(2,(String)temp.get(0));

			//5. 전송z
			st1.executeUpdate();
		}

		//6. 닫기
		st1.close();
	
		//3. sql 문장
		String sql2 =" UPDATE   INVENTORY  SET  PCOUNT = PCOUNT+?   " + 
				" WHERE  IVNUM=(SELECT  IVNUM  FROM  INVENTORY  WHERE  PNAME=?)";
		//4.전송 객체
		PreparedStatement st2 = con.prepareStatement(sql2);

		for (int i = 0; i < list.size(); i++) {
			ArrayList temp = (ArrayList)list.get(i);
			st2.setInt(1,(Integer) temp.get(1));		
			st2.setString(2,(String)temp.get(0));

			//5. 전송z
			st2.executeUpdate();
		}
		//6. 닫기
		st2.close();

		con.close();
	}
}
