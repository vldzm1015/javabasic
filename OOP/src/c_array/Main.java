package c_array;

import java.util.Scanner;
import java.util.StringTokenizer;

// 배열 class의 경우, class 객체 생성 메모리 할 당 후, 배열에 대한 메모리도 할당해줘야한다.

public class Main {

	public static void main(String[] args) {

		//세명의 학생에 대한 성적을 처리하고 싶을 때, 배열로 만들어 줘야한다.
		Scanner input = new Scanner(System.in);		
		System.out.println("학생의 수를 입력하세요");

		int n = input.nextInt();input.nextLine(); 
		//학생 수 입력 후에, 엔터 친 후 학생정보를 입력받아야 하므로, 엔터를 n이 가져가야함.
		//input.nextLine();를 처리 하고 싶지 않다면 for문 안에서 scanner를 초기화 해줘야함.

		Student[] s = new Student[n]; 
		String[] stuInfo =new String[n]; 

		for (int i = 0; i < s.length; i++) {
			System.out.println((i+1)+"번째 학생의 정보 입력? ex)이름  국어점수 영어점수 수학점수");
			stuInfo[i]=input.nextLine();
			StringTokenizer sr = new StringTokenizer(stuInfo[i]);

			s[i] = new Student(); //배열에 다시 메모리 할당해줘야함.
			s[i].setName(sr.nextToken());
			s[i].setKor(Integer.parseInt(sr.nextToken()));
			s[i].setEng(Integer.parseInt(sr.nextToken()));
			s[i].setMath(Integer.parseInt(sr.nextToken()));
			
			s[i].calTotal();
			s[i].calAverage();

			System.out.println(s[i].getName()+":"+s[i].getTotal() + "/" +s[i].getAvg());

			System.out.println(s[i]); 
			//class에 toString을 만들어 놓지 않으면 주소값만 나옴. // toString을 만들면 해당 내용이 나옴.

		}
	}
}