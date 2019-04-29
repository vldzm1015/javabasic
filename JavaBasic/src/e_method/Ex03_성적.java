package e_method;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex03_성적 {
	static int kor = 0;
	static int eng = 0;
	static int math = 0;
	static int total;
	static int avg;
	public static void main(String[] args) {
		input();
		calc();
		output();
	}
	static void input() {
		//국영수 점수 입력받기
		Scanner input = new Scanner (System.in);
		System.out.println("국어 점수 입력");
		kor =input.nextInt();
		System.out.println("영어 점수 입력");
		eng =input.nextInt();
		System.out.println("수학 점수 입력");
		math =input.nextInt();
			}
	static void calc() {
		//input에서 입력받은 점수들의 합과 평균을 구하기	
			total += kor+eng+math;
			avg = total/3;
		}

	static void output() {
		//calc() 구한 합과 평균을 출력
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
	}
}
