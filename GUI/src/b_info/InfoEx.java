package b_info;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InfoEx {
	JFrame f;
	JTextField tf;
	JButton n1, n2, n3, n4, n5, n6, n7, n8, n9,
	plus, n0, equal, ma, mul, div ;
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

	void eventProc() {
		BtnHdlr bh = new BtnHdlr();
		for (int i = 0; i <jb.length ; i++) {
			jb [i] = new JButton(String.valueOf(i));
		}
		plus.addActionListener(bh);
		n0.addActionListener(bh);
		equal.addActionListener(bh);
		ma.addActionListener(bh);
		mul.addActionListener(bh);
		div.addActionListener(bh);
	}//end of eventProc()

	class BtnHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton evt = (JButton)e.getSource();
			for (int i = 0; i < jb.length; i++) {
				if(evt==jb[i]) {
					if((i>0& i<8)|(i==10)){
						insert();
					}else if(i==9|i==12|i==13|i==4) {

					}else if(i==11) {

					}
				}
			}
		}
	}
	void insert() {
		for (int i = 0; i < jb.length; i++) {
			tf.setText(jb[i].getText());
		}
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
		ex.eventProc();

	}
}
