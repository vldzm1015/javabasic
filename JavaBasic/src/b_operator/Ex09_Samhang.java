package b_operator;

import java.util.Scanner;

/*
 *  삼항연산자
 *  		(조건)?  A  : B
 *  		조건이 true이면 A를 실행하고,  false이면 B를 실행한다.
 */
public class Ex09_Samhang {

	public static void main(String[] args) {
//		int score = 81;
//		String result = "";
//		if(score>=80) result =  "합격" ;
//		else result = "불합격" ;
//		System.out.println( "당신은" + result + "입니다.");   //3항을 안썼을 때
		
		int score = 81;
		String result = (score>=80)? "합격" : "불합격" ;
		System.out.println(result);
		
		// 두 수를 입력받아 큰 수를 출력
		Scanner input  =  new Scanner(System.in);
		System.out.println("숫자를 입력하시오");
		int first = input.nextInt();
		System.out.println("숫자를 입력하시오");
		int second = input.nextInt();
		int max = (first>second)? first : second;
		System.out.println("큰 수 : " + max );
	}
}
