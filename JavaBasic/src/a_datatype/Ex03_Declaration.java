package a_datatype;

public class Ex03_Declaration {
	
	public static void main(String[] args) {
		// 1. 변수선언 -> 값 대입
		int kor;
		kor = 30;
		//2.초기화 = 변수선언 + 값지정(대입)
		int eng = 30;
		if(kor == eng) {  // kor과 eng 가 같을경우
			System.out.println("같다");
		}else { // kor과 eng가 다를경우
			System.out.println("다르다");
		}
		
		int temp;
		// kor 과 eng를 temp로 묶어서 비교
		temp = kor;
		kor = eng;
		eng = temp;
		System.out.println("국어 : " + kor + ", 영어 : " + eng);

	}

}
