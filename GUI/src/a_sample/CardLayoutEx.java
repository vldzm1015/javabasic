package a_sample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class CardLayoutEx extends JFrame 
{
 PanA  panA = new PanA();
 PanB  panB = new PanB();
 JPanel pan = new JPanel();
 CardLayout card;
 JButton btn = new JButton("확인");
 CardLayoutEx()
 { 
  card = new CardLayout();
  
  pan.setLayout( card );
  pan.add("1", panA );
  pan.add("2", panB );
 
  add( pan, BorderLayout.CENTER );
  add( btn, BorderLayout.NORTH );
  setSize( 300, 400 );
  setVisible( true );
 
  btn.addActionListener( new ActionListener() {
   public void actionPerformed( ActionEvent ev ){
    card.show( pan, "2");
   }
  });
 }

 public static void main(String[] args) 
 {
  new CardLayoutEx();
 }
}


class PanA extends JPanel
{
 PanA()
 {
  setBackground( Color.red );
 }
}


class PanB extends JPanel
{
 PanB()
 {
  setBackground( Color.yellow );
 }
}