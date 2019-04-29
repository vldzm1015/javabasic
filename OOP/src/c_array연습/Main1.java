package c_array연습;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1 {
	public static void main(String[] args) {

		//세명의 학생에 대한 성적을 처리하고 싶을 때, 배열로 만들어 줘야한다.
		Scanner input = new Scanner(System.in);
		System.out.println("학생의 수를 입력하세요");
		int n = input.nextInt();input.nextLine(); 
		//학생 수 입력 후에, 엔터 친 후 학생정보를 입력받아야 하므로, 엔터를 n이 가져가야함.
		//input.nextLine();를 처리 하고 싶지 않다면 for문 안에서 scanner를 초기화 해줘야함.
		Student1[] s = new Student1[n]; 

		for(Student1 stu:s){ 
			//향상된 for문 -- 뒤에 있는 것(여기서는 s)이 집합인 경우에만 쓴다. 
			//s를  읽어서 stu라는 배열에 넣는다.stu라는 배열은 for문 안에서만 쓸 수 있다.

			System.out.println("학생정보입력(예)홍길동/20/30/40");
			String info = input.nextLine();
			StringTokenizer st = new StringTokenizer(info,"/");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			// 클래스 초기화 - 객체생성 + 값지정
			stu = new Student1(name,kor,eng,math); 
			//배열에 다시 메모리 할당해줘야함.

			stu.calTotal();
			stu.calAverage();

			System.out.println(s);
			System.out.println(stu);

		}
	}
}