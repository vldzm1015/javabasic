package model;

import java.util.ArrayList;

public interface SalesDao {
	//  결제메소드
	public void coffePay( ArrayList list) throws Exception;
	//  환불메소드
	public void coffereturn(ArrayList list) throws Exception;

}
