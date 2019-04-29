package e_method;

public class Ex05_overloading {
/*
 * overloading 
 *	 :동일한 이름의 메소드들 (같은 역할일 때)
 * 		-인자의 자료형과 갯수 달라야함
 *  [주의할 점] add(1,2)
 *  int  add(int a, int b){}
 *  double add(int a, int b){}
 *  -> 인자의 자료형이 같으면 컴파일 오류남. 
 *  리턴형만 다르면 컴파일 오류발생.
 *  
 *  -----------------------------------------
 *  add(1)
 *  add(1,2)
 *  add(1,2,3)
 *  
 *  void add (int a) {}
 *  void add (int a, int b) {}
 *  void add (int a, int b, int c) {}
 *  
 *  =>  자료형이 다르기때문에 overloading맞음
 *  ----------------------------------------
 */
	public static void main(String[] args) {
		int a=5,b=7;
		add(a,b);
		int c = 3; 
		double d=3.6;
		add(c, d);
	}
	static void add( int c, double d) {
		System.out.println(c+d);
	}
	static void add(int a, int b) {
		System.out.println(a+b);
	}
	
}
