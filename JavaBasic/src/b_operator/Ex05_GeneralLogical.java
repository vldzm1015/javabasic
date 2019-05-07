package b_operator;

import java.util.Scanner;

/*
 *  논리연산자
 *  		- 일반논리 ( true/ false ) : &&   ||
 *  		- 이진논리 ( bit에 있는 1/0 ) : & |   ^
 */
public class Ex05_GeneralLogical {

	public static void main(String[] args) {
		
		// 문자 하나를 입력받아 
		// 대문자인지 출력
		// 대문자인지 소문자인지 그외인지 출력
		Scanner input  =  new Scanner(System.in);
		System.out.println("문자 하나 입력");
		char ch = input.next().charAt(0) ; 
		System.out.println("입력값 : " + ch );
		// 입력값이 A 와 같거나 크면서 Z와 같거나 작을 경우
		if('A'>=ch  &&  ch<='Z') {
			System.out.println("대문자");
		}else if ('a'>=ch && ch<='z') {
			// 입력값이 a 와 같거나 크면서 z와 같거나 작을 경우
			System.out.println("소문자");
		}else{
			System.out.println("others");
		}
		
		/*int 성적 = 75;
		char 태도 = 'A';
		// 성적향상반 조건 : 80점 이상이면서 태도는 'A'이상
		// &&은 두 조건 다 만족해야 true
		if(성적>=80 && 태도=='A') {
			System.out.println("성적향상반");
		}
		//  우등생조건 : 성적 80점 이상이거나 태도가 'A' 이면 가능
		// ||는 두 조건중 하나만 만족해도 true
		if(성적>=80 || 태도=='A') {
			System.out.println("우등생");
		}
		*/
	}

}
