package e_method;
/*
 * CallByReference
 * 넘어가는 값이 참조형일 경우 저장된 값도 바뀌어 저장된다.
 * (참조형 : 클래스, 배열 (new 연산자 이용해서 heap에 메모리 핫딜))
 */
public class Ex07_CallByReference {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("행복하자");
		StringBuffer b = new StringBuffer("짝꿍");
		add(a,b);					//참조형
		System.out.println("2.A= "+a+"B= "+b);
	}
	static void add(StringBuffer a, StringBuffer b) {
		a.append(b);
		System.out.println("1.A= "+a+"B= "+b);
	}
}
