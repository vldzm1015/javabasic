package e_method;

public class Ex02_인자와변환4 {
	
	static int a, b; //멤버변수 : 모든 곳에서 가져다 쓸 수 있음, 하지만 메모리 사용이 많다
	static int sum;
	public static void main(String[] args) {
		a=10;
		b=20;
		add();
	System.out.println("합 : " + sum );	
	}
	static void add() {
		int sum =a + b;
	}
}
