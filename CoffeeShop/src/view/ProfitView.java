package view;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.SalesDao;
import model.dao.SalesModel;
import view.SalesView.SalesTableModel;



public class ProfitView extends JPanel {
	
	JTable		tableProfit; //VIEW 역할
	
	SalesTableModel ProfitTM;
	SalesModel db;

	public ProfitView() {
		addLayout();	//화면구성
		eventProc();	//DB연결
		connectDB();
	}

	// 이벤트 등록
		public void eventProc(){
		
		
	}


	// DB 연결
	void connectDB(){
		try {
			db = new SalesModel();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	void addLayout() {
		// 멤버변수 객체 생성
		tableProfit = new JTable();

		ProfitTM = new SalesTableModel();
		tableProfit = new JTable(ProfitTM);
		
		
		
		
		
		// 화면 왼쪽
		JPanel p_west = new JPanel();
		p_west.setLayout(new BorderLayout());


		// 화면 왼쪽 위
		JPanel p_west_center = new JPanel();
		p_west_center.setBorder(new TitledBorder("월 별 인기 상품"));
		
		

		// 화면 왼쪽 아래
		JPanel p_west_south = new JPanel();	
		p_west_south.setBorder(new TitledBorder("일 별 인기 상품"));

		p_west.setLayout(new GridLayout(2,1));
		p_west.add(p_west_center, BorderLayout.CENTER);
		p_west.add(p_west_south, BorderLayout.SOUTH);

		// 화면 오른쪽
		JPanel p_east = new JPanel();
		p_east.setBorder(new TitledBorder("매출리스트"));
		p_east.setLayout(new BorderLayout());
		
		// 화면 오른쪽 위에
		JPanel p_east_north = new JPanel();	
		p_east.add(p_east_north,BorderLayout.NORTH);
		p_east.add(new JScrollPane(tableProfit),BorderLayout.CENTER);

		//전체영역에 붙이기
		setLayout(new GridLayout(1,2));
		add(p_west);
		add(p_east);
	}

	class SalesTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"상품명", "상품개수", "가격", "매출", "판매일"};

		//=============================================================
		// 1. 기본적인 TabelModel  만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() { 
			return columnNames.length; 
		} 

		public int getRowCount() { 
			return data.size(); 
		} 

		public Object getValueAt(int row, int col) { 
			ArrayList temp = (ArrayList)data.get( row );
			return temp.get( col ); 
		}

		public String getColumnName(int col){
			return columnNames[col];
		}

	
	}
}