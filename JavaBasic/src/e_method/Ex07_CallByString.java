package e_method;
/* 
 * Call By String
 * 원래는 call by reference지만
 * String 클래스 특성상 내용이 변경되는 순간 메모리를 새로 잡음.  
 */

public class Ex07_CallByString {

	public static void main(String[] args) {
		String a = new String("행복하자");
		String b = new String("짝꿍");
		add(a,b);					//참조형
		System.out.println("2.A= "+a+"B= "+b);  // A=행복하자  B=짝꿍
	}
	static void add(String a, String b) {
		a += (b);
		System.out.println("1.A= "+a+"B= "+b); // A=행복하자 짝꿍  B=짝꿍
	}
}
