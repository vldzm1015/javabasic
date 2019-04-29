package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01_성적 {

	public static void main(String[] args) {
		//int [ ]kor; 변수선언		// [ ]  배열을 쓰겠다는 신호
		int [ ]kor = new int[5];
		Scanner input = new Scanner (System.in);
		System.out.println("점수 5개 입력 (ex) 12 15 16");
		String score = input.nextLine();
		StringTokenizer st = new StringTokenizer(score);
		for(int i=0; st.hasMoreTokens(); i++) {
			kor[i] = Integer.parseInt(st.nextToken());
		}

		//	    for(int i=0; i<5; i++) { 			  //사용자가 엔터치면서 다섯개 입력
		//	    	kor[i] = input.nextInt();
		//	    }

		//		kor[0]=80;  //하나씩 직접 입력할 경우
		//		kor[1]=99;
		//		kor[2]=77;
		//		kor[3]=55;
		//		kor[4]=81;
		//		kor[5]=81;  메모리 오버로 에러남

		//총점구하기
		int total =0;
		for(int i=0; i<5; i++) {
			total += kor[i];
		}
		System.out.println("총점 : "+total);
	}

}
