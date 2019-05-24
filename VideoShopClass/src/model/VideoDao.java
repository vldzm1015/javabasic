package model;

import java.util.ArrayList;

import model.vo.Customer;
import model.vo.Video;

/** 고객관리 JDBC 연결 */
public interface VideoDao {
	public void insertVideo(Video vo, int count) throws Exception;		
	public ArrayList searchVideo(int sel, String word) throws Exception;
	public void modifyVideo(Video vo) throws Exception;
	public void deleteVideo(String vnum) throws Exception;
}
