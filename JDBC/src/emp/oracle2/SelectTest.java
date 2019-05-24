package emp.oracle2;

import java.sql.*;

public class SelectTest {
	public static void main(String[] args) {
		String driver =  "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String pass = "tiger";
		Connection con =  null ;
		try {
			// 1.  드라이버를 메모리 로딩
			Class.forName(driver);
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패 " + e.getMessage());
		}
		
		
		
//		try {
//		// 3. SQL 문장만들기
//			int empno = 7788;
//			String sql = "SELECT * FROM emp WHERE empno=?";
		
//			// 4. SQL 전송객체 만들기
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, empno);
			
//		// 5. 전송하기
//			//  보안을 위해 PreparedStatement사용권장
//			ResultSet rs = st.executeQuery(); // <-----   *sql 지정하면 안됨*
//			while(rs.next()) {
//				System.out.println(rs.getInt("EMPNO")+"/"
//						+ rs.getString("ENAME") +"/" + rs.getInt("SAL"));
//			}
		
//		// 6. 닫기
//			st.close();
//			con.close();
//			System.out.println("연결성공");
//		} catch (Exception ex) {
//			System.out.println("전송실패"+ ex.getMessage());
//		}
		
		try {
			// 사원테이블의 총 사원수와 월급의 평균을 출력하세요
			int empno= 0;
			String sql = "SELECT count(*)  count , avg(sal) avg  FROM emp";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("count") +"/"+ rs.getInt("avg"));
			}
			rs.close();
			st.close();
		con.close();
		} catch (Exception ex) {
			System.out.println("전송실패"+ ex.getMessage());
		}
	}
}
