package transection;

import java.sql.*;
public class AccLogic 
{
	// 연결 객체 생성시 필요한 변수 선언
	String url;
	String user;
	String pass;

	//===============================================
	// 드라이버를 드라이버매니저에 등록
	public AccLogic() throws Exception{
		/////////////////////////////////////////////////////////
		// 1. 드라이버를 드라이버 매니저에 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		user = "mine";
		pass = "1234";
	}


	//====================================================
	// 보내는 계좌번호와 받는 계좌번호와 계좌금액을 넘겨받아 
	//	보내는계좌에서 계좌금액을 빼고 받는계좌에서 계좌금액을 더한다
	public int moveAccount(String sendAcc, String recvAcc, int amount) throws SQLException {

		///////////////////////////////////////////////////////////
		//	 1. Connection 객체 생성
		Connection con = null;

		//@@ 2. Auto-commit을 해제
		con.setAutoCommit(false);
		
		try {

			//	 3. 출금계좌에서 이체금액을 뺀다
			String sql1 = "UPDATE accont SET amount = amount-? WHERE account_num=?";
			//@@ 5. commit을 전송한다
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setInt(1,amount);
			st1.setString(2,sendAcc);
			int re1 = st1.executeUpdate();
			if(re1!=1) {
				con.rollback();
				return-1;
			}
			
			con.commit();

			//	 4. 입금계좌에 이체금액을 더한다
			String sql2 = "UPDATE accont SET amount = amount+? WHERE account_num=?";
			//@@ 5. commit을 전송한다
			PreparedStatement st2 = con.prepareStatement(sql2);
			st2.setInt(2, amount);
			st2.setString(2, recvAcc);
			int re2 = st2.executeUpdate();
			if(re2!=1) {
				con.rollback();
				return-1;
			}
			con.commit();
			
			//	 6. 객체 닫기
			st2.close();
			st1.close();
			con.close();

			//	 - 만일 정상적인 경우는 0을 리턴하고 도중에 잘못되었으면 트랜잭션을 롤백시키고 -1을 리턴
		} catch (Exception e) {
			con.rollback();
			return-1;
		}
		return 0;


	}

	//=======================================================
	//	보내는계좌번호와 받는계좌번호를 넘겨받아
	//		보내는계좌고객명과 보내는계좌의남은 금액을 얻어오고
	//		받는계좌고객명을 얻어와서
	//		얻은 정보를 ConfirmData객체에 넣고 리턴
	public ConfirmData confirmAccount(String sendAcc, String recvAcc) 
			throws Exception{


		String sendCust="", recvCust="";
		int gainMoney=0;
		ConfirmData  resultData=null;

		//	1. Connection 객체 생성
		//	2. 테이블에서, 넘겨받은 sendAcc와 같은 account_num필드에서 customer, amount를 얻어온다
		//	3. 테이블에서, 넘겨받은 recvAcc와 같은 account_num필드에서 customer를 얻어온다
		//  4. 2와 3에서 얻은 값을 ConfirmData 객체에 저장
		//	5. 4번의 객체를 리턴



		return resultData;
	}

}


//#################################################################
//	테이블명 : account
//	account_num		계좌번호		varchar2(20)
//	customer		고객명			varchar2(20)
//	amount			계좌금액		int
