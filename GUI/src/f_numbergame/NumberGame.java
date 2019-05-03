package f_numbergame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener{
//	1. 멤버변수 선언
	int getsu=4;
	JButton [][] la = new JButton[getsu][getsu];
		
	char [][]answer = new char [getsu][getsu];
	//첫번째 눌려진 버튼
	JButton firstClick;
	int firstRow,firstCol;
	
	public MyFrame() {
//		2. 멤버 객체 생성
		setLayout(new GridLayout(getsu,getsu));
		for(int i=0;  i< la.length; i++) {
			for (int j = 0; j < la.length; j++) {
				la[i][j] = new JButton();
				add(la[i][j]);
				la[i][j].addActionListener(this);
				answer[i][j]='0'; //문자초기화
				
			}
		}	
//		화면 붙이기 및 출력
		setSize(500,400);
		setVisible(true);
	}
	void initChar() {
		char alpha='0';
		AND:
		for (int i = 0; i < getsu*getsu;) {
			//임의의 알파벳 만들기
			if(i%2==0) {
				alpha = (char)('A'+(int)(Math.random()*26));
				for (int row = 0; row < answer.length; row++) {
					for (int col = 0; col < answer[row].length; col++) {
						if(answer[row][col]==alpha) continue AND;
					}
				}
			}
			//임의의 자리에  알파벳넣기
			boolean ok = false;
			do {
				int row = (int)(Math.random()*getsu);
				int col = (int)(Math.random()*getsu);
				if(answer[row][col]=='0') {
					answer[row][col]=alpha;
					i++;
					ok=true;
				}
			}while(!ok);
		}
	}
	void showAnswer() {
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				la[i][j].setText(String.valueOf(answer[i][j]));
			}
		}
//		try {
//			Thread.sleep(1000);
//			} catch (InterruptedException e) {}
//		for (int i = 0; i < answer.length; i++) {
//			for (int j = 0; j < answer.length; j++) {
//				la[i][j].setText(null);
//			}
//		}
	}
	
	public void actionPerformed(ActionEvent e) {
//		이벤트확인
		JButton obj = (JButton)e.getSource();
		//눌러진 버튼 비교
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if(obj==la[i][j]) {
					//첫번째 버튼인지 비교
					if(firstClick==null) {
						firstClick=obj;
						firstRow=i;
						firstCol=j;
						firstClick.setBackground(new Color(200,250,100));
						//색만들기 red,green,blue
					//두번째 버튼인지 비교	
					}else {
						if(answer[firstRow][firstCol]==answer[i][j]) {
							//둘 다 맞는경우 Color(0,0,0)
							//첫번째 누른 버튼 색 바꾸기
							firstClick.setBackground(new Color(0,0,0));
							
							//두번째 누른 버튼 색 바꾸기
							obj.setBackground(new Color(0,0,0));
						}else {
							firstClick.setBackground(null);
						}
						firstClick = null;
					}
				}
			}
		}
	}
}

public class NumberGame {

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.initChar();
		f.showAnswer();
	}
}
