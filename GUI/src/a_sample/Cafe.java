package a_sample;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cafe extends JFrame{
   
   JFrame f;
   JButton bOrder,bCancle;
   JTextArea ta;
   JTextField tf;
   
   
   Cafe(){
      f = new JFrame("Min's cafe");
      f.setBounds(0, 0, 625, 1000);
        f.setBackground(Color.black);
      
      bOrder = new JButton("주문");
      bCancle = new JButton("취소");
      
      tf = new JTextField(30);
      ta = new JTextArea(10,50);
      
      
        
        // 중앙
   
   }

   //화면 구성
   void addLayout() {
      //남쪽
      JPanel pSouth = new JPanel();
   
       pSouth.setBackground(new Color(255, 255, 215));
       pSouth.add(bOrder);
       pSouth.add(bCancle);
        
      JPanel pCenter = new JPanel();
      
      
      //북쪽
      JPanel pNorth = new JPanel();
      pNorth.setBackground(new Color(255, 255, 215));
       pNorth.setLayout(null);
       pNorth.setSize(0, 500);
       
       //배열 설정
       String menu[] = { "아메리카노", "카페라떼", "에스프레소", "돌체라떼", "카푸치노", "아포가또", "마끼야또", "바닐라라떼" };
        int price[] = { 3000, 3500, 2000, 4500, 4000, 4500, 4000, 4500 };
        JButton bt[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton ok[] = new JButton[menu.length];
        Label l[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];
        
        
        for (int i = 0; i < menu.length; i++) {
            // 햄버거 버튼
            bt[i] = new JButton(menu[i]);
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
            icon[i] = new ImageIcon("src/cafe/" +i+ ".PNG");
            System.out.println("src/cafe/" +i+ ".PNG");
            bt[i].setIcon(icon[i]);
            
            // 숫자 txt 버튼
            suja[i] = new TextField("0");
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
            l[i] = new Label(price[i] + "원");
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
      
      // 4.화면에 출력하기
//      f.add(pCenter, BorderLayout.CENTER);
//      f.add(pSouth, BorderLayout.SOUTH);
      f.add(pNorth, BorderLayout.NORTH);
      f.setSize(600,480);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }
   

   public static void main(String[] args) {
      Cafe cm = new Cafe();
      cm.addLayout();
      
   }

}