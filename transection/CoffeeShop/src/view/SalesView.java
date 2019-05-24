package  view;

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

import model.dao.SalesModel;



public class SalesView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;

	JTextField tfReturnVideoNum;
	JButton bReturn;

	JTable tableRecentList;

	RentTableModel rentTM;
	SalesModel db;


	//==============================================
	//	 생성자 함수
	public SalesView(){
		addLayout();	//화면구성
		eventProc();	//DB연결
		connectDB();
		
		selectNonReturn();
	}

	// DB 연결
	void connectDB(){
		try {
			db = new SalesModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/*	화면 구성   */
	void addLayout(){
		// 멤버변수 객체 생성
		tfRentTel = new JTextField(20);
		tfRentCustName = new JTextField(20);
		tfRentVideoNum = new JTextField(20);
		tfReturnVideoNum = new JTextField(10);

		bRent = new JButton("대여");
		bReturn = new JButton("반납");

		tableRecentList = new JTable();

		rentTM=new RentTableModel();
		tableRecentList = new JTable(rentTM);

		// ************* 화면구성 *****************
		// 화면의 윗쪽
		JPanel p_north = new JPanel();
		p_north.setLayout(new GridLayout(1,2));
		// 화면 윗쪽의 왼쪽
		JPanel p_north_1 = new JPanel();
		p_north_1.setBorder(new TitledBorder("대		여"));
		p_north_1.setLayout(new GridLayout(4,2));
		p_north_1.add(new JLabel("전 화 번 호"));
		p_north_1.add(tfRentTel);
		p_north_1.add(new JLabel("고 객 명"));
		p_north_1.add(tfRentCustName);
		p_north_1.add(new JLabel("비디오 번호"));
		p_north_1.add(tfRentVideoNum);
		p_north_1.add(bRent);



		// 화면 윗쪽의 오른쪽
		JPanel p_north_2 = new JPanel();	
		p_north_2.setBorder(new TitledBorder("반		납"));
		p_north_2.add(new JLabel("비디오 번호"));
		p_north_2.add(tfReturnVideoNum);
		p_north_2.add(bReturn);

		//
		setLayout(new BorderLayout());
		add(p_north, BorderLayout.NORTH);
		add(new JScrollPane(tableRecentList),BorderLayout.CENTER);


		p_north.add(p_north_1);
		p_north.add(p_north_2);
	}

	class RentTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목","고객명","전화번호","반납예정일","반납여부"};

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
	
	// 이벤트 등록
	public void eventProc(){
		ActionHandler ah = new ActionHandler();
		tfRentTel.addActionListener(ah);
		bRent.addActionListener(ah);
		bReturn.addActionListener(ah);
	}
	
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("이벤트");
			Object evt = e.getSource();
			if (evt == tfRentTel) {
				selectCustName();
			} else if (evt == bRent) {
				rentVideo();
				selectNonReturn();
			} else if(evt == bReturn) {
				returnVideo();
				selectNonReturn();
			}
			
		}
	}
	
	//전화 입력 후 엔터치면 고객명을 출력하는 메소드
	public void selectCustName() {
		
	}
	//비디오 반납시 처리하는 메소드
	public int returnVideo() {
		//1.화면에서 필요한 정보를 얻어오기
		int vnum = Integer.parseInt(tfReturnVideoNum.getText());
		try {
			db.returnVideo(vnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	// 비디오 대여시 처리하는 메소드
	public void rentVideo() {
		//1.화면에서 필요한 정보를 얻어오기
		//2.모델쪽 메소드 호출
		//3. 대여 후 결과처리
		String tel = tfRentTel.getText();
		int vnum = Integer.parseInt(tfRentVideoNum.getText());
		
		try {
			db.rentVideo(tel, vnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//미납목록 출력하는 메소드
	public void selectNonReturn() {
		
		try {
		rentTM.data=db.selectList();
		rentTM.fireTableDataChanged();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
