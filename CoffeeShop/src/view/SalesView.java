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
import model.vo.Inventory;
import model.dao.SalesModel;




public class SalesView extends JPanel {
	JTextField tfPayTel, tfPayCustName, tfPayIvNum;
	JButton bPay, bReturn, bCancel;
	JButton  bAmeri, bRatte, bBaRa, bChoRa, bGrRa, bMiRa, bCheese, bTira, bHonny, 
	bCooCho, bCooBu, bSan;
	JTextField tfReturnTotal;

	JTextField	tfInsertCount;

	JTable		tableSales; //VIEW 역할

	//	JTable tableSalesList;

	SalesTableModel salesTM;
	SalesModel db;
	
	// 메뉴버튼 배열
	JButton [] bMenu = new JButton[12];
	// 메뉴명 배열
	String [] strMenu = {"아메리카노","카페라떼", "바닐라라떼", "초코라뗴", "녹차라떼",
			"밀크티"," 치즈케이크", "티라미수", "허니브래드", "초코쿠키", "버터쿠키", "샌드위치"};
	// 메뉴 가격 배열
	int [] priceMenu = {1500, 2000, 2500, 2500, 2500, 3000, 5000,
			5000, 6000, 2000, 2000, 6000};
	
	// 메뉴선택 메뉴명 저장하는 변수
	int selected;


	//==============================================
	//	 생성자 함수
	public SalesView(){
		addLayout();	//화면구성
		eventProc();	//DB연결
		connectDB();

		//		selectNonReturn();
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

	// 이벤트 등록
	public void eventProc(){
		ActionHandler ah = new ActionHandler();
		tfPayTel.addActionListener(ah);
		bPay.addActionListener(ah);
		bReturn.addActionListener(ah);
		bCancel.addActionListener(ah);
		

		ButtonEventHandler hdlr = new ButtonEventHandler();
//		bAmeri.addActionListener(hdlr);
//		bRatte.addActionListener(hdlr);
//		bBaRa.addActionListener(hdlr);
//		bChoRa.addActionListener(hdlr);
//		bGrRa.addActionListener(hdlr);
//		bMiRa.addActionListener(hdlr);
//		bCheese.addActionListener(hdlr);
//		bTira.addActionListener(hdlr);
//		bHonny.addActionListener(hdlr);
//		bCooCho.addActionListener(hdlr);
//		bCooBu.addActionListener(hdlr);
//		bSan.addActionListener(hdlr);
		for(int i=0; i<bMenu.length; i++) {
			bMenu[i].addActionListener(hdlr);
		}
		
		tfInsertCount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ArrayList data = new ArrayList();
				data.add(strMenu[selected]);
				data.add(Integer.parseInt(tfInsertCount.getText()));
				data.add(priceMenu[selected]);
				
				salesTM.data.add(data);
				salesTM.fireTableDataChanged();
				
			}
		});


	}
	// 액션이벤트 핸들러 만들기
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("이벤트");
			Object evt = e.getSource();
			if (evt == bCancel) {
				//				selectCustName();
			} else if (evt == bPay) {
				coffePay();
				//				selectNonReturn();
			} else if(evt == bReturn) {
//				returnVideo();
				//				selectNonReturn();
			} else if (evt == tfInsertCount) {
				coffePay();
				//				selectNonReturn();
			} 

		}
	}
	
	
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
 			JButton evt =(JButton) ev.getSource();
			// System.out.println("이벤트:" + evt.getText());
			for( int i=0; i< bMenu.length; i++) {
				if( evt == bMenu[i]) selected= i;
			}
		}


	}
	

	//전화 입력 후 엔터치면 고객명을 출력하는 메소드
	public void selectCustName() {
			
	}
	
	// 수량입력 시 처리하는 메소드
		public int selectItem(String Pname,  int Price, int PCount) {
			//1.화면에서 필요한 정보를 얻어오기
				
   
//			Price = 
////			PCount = ;
			
			int vnum = Integer.parseInt(tfPayIvNum.getText());
			
			
			return 0;
		}
		
	// 결제 시 처리하는 메소드
	public void coffePay() {
		//1.화면에서 필요한 정보를 얻어오기
		//2.모델쪽 메소드 호출
		//3. 대여 후 결과처리
		String tel = tfInsertCount.getText();
		int vnum = Integer.parseInt(tfPayIvNum.getText());
		int Ivnum = Integer.parseInt(tfReturnTotal.getText());
		
	}
	




	//	화면 구성********************************************
	void addLayout(){
		// 멤버변수 객체 생성
		tfPayTel = new JTextField(20);
		tfPayCustName = new JTextField(20);
		tfPayIvNum = new JTextField(20);
		tfReturnTotal = new JTextField(10);

		bPay = new JButton("결제");
		bCancel = new JButton("취소");
		bReturn = new JButton("환불");
		
//		bAmeri = new JButton("아메리카노");
//		bRatte = new JButton("카페라떼");
//		bBaRa = new JButton("바닐라라떼");
//		bChoRa = new JButton("초코라뗴");
//		bGrRa = new JButton("녹차라떼");
//		bMiRa = new JButton("밀크티");
//		bCheese = new JButton("치즈케이크");
//		bTira = new JButton("티라미수");
//		bHonny = new JButton("허니브래드");
//		bCooCho = new JButton("초코쿠키");
//		bCooBu = new JButton("버터쿠키");
//		bSan = new JButton("샌드위치");
		for(int i =0; i<bMenu.length; i++)
		{
			bMenu[i] = new JButton(strMenu[i]);
		}
		tfInsertCount = new JTextField("1",5);
		
		

		tableSales = new JTable();
		salesTM = new SalesTableModel();
		tableSales = new JTable(salesTM);

		// ************* 화면구성 *****************

		// 화면 왼쪽
		JPanel p_west = new JPanel();
		p_west.setLayout(new BorderLayout());

		//왼쪽 - 메인
		JPanel p_west_center = new JPanel();
		p_west_center.setBorder(new TitledBorder("선		택"));
		p_west_center.setLayout(new GridLayout(4,4));
//		p_west_center.add(new JButton("아메리카노"));
//		p_west_center.add(new JButton("카페라떼"));
//		p_west_center.add(new JButton("바닐라라떼"));
//		p_west_center.add(new JButton("초코라떼"));
//		p_west_center.add(new JButton("녹차라떼"));
//		p_west_center.add(new JButton("밀크티"));
//		p_west_center.add(new JButton("치즈케이크"));
//		p_west_center.add(new JButton("티라미수"));
//		p_west_center.add(new JButton("허니브래드"));
//		p_west_center.add(new JButton("초코쿠기"));
//		p_west_center.add(new JButton("버터쿠키"));
//		p_west_center.add(new JButton("샌드위치"));
		for(int i =0; i<bMenu.length; i++)
		{
			p_west_center.add(bMenu[i]);
		}


		// 화면 왼쪽 아래
		JPanel p_west_south = new JPanel();	
		p_west_south.setBorder(new TitledBorder("개수를 선택하시오"));
		p_west.add(p_west_south,BorderLayout.SOUTH);
		p_west_south.add(new JLabel("수량"));
		p_west_south.add(tfInsertCount);
		p_west_south.add(new JLabel("개"));


		//p_west.setLayout(new GridLayout(2,1));
		p_west.setLayout(new BorderLayout());
		p_west.add(p_west_center, BorderLayout.CENTER);
		p_west.add(p_west_south, BorderLayout.SOUTH);

		// 화면 오른쪽
		JPanel p_east = new JPanel();
		p_east.setBorder(new TitledBorder("결 제"));
		p_east.setLayout(new BorderLayout());

		// 화면 오른쪽 위에
		JPanel p_east_north = new JPanel();	
		p_east.add(p_east_north,BorderLayout.NORTH);
		p_east.add(new JScrollPane(tableSales),BorderLayout.CENTER);


		// 화면 오른쪽 아래
		JPanel p_east_south = new JPanel();	
		p_east.add(p_east_south,BorderLayout.SOUTH);
		p_east_south.add(new JLabel("TOTAL"));
		p_east_south.add(tfReturnTotal);
		p_east_south.add(bPay);
		p_east_south.add(bCancel);
		p_east_south.add(bReturn);
		

		//전체영역에 붙이기
		setLayout(new GridLayout(1,2));
		add(p_west);
		add(p_east);

	}

	class SalesTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"상품명","상품개수","가격"};

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

	//미납목록 출력하는 메소드
	//	public void selectNonReturn() {
	//
	//		try {
	//			rentTM.data=db.selectList();
	//			rentTM.fireTableDataChanged();
	//		}catch(Exception ex){
	//			System.out.println(ex.getMessage());
	//		}
	//	}
}


