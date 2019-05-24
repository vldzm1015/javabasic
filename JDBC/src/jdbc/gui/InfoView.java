package jdbc.gui;

/*
 * Java GUI를 구성하는 application을 만든 후 
 * DataBase에 입력 / 수정 / 삭제 / 검색을 하는 프로그램을 작성하는 예제
 * 
 * 또한 이 프로그램은 Java Swing으로 GUI를 구성하였음
 *
 *		테이블명 : temp
 *		name	varchar(10)
 *		id		char(14)
 *		tel		varchar(13)
 *		sex		varchar(10)
 *		age		number
 *		home	varchar(10)
 *	
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;

class InfoView implements ActionListener{

	//-----------------------------------------
	// 화면에 관련한 변수 선언
	//-----------------------------------------
	JFrame frame;
	JTextField tf_name, tf_id, tf_tel, tf_age, tf_gender, tf_home ;
	JButton b_add, b_show, b_modify, b_delete, b_cancel, b_exit;
	JTextArea ta;	
	
	//########################################
	// 1. business logic를 실행하는 클래스 변수 선언
	InfoModelImpl db = null;
//	InfoMysqlImpl db = null;


	//-----------------------------------------
	// 생성자 함수
	//	: 위의 멤버 변수에 선언된 클래스 객체 생성
	//-----------------------------------------
	public InfoView() {
		
		frame		= new JFrame("DBTest");

		tf_name		= new JTextField(15);
		tf_id		= new JTextField(15);
		tf_tel		= new JTextField(15);
		tf_age		= new JTextField(15);
		tf_gender	= new JTextField(15);
		tf_home		= new JTextField(15);
		
		/*
		* 버튼 생성 ( 이미지 버튼 )
		* 1. Text과 ImageIcon를 갖는 버튼 생성
		* 2. Text를 그림 아래 위치
		* 3. Text를 가운데 정렬
		* 4. 버튼의 보더 지정 : 버튼의 모양이 위로 올라와 보이게
		* 5. 버튼의 튤팁을 지정
		*/				
		b_add		= new JButton("Add", new ImageIcon("img/add.gif"));
		b_add.setVerticalTextPosition(SwingConstants.BOTTOM);
		b_add.setHorizontalTextPosition(SwingConstants.CENTER);		
		b_add.setBorder(new BevelBorder(BevelBorder.RAISED));
		b_add.setToolTipText("추가");
		
		
		b_show		= new JButton("Show");
		b_modify	= new JButton("Modify");
		b_delete	= new JButton("Delete");
		b_cancel	= new JButton("Cancel");
		b_exit		= new JButton("Exit");
		ta			= new JTextArea(20, 50);
		
	
	
		//#########################################
		// 2. business logic 역할을 하는 클래스 객체 생성
		try {
			db = new InfoModelImpl();
//			db = new InfoMysqlImpl();
			ta.setText("DB연결성공");
		} catch (Exception ex) {
		 ta.setText("현재 네트워크 오류가 발생하여...");
		 ex.printStackTrace();
		}
		
	
	}
	

	//--------------------------------------------------
	//--------------------------------------------------
	void setup(){
		
		JPanel p_center  = new JPanel();
		JPanel p_west	 = new JPanel();
		JPanel p_south 	 = new JPanel();
		
		// 화면출력만 하는 라벨 생성 및 붙이기 
		JLabel ll_name = new JLabel("Name", new ImageIcon("img/cute/1.gif"),JLabel.CENTER);		
		JLabel ll_id   = new JLabel("ID",   new ImageIcon("img/cute/2.gif"),SwingConstants.CENTER);
		JLabel ll_tel  = new JLabel("Tel",  new ImageIcon("img/cute/3.gif"),SwingConstants.CENTER);
		JLabel ll_sex  = new JLabel("Sex",  new ImageIcon("img/cute/4.gif"),SwingConstants.CENTER);
		JLabel ll_age  = new JLabel("Age",  new ImageIcon("img/cute/5.gif"),SwingConstants.CENTER);
		JLabel ll_home = new JLabel("Home", new ImageIcon("img/cute/6.gif"),SwingConstants.CENTER);
		
		// west영역 붙이기
		p_west.setLayout( new GridLayout(6,2));
		p_west.add( ll_name);
		p_west.add( tf_name );
		p_west.add( ll_id);
		p_west.add( tf_id );
		p_west.add( ll_tel);
		p_west.add( tf_tel );
		p_west.add( ll_sex);
		p_west.add( tf_gender );
		p_west.add( ll_age);
		p_west.add( tf_age );
		p_west.add( ll_home);
		p_west.add( tf_home );
		
		
		// center 영역
		p_center.setLayout(new BorderLayout());
		p_center.add("Center", ta );
		
		// south 영역
		p_south.setLayout( new GridLayout(1,6));
		p_south.add( b_add );
		p_south.add( b_show );
		p_south.add( b_modify );
		p_south.add( b_delete );
		p_south.add( b_cancel );
		p_south.add( b_exit );
	
		// 전체 영역 붙이기 및 화면 출력
		frame.getContentPane().setLayout( new BorderLayout() );
		frame.getContentPane().add("West", p_west );
		frame.getContentPane().add("Center", p_center );
		frame.getContentPane().add("South", p_south );
		
		frame.pack();
		frame.setTitle("DBTest");
		frame.setVisible(true);	
		
	}

	//--------------------------------------------------
	// 각 버튼을 이벤트에 등록	
	//--------------------------------------------------
	public void eventProc(){

		b_add.addActionListener( this );
		b_show.addActionListener( this );
		b_modify.addActionListener( this );
		b_delete.addActionListener( this );
		b_cancel.addActionListener( this );
		b_exit.addActionListener( this );
		
		tf_id.addActionListener( this );
		tf_tel.addActionListener( this );
	}


	//-------------------------------------------------
	// ActionListener에 등록한 컴포넌트에서 이벤트 발생시 
	// JVM에 의해 호출되는 메소드
	//-------------------------------------------------
	public void actionPerformed( ActionEvent ev ){
		
		if( ev.getSource() == b_add ){
		//######################################################
		// Add 버튼이 눌렸을 때		
		// 1. 각 텍스트필드에서 값을 얻어옴
		// 3. Database 파일의 insert() 함수의 인자로 값을 넘겨줌
			//JOptionPane.showMessageDialog( frame,  "추가버튼 눌림");					
			insertData();
		
		}	
		
		else if( ev.getSource() == b_show ){
		//######################################################
		// 전체 보기 버튼이 눌렸을 때
			selectAllData();
		} 
		
		else 	if( ev.getSource() == b_modify ){
			//######################################################
			// Modify 버튼이 눌렸을 때		
			// 1. 각 텍스트필드에서 값을 얻어옴
			// 3. Database 파일의 modify() 함수의 인자로 값을 넘겨줌
				JOptionPane.showMessageDialog( frame,  "수정버튼 눌림");					
				modify();
		}
		
		else if( ev.getSource() == b_delete ){
		//######################################################
		// 삭제버튼 눌렸을 때
		//	1. 주민번호 텍스트 필드의 입력값 얻어옴
		//  2. Database의 delete() 함수의 인자로 넘겨줌
			JOptionPane.showMessageDialog( frame ,  "삭제버튼 눌림");	
			delete();
		}
		else if(ev.getSource() == tf_tel) {
//			JOptionPane.showMessageDialog(frame, "전화번호엔터");  //이벤트 발생확인
			selectByTel();
			
		}
		else if(ev.getSource() == tf_id) {
//			JOptionPane.showMessageDialog(frame, "주민번호엔터"); //이벤트 발생확인
			selectById();
		}
	}
	private void delete() {
		String tel = tf_tel.getText();
		try {
			db.delete(tel);
			ta.append( "\n========== 삭제 성공 ==========\n");
		} catch (Exception e) {
			 System.out.println( "삭제 실패" + e.getMessage() );
		}
		clearTextField();
			}
	private void modify() {
		try {
			InfoVO vo = new InfoVO();
			 vo.setName( tf_name.getText( ) );
	         vo.setId( tf_id.getText( ) );
             vo.setTel( tf_tel.getText( ) );
             vo.setGender( tf_gender.getText( ) );
	          vo.setAge( Integer.parseInt( tf_age.getText( ) ) );
	          vo.setHome( tf_home.getText( ) );
	          
	          db.modify(vo);
	          
	          ta.append( "\n========== 변경 성공 ==========\n");
	          
		} catch (Exception e) {
			 System.out.println( "변경 실패" + e.getMessage() );
		}
	}
	void selectByTel() {
		String tel = tf_tel.getText();
		
		try {
		
			InfoVO vo = db.selectByTel(tel);
			tf_name.setText(vo.getName());
			tf_id.setText(vo.getId());
			tf_tel.setText(vo.getTel());
			tf_gender.setText(vo.getGender());
			tf_age.setText(String.valueOf(vo.getAge()));
			tf_home.setText(vo.getHome());
		} catch (Exception e) {
			ta.setText("검색실패 : " + e.getMessage()  );
		}		
	}
	
	void selectById() {
		String id = tf_id.getText();
		
		try {
			InfoVO vo = db.selectById(id);
			tf_name.setText(vo.getName());
			tf_id.setText(vo.getId());
			tf_tel.setText(vo.getTel());
			tf_gender.setText(vo.getGender());
			tf_age.setText(String.valueOf(vo.getAge()));
			tf_home.setText(vo.getHome());
		} catch (Exception e) {
			ta.setText("검색실패 : " + e.getMessage()  );
		}		
	}
	public void insertData() {
		
		// 1. 각 텍스트필드에서 값을 얻어옴
		InfoVO vo =new InfoVO();
		
		vo.setName( tf_name.getText());
		vo.setId( tf_id.getText());
		vo.setTel(tf_tel.getText());
		vo.setGender(tf_gender.getText());
		vo.setAge(Integer.parseInt( tf_age.getText()));
		vo.setHome(tf_home.getText());
		
		// 3. Database 파일의 modify() 함수의 인자로 값을 넘겨줌
		try {
			db.insert(vo);
			clearTextField();
		} catch (Exception e) {
			ta.setText("입력실패 :" + e.getMessage() );
		}
	}
	// 1. Database 파일의 selectAllData() 호출하여 ArrayList로 리턴받음
			// 2. 리턴받은 ArrayList에서 InfoVO 객체를 하나씩 얻어온후
			// 3. 그 Record 객체 안의 toString() 메소드 호출하여 TextArea에 출력
	public void selectAllData() {
		try {
			ArrayList<InfoVO> list = db.selectAllData();
			ta.setText("===============검색결과 \n\n");
			for(InfoVO vo : list  ) {
				ta.append(vo.toString());
			}
		} catch (Exception ex) {
			ta.setText("데이타 검색 실패" + ex.getMessage());
		}
		
	}

	void clearTextField() {
		tf_name.setText(null);
		tf_id.setText(null);
		tf_tel.setText(null);
		tf_gender.setText(null);
		tf_age.setText(null);
		tf_home.setText(null);
	}
	public static void main(String args[]) {
		System.out.println("Starting DBTest...");
		InfoView mainFrame = new InfoView();
		mainFrame.setup();
		mainFrame.eventProc();
	}
}
