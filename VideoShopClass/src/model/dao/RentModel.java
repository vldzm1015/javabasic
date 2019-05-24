package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import model.RendtDao;


public class RentModel implements RendtDao{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.161:1521:orcl";
	String user = "dbtry";
	String pass = "dbtry";
	Connection con = null;
	
	
	public RentModel() throws Exception{
		// 1. 드라이버로딩
		OracleCon.getInstance();
	}

	public void rentVideo(String tel, int vnum) throws Exception {
		//2.연결객체
		Connection con = DriverManager.getConnection(url, user, pass);
		//3. sql 문장
		String sql = "INSERT INTO RENT(RENTNO,TEL,V_NUM,RENTDAY,AVAILABLE) "
				+ "  VALUES(seq_rent_num.nextval,?,?,SYSDATE,'F')";
		//4.전송 객체
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,tel);	 
		st.setInt(2,vnum);
		//5. 전송
		st.executeQuery();
		//6. 닫기
		st.close();
		con.close();
	}

	public int returnVideo(int vnum) throws Exception {
		int result = 0;
		Connection con = DriverManager.getConnection(url, user, pass);
		String sql = "UPDATE RENT SET AVAILABLE='T' "
				+ " WHERE V_NUM=? AND AVAILABLE='F' ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,vnum);
		st.executeQuery();
		st.close();
		con.close();
		return result;
	}

	public ArrayList selectList() throws Exception {
		con = DriverManager.getConnection(url,user,pass);
		ResultSet rs = null;
		PreparedStatement st = null;
		ArrayList list = new ArrayList();
		String sql ="SELECT V.V_NUM V_NUM, V.TITLE TITLE, C.NAME NAME, C.TEL TEL, R.RENTDAY+3 RENTDAY, R.AVAILABLE AVAILABLE  "
				+ "  FROM RENT R INNER JOIN VIDEO V  " 
				+ "  ON R.V_NUM=V.V_NUM  " 
				+ "  INNER JOIN CUSTOMER C  " 
				+ "  ON R.TEL=C.TEL " 
				+ "  WHERE AVAILABLE = 'F' " ;
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		while(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장
			ArrayList data = new ArrayList();
			//data에 각 컬럼에서 얻어 온 갑을 추가
			data.add(rs.getInt("V_NUM"));
			data.add(rs.getString("TITLE"));
			data.add(rs.getString("NAME"));
			data.add(rs.getString("TEL"));
			data.add(rs.getString("RENTDAY"));
			data.add(rs.getString("AVAILABLE"));

			//7.닫기
			list.add(data);


		}
		return list;
	}
	
	
}
