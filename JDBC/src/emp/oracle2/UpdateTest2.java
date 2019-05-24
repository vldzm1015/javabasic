package emp.oracle2;

import java.sql.*;

public class UpdateTest2 {

	public static void main(String[] args) {
		String driver =  "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String pass = "tiger";
		Connection con =null;
		try {
			// 1.  드라이버를 메모리 로딩
			Class.forName(driver);
			// 2. 연결객체 얻어오기
			 con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공");
		} catch (Exception ex) {
			System.out.println("연결실패 " + ex.getMessage());
		}
		// 3. SQL 문장만들기
		// 4. SQL 전송객체 만들기
		// 5. 전송하기
		// 6. 닫기
		try {
			// 화면에서 입력값 얻어오기
			int empno = 9877;
			String ename = "홍홍자";
			int sal = 15000;
			int deptno = 20;
			String job = "개발";
			
			// * sql 문장변경  *WHERE *
			String sql ="UPDATE emp set  ename=?, sal=?, deptno=?, job=?"+ " WHERE empno=?"; 
			System.out.println(sql);
			

			PreparedStatement st = con.prepareStatement(sql);
			// ?setting  *순서변경에 맞춰 순서 다시지정*
			st.setString(1,  ename);
			st.setInt(2, sal);
			st.setInt(3, deptno);
			st.setString(4,job);
			st.setInt(5, empno);

			int result =  st.executeUpdate();    // <--------sql 전송하면 안됨
			st.close();
			con.close();
			System.out.println(result + "행 SQL전송 성공");
		} catch (Exception ex) {
			System.out.println("전송실패"+ ex.getMessage());
		}
	}

}
