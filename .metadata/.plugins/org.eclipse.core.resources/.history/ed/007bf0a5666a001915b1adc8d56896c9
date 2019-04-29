package d_constructor;

public class Student {
	//멤버변수 (member field)
	private String name;
	private int kor, eng, math;
	private int total;
	private double avg;

	//생성자 함수가 하나도 없는 경우
	//JAVA compiler가 
	//기본생성자 public Student() {} 를 자동으로 생성
	//=> 기본생성자는 만든다.

	public Student(){
		// this : 멤버를 지칭하기 위한 '레퍼런스'
		// this() : 다른 생성자 함수 호출하는 '함수'
		//			반드시 첫줄에 기술
		this("익명",50,50,50);
//		한줄로 줄이면 ^
//		this.name="익명";
//		this.kor=50;
//		this.eng=50;
//		this.math=50;

		System.out.println("기본생성자 호출");
	}

	//생성자 - 멤버변수 초기화
	// - 클래스 명과 동일한 이름의 함수
	// - 리턴형이 없음(void 안됨)
	// - overloading 
	public Student(String name, int kor, int eng, int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		System.out.println("인자 있는 생성자 호출");
	}
	//멤버 메소드 (member method)
	public int calTotal() {
		total = kor+eng+math;
		return total;
	}
	public double calAverage() {
		avg=(double)total/3;
		return avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public double getAvg() {
		return avg;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
