package a_datatype;

import java.util.Scanner;

public class Ex05_Scanner {

	public static void main(String[] args) {
		
		Scanner input  =  new Scanner(System.in);
		// 학생명을 입력받기
		System.out.println("이름 : ");
		String name = input.nextLine(); 
		// 엔터를 칠 때마다 저장되고 다음으로 넘어감
		System.out.println("국어점수=>");
		int kor = input.nextInt();
		System.out.println("영어점수=>");
		int eng = input.nextInt();
		System.out.println("수학점수=>");
		int math =input.nextInt();
		//총점을 구해서 출력
		// 총점은 정수형 int 평균은 실수형 double 사용
		int total = kor + eng + math;
		System.out.println("총점:"+total);
		double  avg  = (double)total / 3;
		System.out.println("평균:"+avg);
		input.close();
	}

}
