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
	JTextField	tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
	JComboBox	comVideoJanre;
//	JTextArea	taVideoContent;

	JCheckBox	cbMultiInsert;
	JTextField	tfInsertCount;

	JButton		bVideoInsert, bVideoModify, bVideoDelete;

	JComboBox	comVideoSearch;
	JTextField	tfVideoSearch;
	JTable		tableVideo; //VIEW 역할
	JTable 		tableVideoU;
	JTable 		tableVideoD;
	
	VideoTableModel tbModelVideo; //MODEL 역할
	VideoTableModelU tbModelVideoU; //MODEL 역할
	VideoTableModelD tbModelVideoD; //MODEL 역할
	
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
		bVideoInsert.addActionListener(hdlr);
		bVideoModify.addActionListener(hdlr);
		bVideoDelete.addActionListener(hdlr);
		tfVideoSearch.addActionListener(hdlr);
		cbMultiInsert.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tfInsertCount.setEditable(cbMultiInsert.isSelected());
				
			}
		});
		
		//JTable 비디오 검색에서 클릭 했을 때
		tableVideo.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = tableVideo.getSelectedRow();
				int vNum = (Integer)tableVideo.getValueAt(row, col);
				//JOptionPane.showMessageDialog(null, vNum);
				
				//1.선택한 비디오 번호를 모델단의 selectByPK() 호출 시 인자로 보내기
				//2. 넘겨 받은 Video 에서 해당 값들 화면 출력하기
				try {
					Inventory vo = db.selectByPK(vNum);
					tfVideoNum.setText(String.valueOf(vo.getVideoNo()));
					tfVideoTitle.setText(vo.getVideoName());
					tfVideoDirector.setText(vo.getDirector());
					tfVideoActor.setText(vo.getActor());
//					taVideoContent.setText(vo.getExp());
					comVideoJanre.setSelectedItem(vo.getGenre());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("video 정보 출력 실패");
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
			
			if(o==bVideoInsert){  
				registVideo();					// 비디오 등록
			}
			else if(o==bVideoModify){  
				modifyVideo();					// 비디오 정보 수정
			}
			else if(o==bVideoDelete){  
				deleteVideo();					// 비디오 정보 삭제
			}
			else if(o==tfVideoSearch){
				searchVideo();					// 비디오 검색
			}
		}
	}
	
	// 입고 클릭시  - 비디오 정보 등록
	public void registVideo(){
		 //JOptionPane.showMessageDialog(null, "입고");
		//1.화면의 입력 및 선택 값들 얻어오기-->vo 객체로 생성
		Inventory vo = new Inventory();
		vo.setVideoName(tfVideoTitle.getText());
		vo.setDirector(tfVideoActor.getText());
		vo.setActor(tfVideoActor.getText());
		vo.setGenre((String)comVideoJanre.getSelectedItem());
//		vo.setExp(taVideoContent.getText());
		
		int count = Integer.parseInt(tfInsertCount.getText());
		//2.모델단의 메소드 1번 값들 전송
		try {
			db.insertVideo(vo, count);
			clearTextField();
			searchVideo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initStyle(){   // 입력하지 못하게 만듬.
		tfVideoNum.setEditable(false);
		tfInsertCount.setEditable(false);		
		tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
	}
	
	// 수정 클릭시 - 비디오 정보 수정
	public void modifyVideo(){

//		JOptionPane.showMessageDialog(null, "수정");
		Inventory vo = new Inventory();
		vo.setVideoNo(Integer.parseInt(tfVideoNum.getText()));
		vo.setVideoName(tfVideoTitle.getText());
		vo.setDirector(tfVideoActor.getText());
		vo.setActor(tfVideoActor.getText());
		vo.setGenre((String)comVideoJanre.getSelectedItem());
//		vo.setExp(taVideoContent.getText());
		
		//2.모델단의 메소드 1번 값들 전송
		try {
			db.modifyVideo(vo);
			clearTextField();
			searchVideo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void clearTextField() {
		tfVideoNum.setText(null);
		tfVideoDirector.setText(null);
		tfVideoTitle.setText(null);
		tfVideoActor.setText(null);
//		taVideoContent.setText(null);
	}
	
	// 삭제 클릭시 - 비디오 정보 삭제
	public void deleteVideo(){
		
//		JOptionPane.showMessageDialog(null, "삭제");
		//tfVideoNum.setEditable(true);
		String vnum = tfVideoNum.getText();
		//int count = Integer.parseInt(tfInsertCount.getText());
		try {
			db.deleteVideo(vnum);
			clearTextField();
			searchVideo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 비디오현황검색
		public void searchVideo(){
//			JOptionPane.showMessageDialog(null, "검색");
			int sel = comVideoSearch.getSelectedIndex();
			String word = tfVideoSearch.getText();
			try {
				tbModelVideo.data = db.searchVideo(sel, word);
				tbModelVideo.fireTableDataChanged();
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
			tbModelVideoU.data = db.shortInP();
			tbModelVideoU.fireTableDataChanged();
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
			tbModelVideoD.data = db.shortInP();
			tbModelVideoD.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("검색실패:"+e.getMessage());
		}
		
	}
	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		tfVideoNum = new JTextField();
		tfVideoTitle = new JTextField();
		tfVideoDirector = new JTextField();
		tfVideoActor = new JTextField();
		
		String []cbJanreStr = {"아메리카노","카페라떼","에스프레소","치즈케이크"};
		comVideoJanre = new JComboBox(cbJanreStr);
//		taVideoContent = new JTextArea();
		
		cbMultiInsert = new JCheckBox("입고수량");
		tfInsertCount = new JTextField("1",5);
	
		bVideoInsert = new JButton("입고");
		bVideoModify = new JButton("수정");
		bVideoDelete = new JButton("삭제");
		
		String []cbVideoSearch = {"상품명","유통기한"};
		comVideoSearch = new JComboBox(cbVideoSearch);
		tfVideoSearch = new JTextField(15);
		
		tbModelVideo = new VideoTableModel();
		tbModelVideoU = new VideoTableModelU();
		tbModelVideoD = new VideoTableModelD();
		tableVideo = new JTable(tbModelVideo);
		tableVideoU = new JTable(tbModelVideoU);
		tableVideoD = new JTable(tbModelVideoD);

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
		//비디오 정보 입력 부분
		JPanel p_w_c_c_1 = new JPanel();
		 p_w_c_c_1.setLayout(new GridLayout(4,1));
         p_w_c_c_1.add(new JLabel("재고번호"));
         p_w_c_c_1.add(tfVideoNum);
         p_w_c_c_1.add(new JLabel("상품명"));
         p_w_c_c_1.add(comVideoJanre);
//         p_w_c_c_1.add(new JLabel("제목"));
//         p_w_c_c_1.add(tfVideoTitle);
         p_w_c_c_1.add(new JLabel("가격"));
         p_w_c_c_1.add(tfVideoDirector);
         p_w_c_c_1.add(new JLabel("유통기한"));
         p_w_c_c_1.add(tfVideoActor);

		
		//비디오 설명 부분
//		JPanel p_w_c_c_2 = new JPanel();
//		p_w_c_c_2.setLayout(new BorderLayout());
//		p_w_c_c_2.add(new JLabel("설명"), BorderLayout.WEST);
//		p_w_c_c_2.add(taVideoContent, BorderLayout.CENTER);
		
		
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
		p_west_south.add(bVideoInsert);
		p_west_south.add(bVideoModify);
		p_west_south.add(bVideoDelete);
		p_west.add(p_west_south, BorderLayout.SOUTH);
		
		
		// 오른쪽 영역
		JPanel p_east = new JPanel();
		
		JPanel p_east_bottom = new JPanel();
		p_east_bottom.setBorder(new TitledBorder("재고  현황 검색"));
		p_east_bottom.setLayout(new BorderLayout());
		
		JPanel p_east_b_south = new JPanel();
		p_east_b_south.add(comVideoSearch);
		p_east_b_south.add(tfVideoSearch);
		
		p_east_bottom.add(p_east_b_south,BorderLayout.NORTH);
		p_east_bottom.add(new JScrollPane(tableVideo),BorderLayout.CENTER);
		
		JPanel p_east_upper = new JPanel();
		p_east_upper.setLayout(new GridLayout(2,1));
		
		
		JPanel p_east_upper_u = new JPanel();
		p_east_upper_u.setLayout(new BorderLayout());
		p_east_upper_u.setBorder(new TitledBorder("재고 부족 상품"));
		p_east_upper_u.add(new JScrollPane(tableVideoU),BorderLayout.CENTER);
		
		JPanel p_east_upper_b = new JPanel();
		p_east_upper_b.setLayout(new BorderLayout());
		p_east_upper_b.setBorder(new TitledBorder("유통기한 임박 상품"));
		p_east_upper_b.add(new JScrollPane(tableVideoD),BorderLayout.CENTER);
		
		
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
	class VideoTableModel extends AbstractTableModel { 
		  
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
	class VideoTableModelU extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"재고번호","상품명","개수"};

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
	class VideoTableModelD extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"재고번호","상품명","유통기한"};

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


