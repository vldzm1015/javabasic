package c_array;

// 클래스 = 서로 다른 자료형의 변수들 + 메소드들

/* 캡슐화 = 권한관련부여 
 * 	1. 멤버변수 -  private ( 다른 클래스에서 접근 허용 안함 )
 * 	2. 멤버메소드 - public (모든 접근 허용)
 */

public class Student {

	private String name;
	private int kor,eng,math;
	private int total;
	private double avg;

	//생성자 만들기
	public Student(){
		this("무명",50,50,50); 
		//오버로딩된 생성자 함수를 불러옴.
	}
	
	//생성자 오버로딩
	public Student(String name,int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int calTotal() {
		total= kor + eng +math;
		return total;
	}
	double calAverage() {
		avg=(double)total/3;
		return avg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public double getAvg() {
		return avg;
	}
	//멤버변수 출력하기 위한 메소드
	public String toString() {
		return  name +"학생 총점:" + total + "/평균:" + avg;
	}
}