package b_info;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class InfoTest2 {
//	1. 멤버변수 선언
	JFrame f;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;
	JTextArea ta;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;

	ArrayList<Person> list = new ArrayList<Person>();
	
	
//	2. 멤버 객체 생성
	InfoTest2() {
		f=new JFrame("정보");
		bAdd = new JButton("입력");
		bShow = new JButton("전체보기");
		bSearch = new JButton("검색");
		bDelete = new JButton("삭제");
		bCancle = new JButton("취소");
		bExit = new JButton("종료");
		
		ta = new JTextArea();
		tfName = new JTextField(15);
		tfId = new JTextField();
		tfTel = new JTextField();
		tfSex = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();
		
	}
//	3. 화면붙이기 및 화면출력
	void addLayout() {

		// South영역
		JPanel p_south = new JPanel();
		p_south.setLayout(new GridLayout(1,6));
		p_south.add(bAdd);		
		p_south.add(bShow);
		p_south.add(bSearch);
		p_south.add(bDelete);
		p_south.add(bCancle);
		p_south.add(bExit);
		
		
		
		// West 영역
		JPanel p_west = new JPanel();
		p_west.setLayout(new GridLayout(6,2));
		p_west.add(new JLabel("이름"));
		p_west.add(tfName);
		p_west.add(new JLabel("주민번호"));
		p_west.add(tfId);
		p_west.add(new JLabel("전화번호"));
		p_west.add(tfTel);
		p_west.add(new JLabel("성별"));
		p_west.add(tfSex);
		p_west.add(new JLabel("나이"));
		p_west.add(tfAge);
		p_west.add(new JLabel("출신지"));
		p_west.add(tfHome);
		
		// 프레임 영역에 붙이기
		f.setLayout(new BorderLayout());
		f.add(p_south,BorderLayout.SOUTH);
		f.add(p_west,BorderLayout.WEST);
		f.add(ta,BorderLayout.CENTER);
		
		f.setSize(600,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
//	4. 이벤트 등록
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();
		bAdd.addActionListener(bh);
		bShow.addActionListener(bh);
		bSearch.addActionListener(bh);
		bDelete.addActionListener(bh);
		bCancle.addActionListener(bh);
		bExit.addActionListener(bh);
		
		
//		전화번호 텍스필드 엔터 이벤트발생
		tfTel.addActionListener(new TfHdlr());
//		주민번호 텍스필드 포커스 이벤트
		tfId.addFocusListener(new IdFocus());
	}//end of eventProc()
	
	class IdFocus implements FocusListener{

		public void focusGained(FocusEvent e) {
		}
		public void focusLost(FocusEvent e) {
//			"8888888-1234567"
			String id = tfId.getText();
			char sung = id.charAt(7);
			if(sung=='1'|sung=='3') tfSex.setText("남자");
			else tfSex.setText("여자");
			//출신지
			char chul = id.charAt(8);
			String Home = " ";
			switch(chul){
			case '0': Home="서울"; break;
			case '1': Home="인천/부산"; break;
			case '2': Home="경기"; break;
			case '9': Home="제주"; break;
			default : Home="한국인"; 
			}
			tfHome.setText(Home);
			
			//나이출력
			String age = tfAge.getText();
			int nai = Integer.parseInt(id.substring(0,2));
			int nn = 0;
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			char a = id.charAt(7);
			if( a =='1'    | a =='2'    ) {
				nn = year - (1900+nai)+1;
				tfAge.setText(String.valueOf(nn));
			}else if( a =='3'| a =='4'    ) { 
				nn = year - (2000+nai)+1;
				tfAge.setText(String.valueOf(nn));
			}
		}	
	}//end of IdFocus()
	
	class TfHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			searchTel();
			
		}
	}
	
	void deleteTel() {
		String tel = tfTel.getText();
//		(2) ArrayList의 각 Person의 tel과 비교해서 같은지
		for(Person p : list) {
			if(p.getTel().equals(tel)) {
//				(3) 해당 Person의 멤버값들을 각각 텍스트필드에서 출력
				list.remove(p);
				break;
			}
		}
		clearTextField();
		showInfo();
	}
	
	void searchTel(){
//		(1) 사용자 입력한 전화번호 얻어오기
		String tel = tfTel.getText();
//		(2) ArrayList의 각 Person의 tel과 비교해서 같은지
		for(Person p : list) {
			if(p.getTel().equals(tel)) {
//				(3) 해당 Person의 멤버값들을 각각 텍스트필드에서 출력
				tfName.setText(p.getName());
				tfId.setText(p.getId());
				tfSex.setText(p.getGender());
				tfAge.setText(String.valueOf(p.getAge()));
				tfHome.setText(p.getHome());
			}
		}
	}
	
	class BtnHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			if(evt==bAdd) { // 입력버튼
				insert();
				clearTextField();
			}else if(evt==bShow) { // 전체보기버튼
				showInfo();
			}else if(evt==bSearch) { // 검색버튼
				searchTel();
			}else if(evt==bDelete) { //삭제버튼
				deleteTel();
			}else if(evt==bCancle) {
				clearTextField();
			}else if(evt==bExit) { //종료버튼
				exit();
			}
		}
	}
	
	void clearTextField() {
		tfName.setText(null);
		tfId.setText(null);
		tfTel.setText(null);
		tfSex.setText(null);
		tfAge.setText(null);
		tfHome.setText(null);
	}
	
	void showInfo() {
		ta.setText("======================전체보기==============\n\n");
		for(Person p : list) {
			ta.append(p.toString());
		}
	}
	
	void insert() {
//		(1) 각 텍스트 필드의 입력값을 얻어오기
//		(2) 1번 값들을 Person 멤버지정(1-생성자/2-setter)
//		(3) ArrayList에 2번 객체를 추가
	
		Person p = new Person();
		p.setName(tfName.getText());
		p.setId(tfId.getText());
		p.setTel(tfTel.getText());
		p.setGender(tfSex.getText());
		p.setAge(Integer.parseInt(tfAge.getText()));
		p.setHome(tfHome.getText());
		
		list.add(p);
	}
	void exit() {
		int result = JOptionPane.showConfirmDialog(null, "정말로 나갈래요?");
//		종료버튼이 눌렸을 때 강제 프로그램 종료 System.exit(0);
		if(result==JOptionPane.OK_OPTION) {
		System.exit(0);
		}
	}
	public static void main(String[] args) {
		InfoTest2 it = new InfoTest2();
		it.addLayout();
		it.eventProc();
	}

}
