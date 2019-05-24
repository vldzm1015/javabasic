package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import jdbc.gui.InfoVO;
import model.ReserveDao;
import model.vo.Reserve;

public class ReserveModel implements ReserveDao{
	
	//  화면 띄움과 동시에 DB에 연결하기 
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.161:1521:orcl";
	String user = "dbtry";
	String pass = "dbtry";
	Connection con = null;
	
	
	public ReserveModel() throws Exception{
	 	// 1. 드라이버로딩
		//Class.forName(driver);
		OracleCon.getInstance();
	}
	
	public void insertCustomer(Reserve vo) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);	
		System.out.println("연결성공1");
		// 3. sql 문장 만들기
		String sql = "INSERT INTO ccustomer(CUTEL,CUNAME,PNAME,PCOUNT,RESDATE)    VALUES(?,?,?,?,SYSDATE)";
		
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,vo.getCcustTel());	
		st.setString(2,vo.getCcustCName());
		st.setString(3,vo.getCcustPname());
		st.setInt(4,vo.getCcustPcount());
		//st.setString(5,vo.getCcustResdate());
	
		// 5. sql 전송
		int result = st.executeUpdate();
		
		// 6. 닫기 
		st.close();
		con.close();
		
		System.out.println(result+ "1행 sql 전송 성공");

	}
	
	public int updateCustomer(Reserve vo) throws Exception{
		int result = 0;
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String sql = "UPDATE CCUSTOMER SET CUTEL=?, CUNAME=?, PNAME=?, PCOUNT=?, RESDATE=SYSDATE  WHERE CUTEL=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,vo.getCcustTel()); 
		st.setString(2,vo.getCcustCName());
		st.setString(3,vo.getCcustPname());
		st.setInt(4,vo.getCcustPcount());
		st.setString(5,vo.getCcustTel());
		
		result = st.executeUpdate();
		
//		if(result != 0) {
//			con.commit();
//		}else {
//			con.rollback();
//		}
		
		st.close();
		con.close();
		
		
		return result;
	}
	
	
	public void deleteCustomer(String ccustTel) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "DELETE FROM CCUSTOMER "
				+ "  WHERE CUTEL=? ";

		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,ccustTel);	 
		st.executeUpdate();
		// 6. 닫기
		st.close();
		con.close();
	}
	
	public Reserve selectByTel(String ccustTel) throws Exception{
		
		Reserve vo = new Reserve();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
		con = DriverManager.getConnection(url,user,pass);
		
		String sql = "SELECT * FROM ccustomer WHERE CUTEL = ?";
		
		st = con.prepareStatement(sql);
		st.setString(1,ccustTel);
		
		rs = st.executeQuery();
		
		if(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장	// primary => if
			vo.setCcustTel(rs.getString("CUTEL"));
			vo.setCcustCName(rs.getString("CUNAME"));
			vo.setCcustPname(rs.getString("PNAME"));
			vo.setCcustPcount(rs.getInt("PCOUNT"));
			vo.setCcustResdate(rs.getString("RESDATE"));
		}
		
		return vo;
		
		}finally {
		rs.close();
		st.close();
		con.close();
		}
		
		
	}

	
	

}
