package c_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame{
	JButton b;
	JTextField tf;
	
	
	Test(){
		b = new JButton("PUSH");
		tf = new JTextField("INPUT",20);
	
	}
	
	void addLayout() {
		setLayout(new FlowLayout());
		add(b);
		add(tf);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void eventProc() {
//		2. 핸들러 객체 생성
		Eventtt me = new Eventtt();
//		3. 이벤트 발생을 원하는 컴포넌트와 연결
		b.addActionListener(me);
		tf.addActionListener(me);
	}
	
	
//  1. 이벤트 핸들러 만들기 ( 이벤트 구현 클래스)
//		(1) 이벤트 Listener(interface) 구현
//		(2) 이벤트 메소드 overriding
	class Eventtt implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==b) {
				String msg = b.getText();
				JOptionPane.showMessageDialog(null,msg +"버튼이벤트발생");
			}else if(obj==tf) {
				String msg = tf.getText();
				JOptionPane.showMessageDialog(null,msg +"를 입력했습니다.");
			}
			
		}
		
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.addLayout();
		t.eventProc();

	}

}
