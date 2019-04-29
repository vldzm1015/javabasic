package e_method;

public class Ex01_흐름 {

	public static void main(String[] args) {  // 5라인부터 시작해서  6,7라인 타고 
		System.out.println("main 시작"); 		  //  11번 라인으로 점프했다가 마치고		
		method();							  // 8번라인으로 갔다가 마무리.	
		System.out.println("main 끝");

	}
	// static 메소드에서는 static만 접근가능
	static void method() {
		System.out.println("method실행");
	}
}
