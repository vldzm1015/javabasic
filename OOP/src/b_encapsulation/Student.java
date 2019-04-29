package b_encapsulation;

// 클래스 : 서로 다른 자료형의 변수들 + 메소드들
// 캡슐화 = 권한관련부여
//	1. 멤버변수 -private
//	2. 멤버메소드 - public

public class Student {
	private String name;
	private int kor, eng, math;
	private int total;
	private double avg;
	
	public int calTotal() {
		total = kor+eng+math;
		return total;
	}
	public double calAverage() {
		avg=(double)total/3;
		return avg;
	}
	public void setName(String name) {
		this.name = name;   
		//this를 넣지 않고 변수 이름이 겹치면 지역변수만 참조.
		//변수 이름을 겹치지 않고 사용 가능하나 같은 이름을 사용하고
		//this붙여서 사용추천	
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
	
	
}
