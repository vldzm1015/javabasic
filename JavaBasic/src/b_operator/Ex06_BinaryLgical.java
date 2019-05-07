package b_operator;

public class Ex06_BinaryLgical {

	public static void main(String[] args) {
		int a = 4 , b = 7;
		
		int and = a&b;
		System.out.println(and);
		/*  &(and)연산자는 두 자리의 값이 같아야 값을 1로 계산
		 * 0100 - 정수 4
		 *  0111 - 정수 7
		 *  -----------------		
		 *  0100 - 정수 4 (연산결과) 
		 */
		
		
		int or = a|b;
		System.out.println(or);
		/*  | (or)연산자는 두 자리중 하나라도 1이면 값을 1로 계산
		 * 0100 - 정수 4
		 *  0111 - 정수 7
		 *  -----------------		
		 *  0111 - 정수 4 (연산결과) 
		 */
		
		int xor = a^b;
		System.out.println(xor);
		/*  ^  (xor)연산자는 두 자리가 같으면 0으로 다르면 1로 계산
		 * 0100 - 정수 4
		 *  0111 - 정수 7
		 *  -----------------		
		 *  0011 - 정수 3 (연산결과) 
		 */

	}

}
