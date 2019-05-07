package a_datatype;

public class Ex02_Caution {

	public static void main(String[] args) {
		// 실수형
		// float f;   // Byte 
		double f;			// 1. 변수선언
		f=3.6F; 				// 2. 값 지정
		System.out.println("실수:" + f);

		// 문자형 - 정수형
		char ch;		// 1. 변수선언
		ch = 65;			// 2. 값 지정
		System.out.println("ch값:" + ch);
		
//		int i;
//		i='a'; 
		int i='a';				//  변수선언 + 값 지정
		System.out.println("i값: "  + i);
		
		long l = 10000000000L;   //  변수선언 + 값 지정
		System.out.println("l값: "  + l);
//		int i2= 10000000000L;
		
		// 형변환 - casting
		// double 는 실수형이라 소수점까지 가능
		//100으로 해도 실수형인 100.0까지 나옴
		double db = (double)100; 
		System.out.println("db값: "  + db);
		
		// int 는 정수형이라 소수점이 불가능
		//100.1 로 해도 정수형인 100까지만 나옴
		int in=(int)100.1;
		System.out.println("in값: "  + in);
		
	}

	
}


