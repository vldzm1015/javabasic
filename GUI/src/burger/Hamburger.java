package burger;

import java.awt.BorderLayout;

import java.awt.Button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Label;

import java.awt.Panel;

import java.awt.TextArea;

import java.awt.TextField;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Hamburger {

	int count = 0;
	String show = "";

	public Hamburger() {
		// 디자인단
		// 프레임 설정단
		JFrame frame = new JFrame("Guilty Pleasure");
		frame.setBounds(0, 0, 625, 500);
		frame.setBackground(Color.black);

		// 폰트
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);


		// 북쪽
		Panel pNorth = new Panel();
		pNorth.setBackground(new Color(0, 255, 215));
		pNorth.setLayout(null);
		pNorth.setSize(0, 300);
		pNorth.setFont(font);

		// 배열 설정 부분
		String menu[] = {"가나초코", "츄파춥스", "하리보"};
		int price[] = { 500, 200, 1800};

		JButton bt[] = new JButton[menu.length];
		JTextField suja[] = new JTextField[menu.length];
		Button minus[] = new Button[menu.length];
		Button plus[] = new Button[menu.length];
		JButton ok[] = new JButton[menu.length];
		JLabel l[] = new JLabel[menu.length];
		ImageIcon icon[] = new ImageIcon[menu.length];

		// 버튼 설정 부분
		for (int i = 0; i < menu.length; i++) {

			// 햄버거 버튼
			bt[i] = new JButton(menu[i]);

			if (i < 4) {
				bt[i].setBounds(100 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}
			icon[i] = new ImageIcon("src/burger/"+i+".PNG");
			bt[i].setIcon(icon[i]);

			// 숫자 txt 버튼
			suja[i] = new JTextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

			// "-" 버튼
			minus[i] = new Button("-");
			minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);

			// "+" 버튼
			plus[i] = new Button("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);

			// 가격
			l[i] = new JLabel(price[i] + "원");
			l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);

			pNorth.add(bt[i]);
			pNorth.add(suja[i]);
			pNorth.add(minus[i]);
			pNorth.add(plus[i]);
			pNorth.add(l[i]);
			pNorth.add(ok[i]);
		}

		// 중앙
		JTextArea ta = new JTextArea("", 0, 0);
		ta.setText("   상품명        단가        수량        합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// 남쪽
		JPanel pSouth = new JPanel();
		pSouth.setFont(font);
		pSouth.setBackground(new Color(255, 50, 215));

		JButton bt1 = new JButton("주문");
		JButton bt2 = new JButton("초기화");
		JButton bt3 = new JButton("닫기");

		pSouth.add(bt1);
		pSouth.add(bt2);
		pSouth.add(bt3);

		// 주문버튼
		bt1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");
				}
			}
		});

		// 초기화 버튼
		bt2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");
				}
			}
		});
		
		//bt3 닫기버튼
		bt3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 컴포넌트
		frame.add(pNorth, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(pSouth, BorderLayout.SOUTH);
		frame.setVisible(true);

		// 이벤트단
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// 햄버그 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);
					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					if (count > 0) {
						count = count - 1;
						suja[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					count = count + 1;
					suja[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			//확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand();
					ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
							+ "원" + "\n");
					ok[j].setEnabled(false);
				}
			});
		}

		// 끄기
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 메인
	public static void main(String[] args) {
		new Hamburger();
	}
}