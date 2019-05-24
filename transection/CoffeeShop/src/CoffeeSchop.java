
import java.awt.*;
import javax.swing.*;

import  view.ReserveView;
import  view.SalesView;
import  view.InventoryView;

public class CoffeeSchop extends JFrame 
{
	ReserveView	reserve;
	InventoryView			inventory;
	SalesView			sales;

	public CoffeeSchop(){
		//각각의 화면을 관리하는 클래스 객체 생성
			reserve = new ReserveView();
			inventory		= new InventoryView();
			sales			= new SalesView();

			JTabbedPane  pane = new JTabbedPane();
			pane.addTab("예약관리", reserve );
			pane.addTab("판매관리", sales );
			pane.addTab("재고관리", inventory);

			pane.setSelectedIndex(1);

			// 화면크기지정
			add("Center", pane );
			setSize(800,600);
			setVisible( true );

			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	public static void main(String[] args) 
	{
			new CoffeeSchop();
	}
}
