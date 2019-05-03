package io.datastream;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DataStreamTest
{
	public static void main( String [] args )
	{
		UIForm  ui = new UIForm();
		ui.addToLayout();
		ui.eventProc();
	}
}
//-----------------------------------------
// 화면을 관리하는 클래스
class UIForm extends JFrame
{
	// 데이타를 저장할 변수
	String name;
	int		age;
	double 	height;
	char	bloodType;
	
	// 화면 GUI에 관련한 변수
	JTextField tfName, tfAge, tfHeight, tfBloodType;
	JButton	   bSave, bLoad;
	
	
	UIForm()
	{
		tfName 		= new JTextField(10);
		tfAge 		= new JTextField(10);
		tfHeight 	= new JTextField(10);
		tfBloodType = new JTextField(10);
		
		bSave		= new JButton("저장하기", new ImageIcon("../img/save.gif"));
		bLoad		= new JButton("읽어오기", new ImageIcon("../img/load.gif"));
		
	}
	
	// 화면 구성하는 메소
	void addToLayout()
	{
		JPanel pCenter = new JPanel();
		pCenter.setLayout( new GridLayout(5 ,2,10,10) );
		pCenter.add( new JLabel("이름") );
		pCenter.add( tfName );
		pCenter.add( new JLabel("나이") );
		pCenter.add( tfAge );
		pCenter.add( new JLabel("신장") );
		pCenter.add( tfHeight );
		pCenter.add( new JLabel("혈액형") );
		pCenter.add( tfBloodType );
		
		pCenter.add( bSave );
		pCenter.add( bLoad );
		
		getContentPane().add("Center", pCenter);
		
		setSize( 400, 300 );
		setVisible( true );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
	
	
	// 이벤트 처리하는 메소드 
	void eventProc()
	{
		BtnHandler bHdlr = new BtnHandler();
		bSave.addActionListener(bHdlr);
		bLoad.addActionListener(bHdlr);				
	}


	class BtnHandler implements ActionListener 
	{
		public void actionPerformed( ActionEvent ev ){

			Object evtBtn = ev.getSource();

			// "저장하기" 버튼이 눌렸을 
			if( evtBtn == bSave )
			{
				/*
				1. 텍스트필드에서 입력값 얻어와서 변수에 저장
				2. 파일출력스트림 생성 ( filter 포함 )
				3. 스트림에 출력
				4. 스트림 닫기
				5. 텍스트필드 초기화 
				*/
				name		= tfName.getText();
				age			= Integer.parseInt( tfAge.getText() );
				height		= Double.parseDouble( tfHeight.getText() );
				bloodType 	= ( tfBloodType.getText()).charAt(0);
				
				/** 
				 * @@@@@@@@@@@@@@@@@@@@@@@@@
				 * */
				try{
//					DataInputStream dos = new DataInputStream(new FileInputStream("person.txt"));
//					dos.readUTF(name);
//					dos.readInt(age);
//					dos.readDouble(height);
//					dos.readChar(bloodType);
//					dos.close();
					
					Person p = new Person(name, age, height, bloodType);
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
					oos.writeObject(p);
					oos.close();
					
				}catch( Exception ex ){ 
					System.out.println("쓰기 실패");
					ex.printStackTrace();
				}
				
				tfName.setText("");
				tfAge.setText("");
				tfHeight.setText("");
				tfBloodType.setText("");
					
				
			}
			// "읽어오기" 버튼이 눌렸을 때
			else if ( evtBtn == bLoad )
			{
					
			/** 
			 * @@@@@@@@@@@@@@@@@@@@@@@@@
			 * */
			/*
			1. 파일입력스트림 생성 (filter 포함 )
			2. 스트림에서 데이타 읽어서 변수에 저장
			3. 텍스트필드에  출력
			4. 스트림 닫기 			
			*/
				try{
//					DataInputStream dos = new DataInputStream(new FileInputStream("person.txt"));
//					name=dos.readUTF();
//					age=dos.readInt();
//					height=dos.readDouble();
//					bloodType=dos.readChar();
//					dos.close();
//					Person p = new Person(name, age, height, bloodType);
					ObjectInputStream oos = new ObjectInputStream(new FileInputStream("person.txt"));
					Person p = (Person)oos.readObject();
					oos.close();
					
					name = p.getName();
					age = p.getAge();
					height = p.getHeight();
					bloodType = p.getBloodType();
				}catch( Exception ex ){
					System.out.println("읽기 실패"+ex.toString());
				}

					tfName.setText( name );
					tfAge.setText(String.valueOf( age ));
					tfHeight.setText(String.valueOf( height ));
					tfBloodType.setText(String.valueOf( bloodType ));				
				

				}	

		}
	}
}