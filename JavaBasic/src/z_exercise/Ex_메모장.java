package z_exercise;

import  java.util.Scanner;
import  java.util.StringTokenizer; 

public class Ex_메모장 {
	/*(문제 2) 영문자를 입력하여 이 문자가 소문자이면 대문자로 변환하여 반환하고 대문자라면 그대로 반환하는 메소드를 작성하시오. 
	  함수명 : checkUpper
	  인자 : char
	  리턴(반환) : char*/
	public  static  void  main(String[]  args)  {
		Scanner input = new Scanner (System.in);
		System.out.println("영문자를 입력하시오");
		char ch = input.next().charAt(0);
		char result = checkLower(ch);
		System.out.println(result);
	}
		public static char checkLower(char ch) {
			if(ch >='a' && ch<='z') {
				return (char)(ch-32);
			}else if (ch >='A' && ch <='Z') {
				return ch;
			}else {
				return '*';
			}
					
			
		}
}