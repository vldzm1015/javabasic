package e_method;
/*	
 * 	메소드명 : main (메소드가 main일 때 return은 void로 고정 )
 * 	인자 : String[] args
 *  리턴형 : void
 */
/* main에도 인자값을 넣을 수 있다.
 * Run As가 아닌 Run Configurations로 들어가 Arguments의 Program Arguments값을 수정해주면 된다.
 * Test.java -> Test.class
 * 	(1) 컴파일 : javac Test.java
 * 	(2)	실행 : java Test 192.168.0.1. scott tiger
 */
public class Ex08_Main {

	public static void main(String[] args) {
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}

	}

}
