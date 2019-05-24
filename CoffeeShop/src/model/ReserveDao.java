package model;

import model.vo.Reserve;

/** 고객관리 JDBC 연결 */
public interface ReserveDao {
	public void insertCustomer(Reserve vo) throws Exception;		// 회원가입
	public int updateCustomer(Reserve vo) throws Exception;		// 고객정보 수정
	public void deleteCustomer(String ccustTel) throws Exception;	
	public Reserve selectByTel(String ccustTel) throws Exception;	// 전화번호로 검색
	
}
