package c_control;

import java.util.Scanner;
/*
 * 	while(false){
 * 		명령문
 * 	}
 * 	do{
 * 		명령문
 * 	}while(false)
 */
public class Ex10_do_while {

	public static void main(String[] args) {

		char result = '\0';    // 초기화 C 문법이다. 자바 문법은 '\u0000'

		 do{
	            Scanner input = new Scanner(System.in);
	            System.out.println( "숫자를 입력해주세요(1 ~ 9)" );
	            int dan = input.nextInt();

	            for(int i=1;i<=9;i++) {
	                System.out.println( dan + "*" + i + "=" + (dan*i));
	            }

	            System.out.println( "다시 할래요? (y|n)" );
	            result = input.next().charAt(0);
	        }while (result == 'Y' | result == 'y');

	    }
	}