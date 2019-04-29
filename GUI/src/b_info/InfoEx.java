package b_info;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoEx {
	JFrame f;
	JButton n1, n2, n3, n4, n5, n6, n7, n8, n9, plus, n0, equal, ma, mul, div ;
	JTextField tf;
	JButton [] jb = new JButton[10];
	
	InfoEx() {
		f=new JFrame("유치원 계산기");
		for (int i = 0; i < jb.length; i++) {
			jb [i] = new JButton(String.valueOf(i));
		}

		plus = new JButton("+");
		n0 = new JButton("0");
		equal = new JButton("=");
		ma = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		
		tf = new JTextField();
	}
	
		void addLayout() {
			// South영역
			JPanel p_north = new JPanel();
			p_north.add(tf);
			
			JPanel p_center = new JPanel();
			p_center.setLayout(new GridLayout(5,3));
			for (int i = 1; i < jb.length; i++) {
				p_center.add(jb[i]);
			}
			
			p_center.add(plus);
			p_center.add(jb[0]);
			p_center.add(equal);
			p_center.add(ma);
			p_center.add(mul);
			p_center.add(div);
			
			f.setLayout(new BorderLayout());
			f.add(tf,BorderLayout.NORTH);
			f.add(p_center,BorderLayout.CENTER);
			
			
			f.setSize(600,480);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	
	
	public static void main(String[] args) {
		InfoEx ex = new InfoEx();
		ex.addLayout();
	}

}
