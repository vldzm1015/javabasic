package b_operator;
/*
 *  shift : 모든 비트의 값을 이동하는 연산자
 *  
 *  >> : 오른쪽 이동
 *  << : 왼쪽으로 이동
 *  <<< : 오른쪽 이동 ( 부호에 0 )
 */

public class Ex07_Shift {

	public static void main(String[] args) {

		int a = -4 , b = 5;
		System.out.println(a>>2);
		// 111100 >> 2칸이동 001111 = -1
		System.out.println(a<<1);
		// 111100 << 1칸이동 111000 = -8
		System.out.println(a>>>2);
		// 111100 <<< 2칸이동 110000 = 1072741823
		System.out.println(b>>2);
		// 00000101 >> 2칸이동 00000001 = 1
		System.out.println(b<<1);
	} // 00000101 << 1칸이동 00001010 = 10

}
