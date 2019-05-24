package model;

import java.util.ArrayList;

public interface SalesDao {
	//  결제메소드
	public void rentVideo(String tel, int vnum) throws Exception;
	//  환불메소드
	public int returnVideo(int vnum) throws Exception;
	//  미납정보 검색 메소드
	public ArrayList selectList() throws Exception;
}
