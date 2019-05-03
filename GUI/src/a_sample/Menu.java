package a_sample;
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import javax.swing.*; 
import javax.swing.table.*; 

public class Menu extends JFrame implements ActionListener 
{ 
  JTable table; 
  JTabbedPane pane = new JTabbedPane(); 
  JSpinner[] sp_1_spin, sp_2_spin, sp_3_spin; 
  JLabel[] lb_1_coffee; 
  JLabel[] lb_1_food; 
  JLabel[] lb_1_dessert; 
  JButton btn_1_OK, btn_2_OK, btn_Cancel; 
  int cnt = 1; 
  Vector<String[]> menuMain = new Vector<String[]>(); // 문자열로 부터 만들어질 메인 메뉴 배열 
  Vector<String[]> menuSide1 = new Vector<String[]>(); 
  Vector<String[]> menuSide2 = new Vector<String[]>(); // 문자열로 부터 만들어질 사이드 메뉴 
  // 배열 
  String mainMenu = "아메리카노*2500*카페라떼*2500*모카치노*2500*카페라떼*2500*모카치노*2500*카푸치노*2500*에스프레소*2500*카페모카*2500"; 
  String sideMenu1 = "햄버거*3000*바케트*3000*모카빵*3000*돈가스*3000*스파게티*3000*스테이크*4000*고구마브레드*3000*볶음밥*3000"; 
  String sideMenu2 = "아이스크림*3000*쿠키*3000*치즈샌드위치*3000*샌드위치1*3000*샌드위치2*3000*샌드위치3*1000*샌드위치4*3000"; 
  JPanel mainPanel = new JPanel(); 
  JPanel sidePanel1 = new JPanel(); 
  JPanel sidePanel2 = new JPanel(); 
  int totalPrice; 
  private void createArray() 
  { 
    // mainMenu, sideMenu문자열을 분리해서 제품명과 가격으로 구성된 String배열을 만든 후 
    // 각각 menuMain, menuSide 벡터에 저장 
    StringTokenizer st = new StringTokenizer(mainMenu, "*"); 
    while(st.hasMoreElements()) 
    { 
      String[] data = new String[2]; 
      data[0] = st.nextToken(); 
      data[1] = st.nextToken(); 
      menuMain.add(data); 
   } 
   st = new StringTokenizer(sideMenu1, "*"); 
   while(st.hasMoreElements()) 
   { 
     String[] data = new String[2]; 
     data[0] = st.nextToken(); 
     data[1] = st.nextToken(); 
     menuSide1.add(data); 
  } 
  st = new StringTokenizer(sideMenu2, "*"); 
  while(st.hasMoreElements()) 
  { 
    String[] data = new String[2]; 
    data[0] = st.nextToken(); 
    data[1] = st.nextToken(); 
    menuSide2.add(data); 
 } 
} 
private void createMain() 
{ 
  sp_1_spin = new JSpinner[menuMain.size()]; 
  lb_1_coffee = new JLabel[menuMain.size()]; 
  mainPanel.setLayout(new GridLayout(0, 2)); 
  mainPanel.add(new JLabel("커피를 선택하시오")); 
  mainPanel.add(new JLabel()); // 줄 맞추기위한 빈 레이블 
  for(int i = 0; i < menuMain.size(); i++) 
  { 
    String str = menuMain.get(i)[0] + "  -  "; 
    str += (menuMain.get(i)[1] + "원"); 
    lb_1_coffee[i] = new JLabel(str); 
    SpinnerNumberModel scoreModel = new SpinnerNumberModel(0, 0, 10, 1); 
    // 초기값, 최소값, 최대값, 증가값 
    sp_1_spin[i] = new JSpinner(scoreModel); 
    // 각각 만들어주지 않으면 하나 클릭하면 다른 쪽도 바뀜 
    mainPanel.add(lb_1_coffee[i]); 
    mainPanel.add(sp_1_spin[i]); 
 } 
} 
private void createSide1() 
{ // 음료수 패널 생성 
  sp_2_spin = new JSpinner[menuSide1.size()]; 
  lb_1_food = new JLabel[menuSide1.size()]; 
  sidePanel1.setLayout(new GridLayout(0, 2)); 
  sidePanel1.add(new JLabel("식사를 선택하세요")); 
  sidePanel1.add(new JLabel()); // 줄 맞추기위한 빈 레이블 
  for(int i = 0; i < menuSide1.size(); i++) 
  { 
    String str = menuSide1.get(i)[0] + "  -  "; 
    str += (menuSide1.get(i)[1] + "원"); 
    lb_1_food[i] = new JLabel(str); 
    SpinnerNumberModel scoreModel = new SpinnerNumberModel(0, 0, 10, 1); 
    // 초기값, 최소값, 최대값, 증가값 
    sp_2_spin[i] = new JSpinner(scoreModel); 
    // 각각 만들어주지 않으면 하나 클릭하면 다른 쪽도 바뀜 
    sidePanel1.add(lb_1_food[i]); 
    sidePanel1.add(sp_2_spin[i]); 
 } 
} 
private void createSide2() 
{ // 음료수 패널 생성 
  sp_3_spin = new JSpinner[menuSide2.size()]; 
  lb_1_dessert = new JLabel[menuSide2.size()]; 
  sidePanel2.setLayout(new GridLayout(0, 2)); 
  sidePanel2.add(new JLabel("디저트를 선택하세요")); 
  sidePanel2.add(new JLabel()); // 줄 맞추기위한 빈 레이블 
  for(int i = 0; i < menuSide2.size(); i++) 
  { 
    String str = menuSide2.get(i)[0] + "  -  "; 
    str += (menuSide2.get(i)[1] + "원"); 
    lb_1_dessert[i] = new JLabel(str); 
    SpinnerNumberModel scoreModel = new SpinnerNumberModel(0, 0, 10, 1); 
    // 초기값, 최소값, 최대값, 증가값 
    sp_3_spin[i] = new JSpinner(scoreModel); 
    // 각각 만들어주지 않으면 하나 클릭하면 다른 쪽도 바뀜 
    sidePanel2.add(lb_1_dessert[i]); 
    sidePanel2.add(sp_3_spin[i]); 
 } 
} 
public Menu() 
{ 
  createArray(); 
  createMain(); 
  pane.addTab("커피", mainPanel); 
  createSide1(); 
  pane.addTab("식사류", sidePanel1); 
  createSide2(); 
  pane.addTab("디저트", sidePanel2); 
  add(pane, BorderLayout.NORTH); 
  Vector<String> colName = new Vector<String>(); // 테이블 열제목. vector, 
  // Object[], String[] 배열 
  // 모두 가능 
  colName.addElement("번호"); 
  colName.addElement("메뉴"); 
  colName.addElement("가격"); 
  colName.addElement("수량"); 
  colName.addElement("합계"); 
  DefaultTableModel dtm = new DefaultTableModel(colName, 0); 
  // 직접 테이블을 만들지 않고 디폴트테이블모델 생성 
  table = new JTable(dtm); // 후 그 모델로 테이블 생성. 이렇게 해야 모델을 이용해서 수정 가능 
  JScrollPane scroll = new JScrollPane(table); 
  add(scroll, BorderLayout.CENTER); 
  JPanel p3 = new JPanel(); 
  btn_1_OK = new JButton("추가"); 
  p3.add(btn_1_OK); 
  btn_Cancel = new JButton("취소"); 
  btn_Cancel.addActionListener(new CancelHandler()); 
  p3.add(btn_Cancel); 
  btn_2_OK = new JButton("주 문 완 료"); 
  p3.add(btn_2_OK); 
  add(p3, BorderLayout.SOUTH); 
  setDefaultCloseOperation(EXIT_ON_CLOSE); 
  setSize(600, 900); 
  setVisible(true); 
  btn_1_OK.addActionListener(this); 
  btn_2_OK.addActionListener(this); 
} 
public static void main(String[] args) 
{ 
  new Menu(); 
} 
public void actionPerformed(ActionEvent e) 
{ 
  DefaultTableModel model = (DefaultTableModel) table.getModel(); 
  for(int i = 0; i < menuMain.size(); i++) 
  { 
    if(!sp_1_spin[i].getValue().toString().equals("0")) 
    { 
      Object[] ob = new Object[4]; 
      //ob[0] = cnt++; 
      ob[1] = menuMain.get(i)[0]; 
      ob[2] = menuMain.get(i)[1]; 
      ob[3] = sp_1_spin[i].getValue().toString(); 
      //************************************** 
      int j; 
      //테이블에서 주문한 메뉴가 있는지 검사 
      for(j=0;j < table.getRowCount();j++) 
      { 
        String strMenu = (String)table.getValueAt(j, 1); 
        if(strMenu.equals(ob[1]))//이미 주문한 메뉴라면 
        { 
          int orderCount = Integer.parseInt((String)ob[3]);//주문한 갯수 
          int tableMenuCount = Integer.parseInt((String)table.getValueAt(j, 3));//주문된 갯수 
          String result = Integer.toString(tableMenuCount + orderCount);//두 갯수의 합계 
          table.setValueAt(result, j, 3);//합계를 테이블에 넣기 
          break; 
       } 
    } 
    if(j == table.getRowCount()) 
    { 
      ob[0] = cnt++; 
      model.addRow(ob); 
   } 
} 
} 
for(int i = 0; i < menuSide1.size(); i++) 
{ 
  if(!sp_2_spin[i].getValue().toString().equals("0")) 
  { 
    Object[] ob = new Object[4]; 
    //ob[0] = cnt++; 
    ob[1] = menuSide1.get(i)[0]; 
    ob[2] = menuSide1.get(i)[1]; 
    ob[3] = sp_2_spin[i].getValue().toString(); 
    //****************************************** 
    int j; 
    //테이블에서 주문한 메뉴가 있는지 검사 
    for(j=0;j < table.getRowCount();j++) 
    { 
      String strMenu = (String)table.getValueAt(j, 1); 
      if(strMenu.equals(ob[1]))//이미 주문한 메뉴라면 
      { 
        int orderCount = Integer.parseInt((String)ob[3]);//주문한 갯수 
        int tableMenuCount = Integer.parseInt((String)table.getValueAt(j, 3));//주문된 갯수 
        String result = Integer.toString(tableMenuCount + orderCount);//두 갯수의 합계 
        table.setValueAt(result, j, 3);//합계를 테이블에 넣기 
        break; 
     } 
  } 
  if(j == table.getRowCount()) 
  { 
    ob[0] = cnt++; 
    model.addRow(ob); 
 } 
} 
} 
for(int i = 0; i < menuSide2.size(); i++) 
{ 
  if(!sp_3_spin[i].getValue().toString().equals("0")) 
  { 
    Object[] ob = new Object[4]; 
    //ob[0] = cnt++; 
    ob[1] = menuSide2.get(i)[0]; 
    ob[2] = menuSide2.get(i)[1]; 
    ob[3] = sp_3_spin[i].getValue().toString(); 
    //**************************************************** 
    int j; 
    //테이블에서 주문한 메뉴가 있는지 검사 
    for(j=0;j < table.getRowCount();j++) 
    { 
      String strMenu = (String)table.getValueAt(j, 1); 
      if(strMenu.equals(ob[1]))//이미 주문한 메뉴라면 
      { 
        int orderCount = Integer.parseInt((String)ob[3]);//주문한 갯수 
        int tableMenuCount = Integer.parseInt((String)table.getValueAt(j, 3));//주문된 갯수 
        String result = Integer.toString(tableMenuCount + orderCount);//두 갯수의 합계 
        table.setValueAt(result, j, 3);//두 갯수의 합계를 테이블에 넣기 
        break; 
     } 
  } 
  if(j == table.getRowCount()) 
  { 
    ob[0] = cnt++; 
    model.addRow(ob); 
 } 
} 
} 
//*****주문한 갯수를 모두 0으로***** 
for(int i = 0; i < menuMain.size(); i++) 
{ 
  sp_1_spin[i].setValue(0); 
} 
for(int i = 0; i < menuSide1.size(); i++) 
{ 
  sp_2_spin[i].setValue(0); 
} 
for(int i = 0; i < menuSide2.size(); i++) 
{ 
  sp_3_spin[i].setValue(0); 
} 
totalPrice = 0; 
//합계 계산 
for(int i=0;i < table.getRowCount();i++) 
{ 
  int tableMenuCount = Integer.parseInt((String)table.getValueAt(i, 3));//주문된 갯수 
  int price = Integer.parseInt((String)table.getValueAt(i, 2));//주문된 메뉴의 가격 
  table.setValueAt(Integer.toString(tableMenuCount*price), i, 4);//갯수와 메뉴가격을 곱해 넣기            
  totalPrice += (tableMenuCount*price);// 총합계 
}    
repaint(); 
} 
@Override 
public void paint(Graphics g) 
{ 
  super.paint(g); 
  g.drawString(Integer.toString(totalPrice)+"원", 500, 700); 
} 
class CancelHandler implements ActionListener 
{ 
  public void actionPerformed(ActionEvent e) 
  { 
    DefaultTableModel model = (DefaultTableModel) table.getModel(); 
    while(table.getRowCount() > 0) 
    model.removeRow(0); 
 } 
} 
} 