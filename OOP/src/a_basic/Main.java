package a_basic;

public class Main {

	public static void main(String[] args) {

		Student s = new Student();
		//Student-클래스이름 , s-변수
		s.name="홍길동";
		s.kor=100;
		s.eng=50;
		s.math=75;
		System.out.println("총점 : " +s.calTotal());
		//s.total=300;  
		System.out.println("평균 : " +s.calAverage());
	}

}
