
import java.awt.*;
import javax.swing.*;

import  view.ReserveView;
import  view.SalesView;
import  view.InventoryView;
import view.ProfitView;

public class CoffeeSchop extends JFrame 
{
	ReserveView	reserve;
	InventoryView			inventory;
	SalesView			sales;
	ProfitView 			profit;

	public CoffeeSchop(){
		//각각의 화면을 관리하는 클래스 객체 생성
		reserve = new ReserveView();
		inventory		= new InventoryView();
		sales			= new SalesView();
		profit			= new  ProfitView();

		JTabbedPane  pane = new JTabbedPane();
		pane.addTab("예약관리", reserve );
		pane.addTab("판매관리", sales );
		pane.addTab("재고관리", inventory);
		pane.addTab("매출관리", profit);

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
