package b_operator;

import java.util.Scanner;

public class Homework_02 {


	public static void main(String[] args) {
			// 1. 숫자 하나 입력받기 ( Scanner - import java.util.Scanner)
			// 2. 홀수인지 짝수인지 연산하여 출력 ( % : 나머지 연산자 )
		Scanner input  =  new Scanner(System.in);
		System.out.println("년도를 입력하시오");
		int sum = input.nextInt();
		if ( sum %4 == 0  &&  sum %100 == 0 || sum %400 == 0 ) {
		// sum을 4와 100으로 나눴을 때 0이거나 400으로 나눴을 때 0이면
			System.out.println("윤년");
		} else { // 조건에 맞지 않으면
			System.out.println("평년");
		}
	}
}
