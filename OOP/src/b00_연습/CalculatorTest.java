package b00_연습;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		char result;
		do {
			CalculatorExpr member = new CalculatorExpr();
			Scanner input = new Scanner (System.in);
			System.out.println("num1 입력");
			member.setNum1(input.nextInt());
			System.out.println("num2입력");
			member.setNum2(input.nextInt());



			System.out.println("추출된 숫자 : "+member.getNum1()+member.getNum2());
			System.out.println("덧셈 : "+member.getAdditition());
			System.out.println("뺄셈 : "+member.getSubtraction());
			System.out.println("곱셈 : "+member.getMultiplocation());
			System.out.println("나눗셈 : "+member.getDivision());
			System.out.println( "다시 할래요? (y|n)" );
			result = input.next().charAt(0);
		}while(result == 'Y' | result == 'y');

	}

}

