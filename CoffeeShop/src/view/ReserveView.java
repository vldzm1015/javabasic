package	 view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import jdbc.gui.InfoVO;
import model.ReserveDao;
import model.dao.ReserveModel;
import model.vo.Reserve;


public class ReserveView extends JPanel 
{
	
	JTextField	tfCCustTel, tfCCustCname,  tfCCustPname, tfCCustPcount, tfCCustResdate, tfCCustTelSearch;
	JButton		bCCustRetrieve, bCCustInsert, bCCustModify, bCCustDelete;
	

	//*************************************
	ReserveDao dao;	// 다형성?
	
	public ReserveView(){
		addLayout();
		connectDB();
		eventProc();
	}
	
	public void eventProc(){
		ButtonEventHandler btnHandler = new ButtonEventHandler();
		
		// 이벤트 등록
		bCCustRetrieve.addActionListener(btnHandler);
		bCCustInsert.addActionListener(btnHandler);
		bCCustModify.addActionListener(btnHandler);
		bCCustDelete.addActionListener(btnHandler);
	}
	
	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();
			
			if(o==bCCustInsert){  
				registCustomer();  // 회원등록
			}
			else if(o==bCCustModify){  
				updateCustomer();  // 회원정보수정
			}			
			else  if(o==bCCustDelete){  // 
				deleteCustomer();      // 삭제
			}
			else if(o==bCCustRetrieve){  // 이름검색
				searchByTel();
			}
		}
	}
	
	// 입력메소드
	public void registCustomer() {
		
		 Reserve vo = new Reserve();
		
		// 1. 화면 텍스트필드의 입력값 얻어오기			
		// 2. 1값들을 Customer 클래스의 멤버로지정			
		// 3. Model 클래스 안에 insertCustomer () 메소드 호출하여 2번 VO 객체를 넘김
		// 4. 화면 초기화

		vo.setCcustTel(tfCCustTel.getText() );
		vo.setCcustCName(tfCCustCname.getText());
		vo.setCcustPname(tfCCustPname.getText());
		vo.setCcustPcount(Integer.parseInt(tfCCustPcount.getText()));
		vo.setCcustResdate(tfCCustResdate.getText());
		
		try {
			dao.insertCustomer(vo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력실패:"+e.getMessage());
		}
		
		clearTextField();
		
	}
	
	void clearTextField() {
		tfCCustTel.setText(null);
		tfCCustCname.setText(null);
		tfCCustPname.setText(null);
		tfCCustPcount.setText(null);
		tfCCustResdate.setText(null);
	}
	
	// 전화번호에 의한 검색
	public void searchByTel(){
		// 1. 입력한 전화번호 얻어오기
		String tel = (tfCCustTelSearch.getText()) ;
		
		// 2. Model의 전화번호 검색메소드 selectByTel()  호출
		Reserve vo;
		try {
			vo = dao.selectByTel(tel);
		
		// 3. 2번의 넘겨받은 Customer의 각각의 값을 화면 텍스트 필드 지정
//		tfCustName, tfCustTel,  tfCustTelAid, tfCustAddr, tfCustEmail
		tfCCustTel.setText(String.valueOf(vo.getCcustTel()));
		tfCCustCname.setText(vo.getCcustCName());
		tfCCustPname.setText(vo.getCcustPname());
		tfCCustPcount.setText(String.valueOf(vo.getCcustPcount()));
		tfCCustResdate.setText(vo.getCcustResdate());
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "검색:"+ex.getMessage());
		}
	}
	
	
	// 회원정보수정
	public void updateCustomer(){
		
		Reserve vo = new Reserve();
		
		vo.setCcustTel(tfCCustTel.getText());
		vo.setCcustCName(tfCCustCname.getText());
		vo.setCcustPname(tfCCustPname.getText());
		vo.setCcustPcount(Integer.parseInt (tfCCustPcount.getText()));
		vo.setCcustResdate(tfCCustResdate.getText());
		
		try {
			dao.updateCustomer(vo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "수정실패:"+e.getMessage());
			e.printStackTrace();
		}
		
		clearTextField();
	}
	
	//삭제
	public void deleteCustomer()  {
		
		String tel = (tfCCustTelSearch.getText()) ;
		Reserve vo = new Reserve();
		
		// 1. 화면 텍스트필드의 입력값 얻어오기			
		// 2. 1값들을 Customer 클래스의 멤버로지정			
		// 3. Model 클래스 안에 insertCustomer () 메소드 호출하여 2번 VO 객체를 넘김
		// 4. 화면 초기화

		vo.setCcustTel(tfCCustTel.getText());
		vo.setCcustCName(tfCCustCname.getText());
		vo.setCcustPname(tfCCustPname.getText());
		vo.setCcustPcount(Integer.parseInt(tfCCustPcount.getText()));
		vo.setCcustResdate(tfCCustResdate.getText());
		
		try {
			dao.deleteCustomer(tel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력실패:"+e.getMessage());
			e.printStackTrace();
		}
		
		clearTextField();

	}

	
	public void connectDB(){
		
		try {
			dao = new ReserveModel();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"오류: 드라이버 오류 : " + ex.getMessage());
		}
		
	}
	
	public void addLayout(){
		
		tfCCustTel			= new JTextField(20);
		tfCCustPname		= new JTextField(20);
		tfCCustCname		= new JTextField(20);
		tfCCustPcount			= new JTextField(20);
		tfCCustResdate			= new JTextField(20);


		tfCCustTelSearch	= new JTextField(20);
	

		bCCustRetrieve		= new JButton("예약조회");
		bCCustInsert		= new JButton("입력");
		bCCustModify		= new JButton("수정");
		bCCustDelete		= new JButton("삭제");
		

		// 회원가입 부분 붙이기 
		//		( 그 복잡하다던 GridBagLayout을 사용해서 복잡해 보임..다른 쉬운것으로...대치 가능 )
//		JPanel whole = new JPanel();
//		whole.setLayout(new GridLayout(1,2));
//		
//		JPanel leftone = new JPanel();
//		leftone.setLayout(new BorderLayout());
//		leftone.add(pRegist,BorderLayout.CENTER)
//		
//		JPanel rightone = new JPanel();
//		rightone.setLayout(new BorderLayout());
//		
//		whole.add(leftone);
//		whole.add(rightone);
//		
		
		
		
		JPanel			pRegist		= new JPanel();
		pRegist.setLayout( new GridBagLayout() );
			GridBagConstraints	cbc = new GridBagConstraints();
			cbc.weightx	= 1.0;
			cbc.weighty	 = 1.0;
			cbc.fill				= GridBagConstraints.BOTH;
		cbc.gridx	=	0;	 			cbc.gridy	=  0;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( new JLabel("	고객전화번호	") ,	cbc );
		cbc.gridx	=	1;	 			cbc.gridy	=  0;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( tfCCustTel ,	cbc );
		cbc.gridx	=	2;	 			cbc.gridy	=  0;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( bCCustRetrieve,	cbc );
		cbc.gridx	=	3;	 			cbc.gridy	=  0;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( tfCCustTelSearch,	cbc );

		cbc.gridx	=	0;	 			cbc.gridy	=  1;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( new JLabel("	고객명	") ,	cbc );
		cbc.gridx	=	1;	 			cbc.gridy	=  1;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add(  tfCCustPname ,	cbc );
		
		cbc.gridx	=	0;	 			cbc.gridy	=  2;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( new JLabel(" 상품명  ") ,	cbc );
		cbc.gridx	=	1;	 			cbc.gridy	=  2;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( tfCCustCname ,	cbc );

		cbc.gridx	=	0;	 			cbc.gridy	=  3;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( new JLabel("	상품개수	") ,	cbc );
		cbc.gridx	=	1;	 			cbc.gridy	=  3;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add(  tfCCustPcount  ,	cbc );

		cbc.gridx	=	0;	 			cbc.gridy	=  4;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( new JLabel("	예약날짜	") ,	cbc );
		cbc.gridx	=	1;	 			cbc.gridy	=  4;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( tfCCustResdate ,	cbc );
		cbc.gridx	=	2;	 			cbc.gridy	=  4;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( bCCustInsert ,	cbc );
		cbc.gridx	=	3;	 			cbc.gridy	=  4;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( bCCustModify ,	cbc );
		cbc.gridx	=	4;	 			cbc.gridy	=  4;			cbc.gridwidth	=	1;			cbc.gridheight= 1;
		pRegist.add( bCCustDelete ,	cbc );




//		// 회원검색 부분 붙이기
//		JPanel			pSearch		= new JPanel();
//		pSearch.setLayout( new GridLayout(2, 1) );
//				JPanel	pSearchName	= new JPanel();
//				pSearchName.add(	new JLabel("		이 	름	"));
//				pSearchName.add(	tfCustNameSearch );
//				pSearchName.add(	bCustNameSearch );
//				JPanel	pSearchTel	= new JPanel();
//				pSearchTel.add(		new JLabel("	전화번호	"));
//				pSearchTel.add(	tfCustTelSearch );
//				pSearchTel.add(	bCustTelSearch );
//		pSearch.add(	 pSearchName );
//		pSearch.add( pSearchTel );

		// 전체 패널에 붙이기
		setLayout( new BorderLayout() );
		add("Center",		pRegist );
//		add("South",		pSearch );
		
	}
	

}			 	
				 	
