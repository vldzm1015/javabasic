package b_operator;

public class Ex08_ShortCircuitLogic {

	public static void main(String[] args) {
		
	//  일반논리 ( && , || ) 
    //     - 앞에 있는 값이나오면 뒤에 부분은 계산을 하지 않기 때문에 값이 다르게 나옴
		int a = 3;
		if( a>3 && ++a>3) {
			System.out.println("조건만족");  	
			// 조건불만족 출력안됨
		}
		System.out.println( "A=" +a );   	// a=3 			
		if( a>1 || ++a>3) {									
			System.out.println("조건만족2"); 	
			// 조건만족 출력됨
		}
		System.out.println( "A=" +a );   			
		// a=3   
	
		
		
		
	//  이진논리(& , | ) : 평균적으로 생각하는 값이 나옴
		int b = 3;
		if( b>3 & ++b>3) {
			System.out.println("조건만족");  	
			// 조건불만족 출력안됨
		}
		System.out.println( "B=" +b );   // b=4
		if( b>1 | ++b>3) {
			System.out.println("조건만족2"); 	
			// 조건만족 출력됨
		}
		System.out.println( "B=" +b );  // b=5
	}
}
