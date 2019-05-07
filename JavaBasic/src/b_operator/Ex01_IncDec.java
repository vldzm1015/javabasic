package b_operator;

/*
 *  증가감소 연산자 : ++, --
 */

public class Ex01_IncDec {
	public static void main(String[] args) {
		
		int a=5, b=7;
		System.out.println( "A="+(a+1)+"B="+(b+1) ); 
//		
//		
//		a = a+1;
//		b = b-1;
//		System.out.println( "A="+ a + "B="+ b  );
		
//		// a++은 a가 하나씩 올라간 값이 더해짐
		// b--는 b가 하나씩 내려간 값이 더해짐
//		a = a++;
//		b = b--;
//		System.out.println( "A="+ a + "B="+ b  );
//		
//		// ++a 는 수식이 끝난 후 하나의 값이 올라감
//		// --b는 수식이 끝난 후 하나의 값이 내려감
//		++a;
//		--b;
//		System.out.println( "A="+ a + "B="+ b  );
		
		
//		int result = ++a;
//		System.out.println( "Result : " + result + ", A=" + a );
//		
//		int result2 = a++;
//		System.out.println( "Result : " + result2 + ", A=" + a );
		
		System.out.println( "A="+ ++a + "B="+ --b  );  	//
		System.out.println( "A="+ a++ + "B="+ b--  );  	//
		System.out.println( "A="+ a + "B="+ b  );       		//
	}
}
