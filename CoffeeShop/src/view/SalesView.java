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



public class SalesView extends JPanel {

	JTextField tfSalNum, tfPayIvNum, tfReturnTotal, tfInsertCount;

	JButton bPay, bReturn, bCancel;

	JTable      tableSales; //VIEW 역할

	SalesTableModel salesTM;

	SalesModel db;

	// 메뉴버튼 배열
	JButton [] bMenu = new JButton[12];
	// 메뉴명 배열
	String [] strMenu = {"아메리카노","카페라떼", "바닐라라떼", "초코라떼", "녹차라떼",
			"밀크티"," 치즈케이크", "티라미수", "허니브래드", "초코쿠키", "버터쿠키", "샌드위치"};
	// 메뉴 가격 배열
	int [] priceMenu = {1500, 2000, 2500, 2500, 2500, 3000, 5000,
			5000, 6000, 2000, 2000, 6000};

	// 메뉴선택 메뉴명 저장하는 변수
	int selected;

	int total=0;
	String result= "";


	//==============================================
	//    생성자 함수
	public SalesView(){
		addLayout();   //화면구성
		eventProc();   //DB연결
		connectDB();

		//      selectNonReturn();
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
		//		tfReturnTotal.addActionListener(ah);
		bPay.addActionListener(ah);
		bReturn.addActionListener(ah);
		bCancel.addActionListener(ah);


		ButtonEventHandler hdlr = new ButtonEventHandler();
		for(int i=0; i<bMenu.length; i++) {
			bMenu[i].addActionListener(hdlr);
		}

		tfInsertCount.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int price = (priceMenu[selected])*(Integer.parseInt(tfInsertCount.getText()));
				
				ArrayList data = new ArrayList();
				data.add(strMenu[selected]);
				data.add(Integer.parseInt(tfInsertCount.getText()));
				data.add(price);
				
				ArrayList exData = salesTM.data;

				// true / false 변수 잡아주기
				boolean flag = false;

				// 반복문 구동 exData.size() 
				for (int i = 0; i <  exData.size(); i++) {
					// ArrayList temp 와  exData.get(i) 가 같다
					ArrayList temp = (ArrayList) exData.get(i);

					// temp.get(0)와 strMenu[selected] 같다면
					String  tempMenuName =(String) temp.get(0);
					System.out.println(tempMenuName + " /" +strMenu[selected] );

					if (tempMenuName.equals (strMenu[selected])) {
						// 메뉴의 이름이 같을 때
						flag = true;
						//   예전의 카운트는 temp (1) 저장
						int exCnt =  (int) temp.get(1);

						// 예전 가격은 temp(2) 저장
						int exPrice = (int)temp.get(2);

						//  새로운 개수는 예전 개수 + 이번개수
						int calCal = exCnt + Integer.parseInt(tfInsertCount.getText());

						// temp (1) 번 값으로 새로운개수 지정
						temp.set(1, calCal);

						// temp (2)번 값으로 새로운 개수와 예전 가격 곱하기
						temp.set(2, calCal  *price);

						salesTM.fireTableDataChanged();
						getSum();
					}

				}
				// flag가 fasle 라면	
				if( flag == false) {
					// data 추가
					salesTM.data.add(data);
					salesTM.fireTableDataChanged();
					getSum();
				}
			}
		});

	}
	// 액션이벤트 핸들러 만들기
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//System.out.println("이벤트");
			Object evt = e.getSource();
			// 취소
			if (evt == bCancel) {
				coffecancle();
				// 결제
			} else if (evt == bPay) {
				coffePay();
				// 환불
			} else if(evt == bReturn) {
				coffereturn();
				// 메뉴고르기
			} else if (evt == tfInsertCount) {
				selectItem();
				getSum();
			} 

		}
	}


	//
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JButton evt =(JButton) ev.getSource();
			// System.out.println("이벤트:" + evt.getText());
			for( int i=0; i< bMenu.length; i++) {
				if( evt == bMenu[i]) selected= i;
			}
		}


	}


	// 수량입력 시 처리하는 메소드
	public int selectItem() {
		//1.화면에서 필요한 정보를 얻어오기
		int vnum = Integer.parseInt(tfPayIvNum.getText());
		int total = Integer.parseInt(tfPayIvNum.getText());
		
		return 0;
	}
	public void getSum()
	{

		int sum = 0;

		for(int i = 0; i < tableSales.getRowCount(); i++)

		{
//			String a =((String)(tableSales.getValueAt(i, 2))).replaceAll("[^0-9]", "");
			sum = sum + (Integer)(salesTM.getValueAt(i, 2));

		}
		System.out.println(sum);
		tfReturnTotal.setText(Integer.toString(sum));

	}

	// 취소 시 처리하는 메소드
	public void coffecancle() {

		salesTM.data = new ArrayList();
		salesTM.fireTableDataChanged();
		clearTextField();
	
	}
	

	// 결제 시 처리하는 메소드
	public void coffePay() {
		
		try {
			db.coffePay(salesTM.data);
//			salesTM.data = new ArrayList();
//			salesTM.fireTableDataChanged();
			clearTextField();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	//  환불 시 처리하는 메소드
	public void coffereturn() {
	
		try {
			db.coffePay(salesTM.data);
			clearTextField();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	void clearTextField() {
		tfPayIvNum.setText(null);
		tfInsertCount.setText("1");
		tfReturnTotal.setText(null);
	}

	//   화면 구성********************************************
	void addLayout(){
		// 멤버변수 객체 생성
		tfPayIvNum = new JTextField(20);
		tfReturnTotal = new JTextField(10);

		bPay = new JButton("결제");
		bCancel = new JButton("취소");
		bReturn = new JButton("환불");

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
		p_west_center.setBorder(new TitledBorder("선      택"));
		p_west_center.setLayout(new GridLayout(4,4));

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

	static class SalesTableModel extends AbstractTableModel { 

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

		public void setNumRows(int i) {
			// TODO Auto-generated method stub
			
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

