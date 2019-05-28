package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.InventoryDao;
import model.vo.Inventory;

public class InventoryModel implements InventoryDao{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.161:1521:orcl";
	String user = "dbtry";
	String pass = "dbtry";
	Connection con = null;

	public InventoryModel() throws Exception{

		// 1. 드라이버로딩
		OracleCon.getInstance();

	}

	public void insertInventory(Inventory vo, int count) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "INSERT INTO Inventory(IVNUM,PNAME,PRICE,EXDATE) "
				+ "  VALUES(SEQ_IVNUM.nextval,?,?,?)";
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,vo.getInventoryNo());	 
		st.setString(2,vo.getInventoryPname());
		st.setInt(3,vo.getPrice());

		for (int i = 0; i<count; i++) {
			// 5. sql 전송
			int result = st.executeUpdate();

		}
		// 6. 닫기
		st.close();
		con.close();
	}

	public ArrayList searchInventory(int sel, String word) throws Exception {
		con = DriverManager.getConnection(url,user,pass);
		PreparedStatement st = null;
		ResultSet rs = null;

		//2.연결 객체 
		try {
			String [] cols = {"PNAME","PRICE"};
		
			
			//3.SQL 문장 SELECT * FROM 테이블명  WHERE 감독 LIKE '%봉%'
			String sql = "SELECT IVNUM, PNAME, PRICE, TO_CHAR(EXDATE,' YY / MM / DD ') EXDATE FROM INVENTORY " 
					+ " WHERE " + cols[sel] + "  LIKE '%"+word+"%' ";
			System.out.println(sql);
			ArrayList list = new ArrayList();
			//4.SQL 전송객체 얻어오기
			st = con.prepareStatement(sql);
			//5.SQL 전송 ( executeQuery())
			rs = st.executeQuery();
			//6.결과처리
			while(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장
				ArrayList data = new ArrayList();
				//data에 각 컬럼에서 얻어 온 갑을 추가
				data.add(rs.getInt("IVNUM"));
				data.add(rs.getString("PNAME"));
				data.add(rs.getInt("PRICE"));
				data.add(rs.getString("EXDATE"));

				//7.닫기
				list.add(data);


			}
			return list;
		}finally {
			rs.close();
			st.close();
			con.close();
		}
	}
	
	public ArrayList shortInP() throws Exception {
		con = DriverManager.getConnection(url,user,pass);
		ResultSet rs = null;
		PreparedStatement st = null;
		ArrayList list = new ArrayList();
		String sql ="SELECT PNAME , PCOUNT "
				+ "  FROM INVENTORY  " 
				+ "  WHERE PCOUNT<=15  " 
				+ "  GROUP BY PNAME, PCOUNT " ;
		
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		while(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장
			ArrayList data = new ArrayList();
			//data에 각 컬럼에서 얻어 온 갑을 추가
			data.add(rs.getString("PNAME"));
			data.add(rs.getInt("PCOUNT"));
//			data.add(rs.getString("TEL"));
//			data.add(rs.getString("RENTDAY"));
//			data.add(rs.getString("AVAILABLE"));

			//7.닫기
			list.add(data);

		}
		return list;
	}
	public ArrayList comeExdate() throws Exception {
		con = DriverManager.getConnection(url,user,pass);
		ResultSet rs = null;
		PreparedStatement st = null;
		ArrayList list = new ArrayList();
		String sql ="SELECT IVNUM, PNAME, ROUND(EXDATE-SYSDATE) LEFT  "
				+ "  FROM INVENTORY  " 
				+ "  WHERE ROUND(EXDATE-SYSDATE)<=7 " ;
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		while(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장
			ArrayList data = new ArrayList();
			//data에 각 컬럼에서 얻어 온 갑을 추가
			data.add(rs.getInt("IVNUM"));
			data.add(rs.getString("PNAME"));
//			data.add(rs.getString("NAME"));
			data.add(rs.getString("LEFT"));
//			data.add(rs.getString("RENTDAY"));
//			data.add(rs.getString("AVAILABLE"));

			//7.닫기
			list.add(data);

		}
		return list;
	}
	 


	public Inventory selectByPK(int vNum) throws Exception {
		Inventory vo = new Inventory();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,user,pass);
			String sql = "SELECT IVNUM, PNAME, PRICE,TO_CHAR(EXDATE,' YY / MM / DD ') EXDATE FROM Inventory WHERE IVNUM = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, vNum); 
			rs = st.executeQuery();
			while(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장	// primary => if
				vo.setInventoryNo(rs.getInt("IVNUM"));
				vo.setInventoryPname(rs.getString("PNAME"));
				vo.setPrice(Integer.parseInt(rs.getString("PRICE")));
				vo.setExdate(rs.getString("EXDATE"));
			}

			return vo;
		}finally {	// finally사용하여 반드시 실행	// 앞에 return있어도 finally는 무조건 실행
			rs.close();
			st.close();
			con.close();
		}

	}


	public void modifyInventory(Inventory vo) throws Exception {
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "UPDATE INVENTORY SET PNAME=?, PRICE=?, EXDATE=? WHERE IVNUM=?";
   
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,vo.getInventoryPname());
		st.setInt(2,vo.getPrice());
		st.setString(3,vo.getExdate());
		st.setInt(4,vo.getInventoryNo());
		st.executeUpdate();
	
		// 6. 닫기
		st.close();
		con.close();
	}

	public void deleteInventory(String vnum) throws Exception {
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "DELETE FROM INVENTORY "
				+ "  WHERE IVNUM=? ";

		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,vnum);	 
		st.executeUpdate();
		// 6. 닫기
		st.close();
		con.close();

	}

	
}