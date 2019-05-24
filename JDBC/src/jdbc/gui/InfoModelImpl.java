package jdbc.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.oracle2.UpdateTest2;


public class InfoModelImpl implements InfoModel {
	String driver =  "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String user = "mine";
	String pass = "1234";
	Connection con =  null ;

	public InfoModelImpl () throws Exception{
		// 1.  드라이버를 메모리 로딩
		Class.forName(driver);

	}
	public void insert(InfoVO vo) throws Exception {
		// 2. 연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);

		//			3. sql 문장 만들기(*******)
		String sql = "INSERT INTO INFOEX (NAME, ID, TEL, SEX, AGE, HOME)  VALUES(?,?,?,?,?,?)";
		System.out.println(sql);

		//			4. sql 전송 객체 얻어오기 (PreparedStatement : 미완성 SQL)
		PreparedStatement st = 	con.prepareStatement(sql);
		st.setString(1, vo. name);
		st.setString(2, vo.id);
		st.setString(3, vo.tel);
		st.setString(4,vo.gender);
		st.setInt(5,vo. age);
		st.setString(6, vo.home);

		//			5. SQL 전송 : int executeUpdate()
		int result = st.executeUpdate();

		//			[6. 결과처리]
		System.out.println(result + "행 SQL전송 성공");
		//			7. 닫기 (연결 닫기 매우중요**)
		st.close();
		con.close();		
	}
	public ArrayList<InfoVO> selectAllData() throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);

			//			3. sql 문장 만들기(*******)
			String sql = "SELECT * FROM  INFOEX ";

			//			4. sql 전송 객체 얻어오기 (PreparedStatement : 미완성 SQL)
			st = 	con.prepareStatement(sql);

			//			5. SQL 전송 : int executeUpdate()
			rs = st.executeQuery();

			//			[6. 결과처리]
			ArrayList<InfoVO> list = new ArrayList<InfoVO>();
			while(rs.next()) {
				InfoVO vo= new InfoVO();
				vo.setName(rs.getString("NAME"));
				vo.setId(rs.getString("ID"));
				vo.setTel(rs.getString("TEL"));
				vo.setGender(rs.getString("SEX"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
				list.add(vo);
			}
			return list;
		}finally {
			//			7. 닫기 (연결 닫기 매우중요**)
			rs.close();
			st.close();
			con.close();
		}		
	}
	public InfoVO selectByTel(String tel)  throws SQLException{
		InfoVO vo = new InfoVO(); 

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);		

			//			3. sql 문장 만들기(*******)
			String sql = "SELECT * FROM INFOEX WHERE TEL=?";

			//			4. sql 전송 객체 얻어오기 (PreparedStatement : 미완성 SQL)
			st = con.prepareStatement(sql);
			st.setString(1, tel);

			//			5. SQL 전송 : int executeQuery()
			rs = st.executeQuery();

			//			[6. 결과처리]
			if(rs.next()) {
				vo.setName(rs.getString("NAME"));
				vo.setId(rs.getString("ID"));
				vo.setTel(rs.getString("TEL"));
				vo.setGender(rs.getString("SEX"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
			}
			return vo;
		}finally {
			//		7. 닫기 (연결 닫기 매우중요**)
			rs.close();
			st.close();
			con.close();
		}		
	}
	public InfoVO selectById(String id)  throws SQLException{
		InfoVO vo = new InfoVO(); 

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);		

			//				3. sql 문장 만들기(*******)
			String sql = "SELECT * FROM INFOEX WHERE ID=?";

			//				4. sql 전송 객체 얻어오기 (PreparedStatement : 미완성 SQL)
			st = con.prepareStatement(sql);
			st.setString(1, id);

			//				5. SQL 전송 : int executeQuery()
			rs = st.executeQuery();

			//			[6. 결과처리]
			if(rs.next()) {
				vo.setName(rs.getString("NAME"));
				vo.setId(rs.getString("ID"));
				vo.setTel(rs.getString("TEL"));
				vo.setGender(rs.getString("SEX"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
			}
			return vo;
		}finally {
			//		7. 닫기 (연결 닫기 매우중요**)
			rs.close();
			st.close();
			con.close();
		}		
	}

	public void modify(InfoVO vo)  throws SQLException{

		Connection con = null;
		PreparedStatement st = null;

		// 2. 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);		

		//				3. sql 문장 만들기(*******)
		String sql = "UPDATE  INFOEX  SET  NAME = ? , ID = ?, TEL = ?, SEX = ?, AGE = ?, HOME = ?  WHERE TEL=?";

		//				4. sql 전송 객체 얻어오기 (PreparedStatement : 미완성 SQL)
		st = con.prepareStatement(sql);
		st.setString(1, vo. name);
		st.setString(2, vo.id);
		st.setString(3, vo.tel);
		st.setString(4,vo.gender);
		st.setInt(5,vo. age);
		st.setString(6, vo.home);
		st.setString(7,vo.tel);

		int result = st.executeUpdate();
		System.out.println( result + "업데이트 성공");

		//		7. 닫기 (연결 닫기 매우중요**)
		st.close();
		con.close();

	}
	public void delete(String tel) throws Exception {
		// 2. 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);		

		//				3. sql 문장 만들기(*******)
		String sql = "DELETE INFOEX   WHERE TEL=?";
		System.out.println(sql);

		//				4. sql 전송 객체 얻어오기 (PreparedStatement : 미완성 SQL)
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);

		//				5. SQL 전송 : int executeUpdate()
		int result  = st.executeUpdate();
		System.out.println(result + "삭제성공");

		//		7. 닫기 (연결 닫기 매우중요**)
		st.close();
		con.close();
	}		
}


