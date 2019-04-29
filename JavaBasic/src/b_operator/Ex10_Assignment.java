package b_operator;
/*
 * 	 대입연산자 : =
 * 		- 축약 대입연산자(  산술 / 이진논리 / 쉬프트 )
 */
public class Ex10_Assignment {

	public static void main(String[] args) {
		int a = 10, b = 7;
		a+=b;  // a=a+b;
		System.out.println( "A=" +a );  
		a-=b;  // a=a-b;
		System.out.println( "A=" +a );  
		a*=b;  // a=a*b;
		System.out.println( "A=" +a );
		a%=b;  // a=a%b;
		System.out.println( "A=" +a );
		a/=b;  // a=a/b;
		System.out.println( "A=" +a );

	}

}
