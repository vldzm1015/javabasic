package b_operator;

import java.util.Scanner;

/*
 * 	산술연산자 : * /  %  ,   +  -
 */
public class Ex03_Arithmetic {

	public static void main(String[] args) {
			// 1. 숫자 하나 입력받기 ( Scanner - import java.util.Scanner)
			// 2. 홀수인지 짝수인지 연산하여 출력 ( % : 나머지 연산자 )
		Scanner input  =  new Scanner(System.in);
		System.out.println("숫자를 입력하시오");
		int sum = input.nextInt();
		// sum 을 2로 나눠서 0이되면 짝수 
		if ( sum % 2 == 0 ) {
			System.out.println("짝수");
		} else { //아닐경우 홀수
			System.out.println("홀수");
		}
	}
}
