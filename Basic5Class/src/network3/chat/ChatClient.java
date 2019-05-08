package network3.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

class ChatClient implements ActionListener, Runnable {
    JFrame f;

    JTextField connTF, sendTF;
    JButton connB, sendB;
    JTextArea ta;

    Socket s;
    BufferedReader in;
    OutputStream out;

    // 추가0 : 대화명을 바꾸기
    JTextField changeNameTF;
    JButton changeNameB;

    // 추가2 : 방인원의 대명 보여주기
    // 변수 선언
    JList memberList;
    Vector list;

    public ChatClient() {
        f = new JFrame( "Chat Client" );


        connTF = new JTextField( );
        sendTF = new JTextField( );
        connB = new JButton( "접 속" );
        sendB = new JButton( "확 인" );
        ta = new JTextArea( 15, 40 );

        // 추가0: 대화명 바꾸기
        changeNameTF = new JTextField( "guest", 10 );
        changeNameB = new JButton( "바꾸기" );
        JPanel p_changeName = new JPanel( );
        p_changeName.add( new JLabel( "대화명 : " ), "West" );
        p_changeName.add( changeNameTF, "Center" );
        p_changeName.add( changeNameB, "East" );

        JPanel p_serverName = new JPanel( );
        p_serverName.setLayout( new BorderLayout( ) );
        p_serverName.add( new JLabel( "서버입력 : " ), "West" );
        p_serverName.add( connTF, "Center" );
        p_serverName.add( connB, "East" );

        JPanel p_north = new JPanel( );
        p_north.setLayout( new GridLayout( 1, 2 ) );
        p_north.add( p_changeName );
        p_north.add( p_serverName );

        JPanel p2 = new JPanel( );
        p2.setLayout( new BorderLayout( ) );
        p2.add( new JLabel( "메세지입력 : " ), "West" );
        p2.add( sendTF, "Center" );
        p2.add( sendB, "East" );

        // 추가2 : 방인원의 대명 보여주기
        memberList = new JList( );
        list = new Vector( );
        JPanel p_east = new JPanel( );
        p_east.setLayout( new BorderLayout( ) );
        p_east.add( "North", new JLabel( "   우 리 방 멤 버   " ) );
        p_east.add( "Center", memberList );


        f.getContentPane( ).add( "North", p_north );
        f.getContentPane( ).add( "Center", new JScrollPane( ta ) );
        f.getContentPane( ).add( "South", p2 );
        f.getContentPane( ).add( "East", p_east );

        //f.setSize(500, 300);
        f.pack( );
        f.setVisible( true );

        connTF.addActionListener( this );
        connB.addActionListener( this );
        sendTF.addActionListener( this );
        sendB.addActionListener( this );

        //  추가0: 대화명 바꾸기
        changeNameTF.addActionListener( this );
        changeNameB.addActionListener( this );
        
        //윈도우에 X버튼 처리
        f.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				if(s.isConnected()) {
					try {
						out.write("/exit  bye \n".getBytes());
						in.close();
						out.close();
						s.close();
					} catch (Exception ex) {  }
				}
				System.exit(0);
			}
			
		});
    }// 생성자 종료

    
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource( );

        if (o == connTF || o == connB) {            //접속 엔터치거나 버튼을 클릭했을 때 connPro()을 호출한다는 의미
            connProc( );
        } else if (o == sendTF || o == sendB) {
            sendProc( );
        } else if (o == changeNameTF || o == changeNameB) {
            changeNameProc( );
        }
    } // actionPerformed ends


    void changeNameProc() {
//        JOptionPane.showMessageDialog( null, "대화명을 바꿉니다" );
        // "/name 대화명\n" 서버에 전송해서 대화명 변경 가능하게 하기
        String msg = "/name " + changeNameTF.getText( ) + "\n";
        try {
            out.write( msg.getBytes( ) );
        } catch (IOException e) {
            ta.append( "변경 실패" + e.getMessage( ) );
        }
    }

    void connProc() {
//      JOptionPane.showMessageDialog(null, "서버에 접속합니다");
        //1.소켓생성
        //2.입출력 스트림 얻어오기
        try {
            s = new Socket( connTF.getText( ), 1234 );      //sever가 port번호를 1234 갖고 있어서 맞춰준다
            out = s.getOutputStream( );
            in = new BufferedReader( new InputStreamReader( s.getInputStream( ) ) ); //InputStreamReader는 형변환해주는 거
            ta.setText( "접속 성공 \n" );

            new Thread( this ).start( );

            enterRoom( );
        } catch (IOException e) {
            ta.setText( "접속 실패" + e.getMessage( ) );
        }

    } // connProc ends

    private void enterRoom() {
        String msg = "/start " + changeNameTF.getText( ) + "\n";
        try {
            out.write( msg.getBytes( ) );
        } catch (IOException e) {
            ta.append( "실패" + e.getMessage( ) );
        }
    }

    public void run() {
        while (s.isConnected( )) {
            try {
                String msg = in.readLine( );

                StringTokenizer st = new StringTokenizer( msg );
                String keyword = st.nextToken( );
                if (keyword.equals( "/member" )) {
                    // 뒤에 단어를 리스트 출력
                    list.removeAllElements(); // 내용 지우기
                    while (st.hasMoreTokens( )) {
                        // 각 대화명들이 Vector 에 추가
                        list.add( st.nextToken( ) );
                        memberList.setListData(list );
                    }
                    continue;
                }

                ta.append( msg + "\n" );
                ta.setCaretPosition( ta.getDocument( ).getLength( ) );
            } catch (IOException e) {
                e.printStackTrace( );
                return;
            }
        }
    }

    void sendProc() {
//      JOptionPane.showMessageDialog(null, "메세지를 전송합니다");
        String msg = sendTF.getText( ) + "\n";

        try {
            out.write( msg.getBytes( ) );
            sendTF.setText( null );
        } catch (IOException ex) {
            ta.append( "메시지전송 실패 :" + ex.getMessage( ) );
        }

    }// sendProc ends


    public static void main(String[] args) {
        new ChatClient( );
    }

}// ChatClient ends