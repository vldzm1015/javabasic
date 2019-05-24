package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import jdbc.gui.InfoVO;
import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao{
	
	//  화면 띄움과 동시에 DB에 연결하기 
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.161:1521:orcl";
	String user = "dbtry";
	String pass = "dbtry";
	Connection con = null;
	
	
	public CustomerModel() throws Exception{
	 	// 1. 드라이버로딩
		//Class.forName(driver);
		OracleCon.getInstance();
	}
	
	public void insertCustomer(Customer vo) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);	
		
		// 3. sql 문장 만들기
		String sql = "INSERT INTO customer(TEL,NAME,S_TEL,ADDR,EMAIL)    VALUES(?,?,?,?,?)";
		
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,vo.getCustTel1());	
		st.setString(2,vo.getCustName());
		st.setString(3,vo.getCustTel2());
		st.setString(4,vo.getCustAddr());
		st.setString(5,vo.getCustEmail());
	
		// 5. sql 전송
		int result = st.executeUpdate();
		
		// 6. 닫기 
		st.close();
		con.close();
		
		System.out.println(result+ "1행 sql 전송 성공");

	}
	
	public Customer selectByTel(String tel) throws Exception{
		
		Customer vo = new Customer();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
		con = DriverManager.getConnection(url,user,pass);
		
		String sql = "SELECT * FROM customer WHERE TEL = ?";
		
		st = con.prepareStatement(sql);
		st.setString(1,tel);
		
		rs = st.executeQuery();
		
		if(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장	// primary => if
			vo.setCustName(rs.getString("NAME"));
			vo.setCustTel1(rs.getString("TEL"));
			vo.setCustTel2(rs.getString("S_TEL"));
			vo.setCustAddr(rs.getString("ADDR"));
			vo.setCustEmail(rs.getString("EMAIL"));
		}
		
		return vo;
		
		}finally {
		rs.close();
		st.close();
		con.close();
		}
		
		
	}
	
	public int updateCustomer(Customer vo) throws Exception{
		int result = 0;
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String sql = "UPDATE CUSTOMER SET NAME=?, S_TEL=?, ADDR=?, EMAIL=?  WHERE TEL=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,vo.getCustName()); 
		st.setString(2,vo.getCustTel2());
		st.setString(3,vo.getCustAddr());
		st.setString(4,vo.getCustEmail());
		st.setString(5,vo.getCustTel1());
		
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

	
	public Customer selectByName(String name) throws Exception {
		Customer vo = new Customer();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
		con = DriverManager.getConnection(url,user,pass);
		String sql = "SELECT * FROM customer WHERE NAME = ?";
		
		st = con.prepareStatement(sql);
		st.setString(1,name);
		
		rs = st.executeQuery();
		
		if(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장	// primary => if
			vo.setCustName(rs.getString("NAME"));
			vo.setCustTel1(rs.getString("TEL"));
			vo.setCustTel2(rs.getString("S_TEL"));
			vo.setCustAddr(rs.getString("ADDR"));
			vo.setCustEmail(rs.getString("EMAIL"));
		}
		
		return vo;
		
		}finally {
		rs.close();
		st.close();
		con.close();
		}
	}
}
