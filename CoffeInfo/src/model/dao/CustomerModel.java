package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao{

   String driver = "oracle.jdbc.driver.OracleDriver";
   String url ="jdbc:oracle:thin:@192.168.0.161:1521:orcl";
   String user = "dbtry";
   String pass = "dbtry";


   public CustomerModel() throws Exception{
      // 1. 드라이버로딩
      Class.forName(driver);

   }

   public void insertCustomer(Customer cvo) throws Exception{
      // 2. Connection 연결객체 얻어오기
      Connection con = DriverManager.getConnection(url, user, pass);
      // 3. sql 문장 만들기
      String sql = "INSERT INTO CUSTOMER(TEL,NAME,ADDR,EMAIL,S_TEL) VALUES (?,?,?,?,?)";
      System.out.println(sql);
      // 4. sql 전송객체 (PreparedStatement)      
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, cvo.getCustTel1());
      st.setString(2, cvo.getCustName());
      st.setString(3, cvo.getCustAddr());
      st.setString(4, cvo.getCustEmail());
      st.setString(5, cvo.getCustTel2());
      int result = st.executeUpdate();
      // 5. sql 전송
      // 6. 닫기 
      st.close();
      con.close();
   }

   public Customer selectByTel(String tel) throws Exception{
      Customer cvo = new Customer();
      String sql = "Select * from Customer where tel=?";

      Connection con = null;
      ResultSet rs=null;
      //4.SQL 전송 객체 얻어오기
      PreparedStatement st =null;
      //5.SQL 전송 
      try {
         //2. 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         //3. SQL 문장 만들기(******)
         st = con.prepareStatement(sql);
         st.setString(1, tel);
         rs = st.executeQuery();
         //6.결과처리
         if(rs.next()) {
            cvo.setCustTel1(rs.getString("TEL"));
            cvo.setCustName(rs.getString("NAME"));
            cvo.setCustAddr(rs.getString("ADDR"));
            cvo.setCustEmail(rs.getString("EMAIL"));
            cvo.setCustTel2(rs.getString("S_TEL"));
         }
         return cvo;
      }finally {
         rs.close();
         st.close();
         con.close();
      }

   }

   public int updateCustomer(Customer cvo) throws Exception{

      Connection con = DriverManager.getConnection(url, user, pass);
      //3. SQL 문장 만들기(******)
      String sql = "UPDATE Customer SET NAME=?, ADDR=?, EMAIL=?, S_TEL=?  "
            +  " WHERE tel = ?";
      System.out.println(sql);
      //4. SQL 전송 객체 얻어오기
      //-PreparedStatement : 미완성 sql
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, cvo.getCustName());
      st.setString(2, cvo.getCustAddr());
      st.setString(3, cvo.getCustEmail());
      st.setString(4, cvo.getCustTel2());
      st.setString(5, cvo.getCustTel1());
      //5. SQL 전송
      int result = st.executeUpdate();
      //6. 결과처리
      //7. 닫기
      st.close();
      con.close();
      return result;


   }

   public Customer selectByName(String name) throws Exception {
      Customer cvo = new Customer();
      String sql = "Select * from Customer where NAME=?";

      Connection con = null;
      ResultSet rs=null;
      //4.SQL 전송 객체 얻어오기
      PreparedStatement st =null;
      //5.SQL 전송 
      try {
         //2. 연결객체 얻어오기
         con = DriverManager.getConnection(url, user, pass);
         //3. SQL 문장 만들기(******)
         st = con.prepareStatement(sql);
         st.setString(1, name);
         rs = st.executeQuery();
         //6.결과처리
         if(rs.next()) {
            cvo.setCustTel1(rs.getString("TEL"));
            cvo.setCustName(rs.getString("NAME"));
            cvo.setCustAddr(rs.getString("ADDR"));
            cvo.setCustEmail(rs.getString("EMAIL"));
            cvo.setCustTel2(rs.getString("S_TEL"));
         }
         return cvo;
      }finally {
         rs.close();
         st.close();
         con.close();
      }
   }
}