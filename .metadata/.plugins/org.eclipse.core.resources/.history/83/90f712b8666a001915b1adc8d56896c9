package e_method;

import java.util.Scanner;
// %s => (,)뒤의 값을 가져다 쓴다. 숫자, 문자 둘 다 가능
public class Ex03_성적ver2 {
	static String[] sub = {"국어", "영어", "수학"};

	public static void main(String[] args) {
		int sum = input();
		output(sum);
	}
	static int input() {
		//국영수 점수 입력받기
		Scanner input = new Scanner( System.in );
		int[] scores = new int[sub.length];
		int sum=0;

		for (int i = 0; i < sub.length; i++) {
			System.out.printf("%s 점수를 입력해주세요 \n", sub[i]);
			scores[i] = input.nextInt();
			sum += scores[i];
		}
		return sum;
	}

	static void output(int sum) {
		// 구한 합과 평균을 출력
		int avg = sum/sub.length;
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+avg);
	}

}
