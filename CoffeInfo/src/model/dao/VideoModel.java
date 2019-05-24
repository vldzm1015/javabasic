package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import model.CoffeDao;
import model.vo.Inventory;

public class VideoModel implements CoffeDao{
	
	  String driver = "oracle.jdbc.driver.OracleDriver";
	   String url ="jdbc:oracle:thin:@192.168.0.161:1521:orcl";
	   String user = "dbtry";
	   String pass = "dbtry";
	
	public VideoModel() throws Exception{
		
		  // 1. 드라이버로딩
	      Class.forName(driver);

		
	}

	public void insertVideo(Inventory vo, int count) throws Exception{
		// 2. Connection 연결객체 얻어오기
		   Connection con = DriverManager.getConnection(url, user, pass);
		   
		// 3. sql 문장 만들기
		   String sql = "INSERT INTO CUSTOMER(videoNo, genre , videoName , director , actor , exp) VALUES (?,?,?,?,?,?)";
		   
		// 4. sql 전송객체 (PreparedStatement)		
		// 5. sql 전송
		// 6. 닫기
	}
	

}
