package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

public interface  InfoModel {
	
	
	public void insert(InfoVO vo) throws Exception ;
	public ArrayList<InfoVO> selectAllData() throws SQLException;
	public InfoVO selectByTel(String tel)  throws SQLException;
	

}
