package e_static2;
/*
 *  class 안에 class를 만들 수 있다.
 *  InnerClass는 멤버 취급을 받는다.
 */
class Outer{
	static class Inner{
	// Inner 클래스는 멤버취급을 하기때문에
	// static 붙이는 것이 가능
		static void najabara() {
			System.out.println("호출해주세요");
		}
	}
}

public class Innerclass {

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner.najabara();
		//Outer.Inner in = new Outer.Inner();
		// static을 붙이면 클래스명으로 호출가능
		//Outer.Inner in = o.new Inner();
		//안쪽에 있는 객체명을 타고 들어가야함
		//in.najabara();
		
	}

}
