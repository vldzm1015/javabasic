package a_datatype;
/*
 * 변수 :  값 하나를 저장하기 위해 메모리에 할당하고 이름을 부여
	값 하나를 메모리 저장하기 위해 매모리 이름 + 데이타 타입
	 데이타타입(자료형)
 * 1. 기본형(프리미터브)
 * 		논리형 :  boolean
 * 		문자형 :  char
 * 		정수형 :  int / long
 * 		실수형 :  double
 * 2. 참조형 : 클래스, 배열
 *                   new 연산자 이용해서 heap에 메모리 핫딜
 *					   String(*)
 */

public class Ex01_Naming {


 public static void main (String[] args) {
		// 1. 변수선언
		char a;
		// char =문자형 변수일 때 사용
		int b;
		// int = 숫자형 변수 중 정수형일 경우 사용
		double d;
		// double = 숫자형 변수 중 실수형일 경우 사용
		
		// 2. 값 지정
		a = '김';        //    char형에는 ''으로 문자 하나만 지정
		b = 100;      //  정수형에는 마지막에 ;로 마무리
		d = 100.3;  // 실수형에는 마지막에 ;로 마무리
	System.out.println(a); 
	// a를 확인 할 때 프린트사용
	}
	 
}
	

//한줄주석

/*
여러줄 주석
 */

/**
 도움말주석
*/

//  ctrl + /

// ctrl + shift + c