package b_info;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InfoTest3 {
//	1. 멤버변수 선언
	JFrame f;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;
	JTextArea ta;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
//	2. 멤버 객체 생성
	InfoTest3() {
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
		
		f.setSize(600,480);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	void eventProc() {
		MyHdlr mh= new MyHdlr();
		bExit.addMouseListener(mh);
//		Listener 먼저 해놓고 어댑터 사용권장
	}
//	class MyHdlr implements MouseListener{
//	동일하나 여러개의 오버라이딩 중 하나만 필요할 때는 어댑터사용
	class MyHdlr extends MouseAdapter{	
		public void mouseClicked(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==bExit) {
				System.exit(0);
			}		
		}
	}
	
	public static void main(String[] args) {
		InfoTest3 it = new InfoTest3();
		it.addLayout();
		it.eventProc();

	}

}

//interface AAListener{
//	void a();
//	void b();
//	void c();
//}
//class AAAdapter implements AAListener{
//	public void a() {}
//	public void b() {}
//	public void c() {}
//}
//class MyhHdlr extends AAAdapter{
//	public void a() {}
//}
//
//
//class MyhHdlr implements AAListener{
//	public void a() {}
//	public void b() {}
//	public void c() {}
//}