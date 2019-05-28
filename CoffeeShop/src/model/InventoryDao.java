package model;

import java.util.ArrayList;

import model.vo.Reserve;
import model.vo.Inventory;

/** 고객관리 JDBC 연결 */
public interface InventoryDao {
	public void insertInventory(Inventory vo, int count) throws Exception;		
	public ArrayList searchInventory(int sel, String word) throws Exception;
	public ArrayList shortInP() throws Exception;
	public ArrayList comeExdate() throws Exception;
	public void modifyInventory(Inventory vo) throws Exception;
	public void deleteInventory(String vnum) throws Exception;
}
