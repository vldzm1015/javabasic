package c_array연습;

public class Student1 {
	private String name;
	private int kor, eng, math;
	private int total;
	private double avg;
	

	// 생성자함수
	// -클래스명과 동일명
	// -리턴형없음(void도 없어야함)
	// -overloading
	public Student1() {
		
	}
	
	public Student1(String name,int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


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
	
	// 멤버변수 출력하기 위한 메소드
	public String toString() {
		return getName()+"/"+getTotal()+"/"+getAvg();
	}
}
