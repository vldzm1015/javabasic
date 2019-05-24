package model;

import model.vo.Reserve;

/** 고객관리 JDBC 연결 */
public interface ReserveDao {
	public void insertCustomer(Reserve vo) throws Exception;		// 회원가입
	public Reserve selectByTel(String tel) throws Exception;	
	public Reserve selectByName(String name) throws Exception;	// 전화번호로 검색
	public int updateCustomer(Reserve vo) throws Exception;		// 고객정보 수정
}
