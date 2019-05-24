package model;

import java.util.ArrayList;

import model.vo.Reserve;
import model.vo.Inventory;

/** 고객관리 JDBC 연결 */
public interface InventoryDao {
	public void insertVideo(Inventory vo, int count) throws Exception;		
	public ArrayList searchVideo(int sel, String word) throws Exception;
	public void modifyVideo(Inventory vo) throws Exception;
	public void deleteVideo(String vnum) throws Exception;
}
