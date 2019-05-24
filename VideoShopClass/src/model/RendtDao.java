package model;

import java.util.ArrayList;

public interface RendtDao {
	//대여메소드
	public void rentVideo(String tel, int vnum) throws Exception;
	//반납메소드
	public int returnVideo(int vnum) throws Exception;
	//미납정보 검색 메소드
	public ArrayList selectList() throws Exception;
}
