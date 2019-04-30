package c_event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test3 extends JFrame{
	JButton b;
	JTextField tf;
	
	
	Test3(){
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
//		Eventtt evt = new Eventtt();
//		b.addActionListener(evt);
//		한줄로 요약
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "버튼이벤트발생");
			}
		});
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "엔터이벤트발생");
			}
		});
	}
//	위에 축약형으로 구현
//	class Eventtt implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			JOptionPane.showMessageDialog(null, "이벤트발생");
//		}
//	}
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.addLayout();	
		t.eventProc();

	}

}
