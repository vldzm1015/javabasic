package emp.oracle2;

import java.sql.*;

public class InsertTest {

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
			String ename = "하하하";
			int sal = 9800;
			int deptno = 30;
			String job = "IT부서";
			
//			String sql = "INSERT INTO emp(empno, ename, sal, deptno, job)"
//					 + "VALUES("+empno+", ' " +ename+ " ' ,  " + sal+ ", " + deptno + ", "
//					+ " ' " +job + " ' ) "; 
			// 짧게 변형
			String sql = "INSERT INTO emp(empno, ename, sal, deptno, job)"
					 + "VALUES(?,?,?,?,? ) "; 
			System.out.println(sql);
			
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, empno);
			st.setString(2,  ename);
			st.setInt(3, sal);
			st.setInt(4, deptno);
			st.setString(5,job);
			
			//int result = st.executeUpdate(sql);
			int result =  st.executeUpdate();    // <--------sql 전송하면 안됨
			st.close();
			con.close();
			System.out.println(result + "행 SQL전송 성공");
		} catch (Exception ex) {
			System.out.println("전송실패"+ ex.getMessage());
		}
	}

}
