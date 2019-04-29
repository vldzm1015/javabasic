package e_static;
/*
 * - static 변수 : 각 객체에서 공유하려고
 *  			메모리에 단 하나임
 * - static 메소드 : 여러개 가능
 *  
 * - static을 붙이면 클래스명 접근이 가능
 *   =>static 변수를 class변수라고 부르기도 함.
 */
public class Book {  

	private static int count;
	// static을 안붙이면 하나씩 따로 세어짐
	//static 변수
	
	public  Book() {
		count++;
		System.out.println("책 한권 생성");
	}
	static public int getCount() {  
		//static 메소드
		return count;
		
	}
}
/* private static int count; = static 변수
 * static public int getCount(){ = static 메소드  
 */





