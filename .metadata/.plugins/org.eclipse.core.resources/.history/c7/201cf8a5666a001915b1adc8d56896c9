package h_inherit;

public class Main {

	public static void main(String[] args) {
		//1.클래스 생성과 메소드 호출 확인
		//		Umma u = new Umma();
		//		u.gene();
		//		u.job();
		//		//d.study();
		//		// ^불가능
		//		
		//		Ddal d = new Ddal();
		//		d.gene();
		//		d.study();
		//		d.job();
		// 자식객체는 부모객체 사용가능

		// 2. 부모변수에 자식객체 생성
//		//Ddal dd = new Umma();
//		Umma uu = new Ddal();
//		// Ddal 이 메모리가 더 크기때문에 가능
//		uu.gene();  // **오버라이딩**
//		uu.job();
//		//uu.study();

		/* overriding
		 *  -부모자식간의 메소드 명이 동일
		 *  -인자동일/리턴형동일
		 *  -접근지정자는 같거나 크거나
		 *  -같은 접근지정자 사용권장
		 *  -부모변수에서 자식의 멤버 호출가능
		 */
		/* 개발자 입장의 상속
 			부모클래스의 멤버로 있는 경우 - 그냥 호출
 			부모클래스에 없는 경우 - 추가
 			부모클래스에 있지만 수정이 필요 - overriding
		 */
		
		/* 3.형변환(casting) -상속관계에서만 가능
			String a = new String("hello");
			StringBuffer b = (StringBuffer)a;
		 */
//		Ddal d = new Ddal();
//		Umma u = (Umma)d;
//		d.study();
		
//		Umma uu = new Ddal();
//		uu.gene();
//		uu.job();
//		Ddal dd = (Ddal)uu; //형변환
//		dd.study();
		
		// 4. instanceof 연산자
		Ddal d = new Ddal();
		if( d instanceof Ddal) {
			System.out.println("Ddal 객체임");
		}
		if(d instanceof Umma) {
			System.out.println("Umma 객체임");
		}
		if(d instanceof Object) {
			System.out.println("Object 객체임");
		}// Object 클래스는 기본으로 들어감
		 // 모든 클래스는 Object무조건 상속받아짐
	}
}
