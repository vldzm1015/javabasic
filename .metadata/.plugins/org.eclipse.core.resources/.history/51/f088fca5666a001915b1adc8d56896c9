package i_final;
/*
 *   final - 변경불가
 *   	final field - 값 변경 불가. 상수처리.
 *   	final method - overrinding 불가.
 *   	final class - 상속불가
 */

final class Parent{
	final String field = "부모님꺼";
	final public void job() {
		System.out.println(" 부모님께서 장만");
	}

}
class Child {
	Child(){
		//field="내꺼임";
	}
	//	public void job() {
	//		System.out.println("물려받아 탕진");
	//	}
}
public class Test {	
	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println(p.field);
		p.job();
	}
}
