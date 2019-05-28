package	 view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.InventoryModel;
import model.vo.Inventory;


public class InventoryView extends JPanel 
{	
	//	member field
	JTextField	tfInventoryIvnum, tfInventoryPname, tfInventoryPrice, tfInventoryExdate;
	JComboBox	comInventoryPname;
//	JTextArea	taInventoryContent;

	JCheckBox	cbMultiInsert;
	JTextField	tfInsertCount;

	JButton		bInventoryInsert, bInventoryModify, bInventoryDelete;

	JComboBox	comInventorySearch;
	JTextField	tfInventorySearch;
	JTable		tableInventory; //VIEW 역할
	JTable 		tableInventoryU;
	JTable 		tableInventoryD;
	
	InventoryTableModel tbModelInventory; //MODEL 역할
	InventoryTableModelU tbModelInventoryU; //MODEL 역할
	InventoryTableModelD tbModelInventoryD; //MODEL 역할
	
	//비지니스 로직 = 모델 클래스 변수 선언
	InventoryModel db;
	
	
	//##############################################
	//	constructor method
	public InventoryView(){
		addLayout(); 	// 화면설계
		initStyle();
		eventProc();
		connectDB();	// DB연결
		representU();
		representB();
	}
	
	public void connectDB(){	// DB연결
		try {
			db = new InventoryModel();
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
		
	}
	
	public void eventProc(){
		ButtonEventHandler hdlr = new ButtonEventHandler();
		bInventoryInsert.addActionListener(hdlr);
		bInventoryModify.addActionListener(hdlr);
		bInventoryDelete.addActionListener(hdlr);
		tfInventorySearch.addActionListener(hdlr);
		cbMultiInsert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tfInsertCount.setEditable(cbMultiInsert.isSelected());
				
			}
		});
		
		//JTable 인벤토리 검색에서 클릭 했을 때
		
		tableInventory.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = tableInventory.getSelectedRow();
				int vNum = (Integer)tableInventory.getValueAt(row, col);
				//JOptionPane.showMessageDialog(null, vNum);
				
				//1.선택한 인벤토리 번호를 모델단의 selectByPK() 호출 시 인자로 보내기
				//2. 넘겨 받은 Inventory 에서 해당 값들 화면 출력하기
				try {
					Inventory vo = db.selectByPK(vNum);
					tfInventoryIvnum.setText(String.valueOf(vo.getInventoryNo()));
//					tfInventoryPname.setText(vo.getInventoryPname());
					tfInventoryPrice.setText(String.valueOf(vo.getPrice()));
					tfInventoryExdate.setText(vo.getExdate());
//					taInventoryContent.setText(vo.getExp());
					comInventoryPname.setSelectedItem(vo.getInventoryPname());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Inventory 정보 출력 실패");
					e1.getMessage();
					e1.printStackTrace();
				}
				//나머지도
			}
		});
	}		
	
	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			
			if(o==bInventoryInsert){  
				registInventory();					// 인벤토리 등록
			}
			else if(o==bInventoryModify){  
				modifyInventory();					// 인벤토리 정보 수정
			}
			else if(o==bInventoryDelete){  
				deleteInventory();					// 인벤토리 정보 삭제
			}
			else if(o==tfInventorySearch){
				searchInventory();					// 인벤토리 검색
			}
		}
	}
	
	// 입고 클릭시  - 인벤토리 정보 등록
	public void registInventory(){
		 //JOptionPane.showMessageDialog(null, "입고");
		//1.화면의 입력 및 선택 값들 얻어오기-->vo 객체로 생성
		Inventory vo = new Inventory();
		vo.setInventoryPname(tfInventoryPname.getText());
		vo.setPrice(Integer.parseInt(tfInventoryPrice.getText()));
		vo.setExdate(tfInventoryExdate.getText());
		vo.setInventoryPname((String)comInventoryPname.getSelectedItem());
//		vo.setExp(taInventoryContent.getText());
		
		int count = Integer.parseInt(tfInsertCount.getText());
		//2.모델단의 메소드 1번 값들 전송
		try {
			db.insertInventory(vo, count);
			clearTextField();
			searchInventory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initStyle(){   // 입력하지 못하게 만듬.
		tfInventoryIvnum.setEditable(false);
		tfInsertCount.setEditable(false);		
		tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
	}
	
	// 수정 클릭시 - 인벤토리 정보 수정
	public void modifyInventory(){

//		JOptionPane.showMessageDialog(null, "수정");
		Inventory vo = new Inventory();
		vo.setInventoryNo(Integer.parseInt(tfInventoryIvnum.getText()));
//		vo.setInventoryPname(tfInventoryPname.getText());
		vo.setExdate(tfInventoryExdate.getText());
		vo.setInventoryPname((String)comInventoryPname.getSelectedItem());
//		vo.setExp(taInventoryContent.getText());
		
		//2.모델단의 메소드 1번 값들 전송
		try {
			db.modifyInventory(vo);
			clearTextField();
			searchInventory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void clearTextField() {
		tfInventoryIvnum.setText(null);
		tfInventoryPrice.setText(null);
		tfInventoryPname.setText(null);
		tfInventoryExdate.setText(null);
//		taInventoryContent.setText(null);
	}
	
	// 삭제 클릭시 - 인벤토리 정보 삭제
	public void deleteInventory(){
		
//		JOptionPane.showMessageDialog(null, "삭제");
		//tfInventoryNum.setEditable(true);
		String vnum = tfInventoryIvnum.getText();
		//int count = Integer.parseInt(tfInsertCount.getText());
		try {
			db.deleteInventory(vnum);
			clearTextField();
			searchInventory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 인벤토리현황검색
		public void searchInventory(){
//			JOptionPane.showMessageDialog(null, "검색");
			int sel = comInventorySearch.getSelectedIndex();
			String word = tfInventorySearch.getText();
			try {
				tbModelInventory.data = db.searchInventory(sel, word);
				tbModelInventory.fireTableDataChanged();
			} catch (Exception e) {
				System.out.println("검색실패:"+e.getMessage());
			}
		}
		
	public void representU()
	{
		// 모델단 함수를 호출하여 DB 값 가져옴
		// 화면 JTableModel의 data 로 지정
		// fireXXXX
		
		try {
			tbModelInventoryU.data = db.shortInP();
			tbModelInventoryU.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("검색실패:"+e.getMessage());
		}
		
	}
	public void representB()
	{
		// 모델단 함수를 호출하여 DB 값 가져옴
		// 화면 JTableModel의 data 로 지정
		// fireXXXX
		try {
			tbModelInventoryD.data = db.comeExdate();
			tbModelInventoryD.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("검색실패:"+e.getMessage());
		}
		
	}
	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		tfInventoryIvnum = new JTextField();
		tfInventoryPname = new JTextField();
		tfInventoryPrice = new JTextField();
		tfInventoryExdate = new JTextField();
		
		String []cbJanreStr = {"아메리카노","카페라떼", "바닐라라떼", "초코라떼", "녹차라떼",
		         "밀크티"," 치즈케이크", "티라미수", "허니브래드", "초코쿠키", "버터쿠키", "샌드위치"};
		comInventoryPname = new JComboBox(cbJanreStr);
//		taInventoryContent = new JTextArea();
		
		cbMultiInsert = new JCheckBox("입고수량");
		tfInsertCount = new JTextField("1",5);
	
		bInventoryInsert = new JButton("입고");
		bInventoryModify = new JButton("수정");
		bInventoryDelete = new JButton("삭제");
		
		String []cbInventorySearch = {"상품명","가격"};
		comInventorySearch = new JComboBox(cbInventorySearch);
		tfInventorySearch = new JTextField(15);
		
		tbModelInventory = new InventoryTableModel();
		tbModelInventoryU = new InventoryTableModelU();
		tbModelInventoryD = new InventoryTableModelD();
		tableInventory = new JTable(tbModelInventory);
		tableInventoryU = new JTable(tbModelInventoryU);
		tableInventoryD = new JTable(tbModelInventoryD);

		//*********************************************************************
		// 화면 구성
		// 왼쪽 영역
		JPanel p_west = new JPanel();
//		p_west.setBorder(new TitledBorder("왼쪽"));
		p_west.setLayout(new BorderLayout());
		//왼쪽 - 메인
		JPanel p_west_c = new JPanel();
		p_west_c.setLayout(new BorderLayout());
		p_west.add(p_west_c,BorderLayout.CENTER);
		
		//왼쪽 - 메인 - 중앙
		JPanel p_west_c_c = new JPanel();
		p_west_c_c.setBorder(new TitledBorder("재고 관리"));
		//인벤토리 정보 입력 부분
		JPanel p_w_c_c_1 = new JPanel();
		 p_w_c_c_1.setLayout(new GridLayout(4,1));
         p_w_c_c_1.add(new JLabel("재고번호"));
         p_w_c_c_1.add(tfInventoryIvnum);
         p_w_c_c_1.add(new JLabel("상품명"));
         p_w_c_c_1.add(comInventoryPname);
//         p_w_c_c_1.add(new JLabel("제목"));
//         p_w_c_c_1.add(tfInventoryTitle);
         p_w_c_c_1.add(new JLabel("가격"));
         p_w_c_c_1.add(tfInventoryPrice);
         p_w_c_c_1.add(new JLabel("유통기한"));
         p_w_c_c_1.add(tfInventoryExdate);

		
		//인벤토리 설명 부분
//		JPanel p_w_c_c_2 = new JPanel();
//		p_w_c_c_2.setLayout(new BorderLayout());
//		p_w_c_c_2.add(new JLabel("설명"), BorderLayout.WEST);
//		p_w_c_c_2.add(taInventoryContent, BorderLayout.CENTER);
		
		
//		p_west_c_c.setLayout(new GridLayout(2,1));
		p_west_c_c.setLayout(new BorderLayout());
		p_west_c_c.add(p_w_c_c_1,BorderLayout.CENTER);
//		p_west_c_c.add(p_w_c_c_2,BorderLayout.SOUTH);
		
		
		p_west_c.add(p_west_c_c,BorderLayout.CENTER);
		//왼쪽 - 메인 - 아래
		JPanel p_west_c_s = new JPanel();
//		p_west_c_s.setBorder(new TitledBorder("수량 입력"));
		p_west_c.add(p_west_c_s,BorderLayout.SOUTH);
		p_west_c_s.add(cbMultiInsert);
		p_west_c_s.add(tfInsertCount);
		p_west_c_s.add(new JLabel("개"));
		
		//왼쪽 - 버튼
		JPanel p_west_south = new JPanel();
		p_west_south.setLayout(new GridLayout(1,3));
		p_west_south.add(bInventoryInsert);
		p_west_south.add(bInventoryModify);
		p_west_south.add(bInventoryDelete);
		p_west.add(p_west_south, BorderLayout.SOUTH);
		
		
		// 오른쪽 영역
		JPanel p_east = new JPanel();
		
		JPanel p_east_bottom = new JPanel();
		p_east_bottom.setBorder(new TitledBorder("재고  현황 검색"));
		p_east_bottom.setLayout(new BorderLayout());
		
		JPanel p_east_b_south = new JPanel();
		p_east_b_south.add(comInventorySearch);
		p_east_b_south.add(tfInventorySearch);
		
		p_east_bottom.add(p_east_b_south,BorderLayout.NORTH);
		p_east_bottom.add(new JScrollPane(tableInventory),BorderLayout.CENTER);
		
		JPanel p_east_upper = new JPanel();
		p_east_upper.setLayout(new GridLayout(2,1));
		
		
		JPanel p_east_upper_u = new JPanel();
		p_east_upper_u.setLayout(new BorderLayout());
		p_east_upper_u.setBorder(new TitledBorder("재고 부족 상품"));
		p_east_upper_u.add(new JScrollPane(tableInventoryU),BorderLayout.CENTER);
		
		JPanel p_east_upper_b = new JPanel();
		p_east_upper_b.setLayout(new BorderLayout());
		p_east_upper_b.setBorder(new TitledBorder("유통기한 임박 상품"));
		p_east_upper_b.add(new JScrollPane(tableInventoryD),BorderLayout.CENTER);
		
		
		p_east_upper.add(p_east_upper_u);
		p_east_upper.add(p_east_upper_b);
		
		
		p_east.setLayout(new GridLayout(2,1));
		p_east.add(p_east_upper);
		p_east.add(p_east_bottom);
		
		//전체영역에 붙이기
		setLayout(new GridLayout(1,2));
		add(p_east);
		add(p_west);
		
		
		
	}
	
	//화면에 테이블 붙이는 메소드 
	class InventoryTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"재고번호","상품명","가격","유통기한"};

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
	//화면에 테이블 붙이는 메소드 
	class InventoryTableModelU extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"상품명","개수"};

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
	//화면에 테이블 붙이는 메소드 
	class InventoryTableModelD extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"재고번호","상품명","남은일수"};

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


