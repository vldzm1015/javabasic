package e_method;
/*
 * CallByValue 
 * 넘어가는 값이 기본형일 경우에는 저장된 값이 바뀌지 않는다. (new)가 없다.
 * (논리형:boolean, 문자형:char, 정수형:int/long, 실수형 : double)
 */

public class Ex07_CallByValue {

	public static void main(String[] args) {
		int a = 10, b=20;
		add(a,b); 							
		System.out.println("2.A = " +a+" B = "+b);		// a= 10	b= 20

	}
	static void add(int a, int b) {
		a+=b;
		System.out.println("1.A = "+a+" B = "+b); 	// a= 30	b= 20 
	}
}
