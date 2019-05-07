package a_datatype;
import java.util.Scanner;
public class Homework01 {
	public static void main(String[] args) {
		// 세개의 수를 입력받아 큰 수를 출력
		Scanner input  =  new Scanner(System.in);
		//		String second = "";
		System.out.println("숫자를 입력하시오");
		int a = input.nextInt();
		System.out.println("숫자를 입력하시오");
		int b = input.nextInt();
		System.out.println("숫자를 입력하시오");
		int c = input.nextInt();
		// 두번쨰로 큰 수를 구하도록 수식
		int second = ( a>b & b>c | c>b & b>a )? b :
						( a>c & c>b | b>c & c>a )? c :
						( c>a & a>b | b>a & a>c )? a : a;
		System.out.println("두번째로 큰 수 : " + second );
	}
}

