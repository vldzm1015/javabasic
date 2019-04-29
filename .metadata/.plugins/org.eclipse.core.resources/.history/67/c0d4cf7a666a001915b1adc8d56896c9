package c_control;

import java.util.Scanner;

public class Ex06_for연습 {

	public static void main(String[] args) {
		/*문제 1)1~ N까지의 숫자를 다음처럼 출력하라
1 2 3 4 5 
6 7 8 9 10
11 12 13 14 15*/
		//		for(int i=1; i<=15; i++) {
		//			System.out.print( i + " ");
		//			if( i%5 ==0) System.out.println( );
		//		}

		/*입력받은 문자열의 뒤집어서 출력하세요
   [예]  입력     출력
     안녕 친구   구친 녕안
     CarpeDiem   meiDepraC*/

		//		Scanner input = new Scanner(System.in);
		//		System.out.println("문장입력->");
		//		String msg = input.nextLine();
		//		int length = msg.length();
		//		for(int i=length-1; i<=length; i--) {
		//				System.out.println( msg.charAt(i));
		//			}

		// 예제
		//		Scanner input = new Scanner(System.in);
		//		System.out.println("영문자를 입력하세요");
		//		char cha = input.next().charAt(0);
		//
		//		System.out.println("출력값은");
		//		if(cha >='a' && cha<='z') {
		//			for(char c='a'; c<=cha; c++ ) {
		//				System.out.print(c+" ");
		//			}
		//		}else if(cha >='A' &&cha<='Z') {
		//			for(char c= cha; c<='Z'; c++ ) { 
		//				System.out.print(c+" "); 
		//			}
		//		}else {
		//			System.out.println( "Error" );
		//		}
		//예제
		//		Scanner input  =  new Scanner(System.in);
		//		System.out.println("행수를 입력하시오");
		//		int n = input.nextInt();
		//		System.out.println("열수를 입력하시오");
		//		int m = input.nextInt();
		//		for (int i = 1; i <= n; i++) {
		//			for (int j = i; j <= m*i; j+=i){
		//				System.out.print(j+" ");
		//			}
		//			System.out.println();
		//		}

		//예제
		Scanner input  =  new Scanner(System.in);
		System.out.println("1~100 사이의 수 입력");
		int n = input.nextInt();
		System.out.println("1~100 사이의 수 입력");
		int m = input.nextInt();
		int temp = 0;
		// [n*m을 한 후 m개로 나눠서 정리]
		//		for (int i = 1; i<= n*m; i++) {
		//			System.out.print(i+" ");
		//			if( i%m==0 )
		//				System.out.println();
		//		}

		// [for문을 사용하여 앞에 숫자에 공백을 줘서 뒤에 숫자를 당겨와서 씀]
		for(int i=1; i<=n; i++) {
			for (int j =1;  j<=m; j++) {
				System.out.print(j+temp+" ");
			}
			System.out.println();	
			temp = temp + m;
		}
	}
}
