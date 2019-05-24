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

	public void insertVideo(Inventory vo, int count) throws Exception{
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "INSERT INTO VIDEO(V_NUM,TITLE,GENR,DIR,ACTOR,DIS) "
				+ "  VALUES(seq_video_num.nextval,?,?,?,?,?)";
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,vo.getVideoName());	 
		st.setString(2,vo.getGenre());
		st.setString(3,vo.getDirector());
		st.setString(4,vo.getActor());
		st.setString(5,vo.getExp());

		for (int i = 0; i<count; i++) {
			// 5. sql 전송
			int result = st.executeUpdate();

		}
		// 6. 닫기
		st.close();
		con.close();
	}

	public ArrayList searchVideo(int sel, String word) throws Exception {
		con = DriverManager.getConnection(url,user,pass);
		PreparedStatement st = null;
		ResultSet rs = null;

		//2.연결 객체 
		try {
			String [] cols = {"TITLE","DIR"};
			//3.SQL 문장 SELECT * FROM 테이블명  WHERE 감독 LIKE '%봉%'
			String sql = "SELECT V_NUM, TITLE, GENR, DIR, ACTOR FROM VIDEO " 
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
				data.add(rs.getInt("V_NUM"));
				data.add(rs.getString("TITLE"));
				data.add(rs.getString("GENR"));
				data.add(rs.getString("DIR"));
				data.add(rs.getString("ACTOR"));

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
//			data.add(rs.getString("NAME"));
			data.add(rs.getString("TEL"));
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
			String sql = "SELECT * FROM VIDEO WHERE V_NUM = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, vNum); 
			rs = st.executeQuery();
			while(rs.next()) {	// 반복문 실행될때마다 새로운 객체생성이므로 한번 실행시마다 만들어지는 객체를 ArrayList만들어 저장	// primary => if
				vo.setVideoNo(rs.getInt("V_NUM"));
				vo.setVideoName(rs.getString("TITLE"));
				vo.setGenre(rs.getString("GENR"));
				vo.setDirector(rs.getString("DIR"));
				vo.setActor(rs.getString("ACTOR"));
				vo.setExp(rs.getString("DIS"));
			}

			return vo;
		}finally {	// finally사용하여 반드시 실행	// 앞에 return있어도 finally는 무조건 실행
			rs.close();
			st.close();
			con.close();
		}

	}


	public void modifyVideo(Inventory vo) throws Exception {
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "UPDATE VIDEO SET TITLE=?, GENR=?, DIR=?, ACTOR=?, DIS=?  WHERE V_NUM=?";
   
		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,vo.getVideoName());	 
		st.setString(2,vo.getGenre());
		st.setString(3,vo.getDirector());
		st.setString(4,vo.getActor());
		st.setString(5,vo.getExp());
		st.setInt(6,vo.getVideoNo());
		st.executeUpdate();
	
		// 6. 닫기
		st.close();
		con.close();
	}

	public void deleteVideo(String vnum) throws Exception {
		// 2. Connection 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "DELETE FROM VIDEO "
				+ "  WHERE V_NUM=? ";

		// 4. sql 전송객체 (PreparedStatement)	
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,vnum);	 
		st.executeUpdate();
		// 6. 닫기
		st.close();
		con.close();

	}

	
}