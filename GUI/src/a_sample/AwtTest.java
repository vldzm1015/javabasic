package a_sample;
/*
 * Java GUI
 * 		- AWT :  1.2 이전
 * 		-Swing :  1.2 이후
 * Java - Write Once Run Anywhere
 */
import java.awt.*;
import javax.swing.*;
public class AwtTest extends JFrame{
	// 1. 멤버변수 선언하는 위치
	JButton b1;
	JButton b2;
	JTextField tf;
	JTextArea ta;
	JRadioButton ch1,ch2;

	
	AwtTest(){
		super("나의 두번째 창");
		// 2. 객체생성
//		FlowLayout f1 = new FlowLayout();
//		setLayout(f1);
		//원래 객체 생성
		setLayout(new FlowLayout());
		// 두줄을 한줄로 줄여서. 딱 한번만 사용할 때
		b1 = new JButton("OK");
		b2 = new JButton("Cancle");
		tf = new JTextField(30);
		ta = new JTextArea(10,50);
		ch1 = new JRadioButton("Female");
		ch2 = new JRadioButton("Male");
		ButtonGroup bg = new ButtonGroup();
		bg.add(ch1);
		bg.add(ch2);
	}
	
	void addLayout() {
		// 3. 화면에 붙이기
		//setLayout(new FlowLayout());
		//윗줄 상단 중앙에 배치 - 컴포넌트의 크기가 고정
		setLayout(new GridLayout(3,2));
		// 행과 열에 배치 - 컴포넌트 크기가 변경됨
		setLayout(new BorderLayout());
		// NORTH, SOUTH, CENTER, WEST, EAST 영역에 배치
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.SOUTH);
		add(tf, BorderLayout.WEST);
		add(ta, BorderLayout.CENTER);
		JPanel p = new JPanel();
		//Panel 에도 대문자 J를 붙여야함
		p.add(ch1);
		p.add(ch2);
		add(p, BorderLayout.EAST);
		
//		add(ch1, BorderLayout.EAST);
//		add(ch2, BorderLayout.EAST);


		// 4. 화면에 출력
		setSize(600,480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// X버튼 누르면 나가게 해줌
	}
	
	
	public static void main(String[] args) {
		AwtTest at = new AwtTest();
		at.addLayout();

	}

}
