package b_operator;

/*
 * 	 not  : 결과를 반대로 하는 연산자
 * 		  -  일반논리(true/ false) : !
 *  		  -  이진논리 ( 비트의 값 : 0/1) : ~
 */

public class Ex02_Not {
	public static void main(String[] args) {
		boolean result = 3>4;
		// 3은 4보다 큰 수인지
		System.out.println(result);
		// 3은 4보다 큰 수가 아닌지
		System.out.println(!result);
		// 15를 이진논리 수로 바꿔서 그 값들의 0과 1을 모두 바꿈
		int a = 15;
		System.out.println(~a);
	}
}
