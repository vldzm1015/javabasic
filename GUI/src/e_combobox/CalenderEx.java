package e_combobox;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;


public class CalenderEx {
	JFrame f;
	JComboBox cbY,cbM,cbD;
	JButton b;
	JLabel la;
	int [] lastDays = {31,28,31,30,31,30,31,31,30,31,30,31};
	CalenderEx(){
//		객체생성
		f = new JFrame("날짜");
		Integer yy[] = new Integer[30];
		for (int i = 0, year=1990; i < yy.length; i++,year++) {
			yy[i]=year;
		}
		Integer mm[] = new Integer[12];
		for (int i = 0; i < mm.length; i++) {
			mm[i]=i+1;
		}
		
		cbY = new JComboBox(yy);
		cbM = new JComboBox(mm);
		cbD = new JComboBox();
		b = new JButton("▶");
		la = new JLabel("요일");
	}
	void addLayout() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(cbY); p.add(new JLabel("년"));
		p.add(cbM); p.add(new JLabel("월"));
		p.add(cbD); p.add(new JLabel("일"));
		p.add(b);
		p.add(la);
		f.add(p);
		
		f.setSize(500,400);
		f.setVisible(true);
		
	}
	void initDate() {
		Calendar c = Calendar.getInstance();
//		연,월을 먼저 구해준다.
		int y = c.get(Calendar.YEAR);
		cbY.setSelectedItem(y);
		int m = c.get(Calendar.MONTH)+1;
//		항상 월에는 +1
		cbM.setSelectedItem(m);
		
		setDay(); //일
//		연,월 구해온 값으로 일자지정.
		int d = c.get(Calendar.DATE);
		cbD.setSelectedItem(d);
		
		setDate(); //요일
		
	}
	
	void eventProc() {
		CbHdlr cb = new CbHdlr();
		cbY.addActionListener(cb);
		cbM.addActionListener(cb);
		b.addActionListener(cb);
	}
	class CbHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==cbY|obj==cbM)setDay();
			else if(obj==b)setDate();
		}
	}
	void setDay() {
//		윤년이라면 lastDays[1]=29로 지정
//		평년이라면 lastDays[1]=28로 지정
//		확인 2016/2월은 윤년.
		int year = (Integer)cbY.getSelectedItem();
        if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            lastDays[1]=29;
        } else {
        	lastDays[1]=28;
        }
		int month = cbM.getSelectedIndex();
		cbD.removeAllItems();
		for(int i=1; i<=lastDays[month];i++) {
			cbD.addItem(i);
		}
	}
	void setDate() {
		System.out.println(la.getText());
		int y = (Integer)cbY.getSelectedItem();
		int m = (Integer)cbM.getSelectedItem();
		int d = (Integer)cbD.getSelectedItem();
		Calendar c = Calendar.getInstance();
		c.set(y,m-1,d);
		int yoil =  c.get(Calendar.DAY_OF_WEEK);
		String[ ] strDate = { "일","월","화","수","목","금","토" };
		la.setText(strDate[yoil-1]);
	}
	public static void main(String[] args) {
		CalenderEx cal = new CalenderEx();
		cal.addLayout(); //화면 붙이기 및 출력
		cal.initDate();  //날짜초기화
		cal.eventProc(); //화면처리
		
	}
}
