package b00_연습;

// set,get이후 변수명의 첫글자는 대문자
public class CalculatorExpr {
	private static int num1,num2;
	
	

	public int getAdditition() {
		return num1+num2;
	}
	public int getSubtraction() {
		return num1-num2;
	}
	public int getMultiplocation() {
		return num1*num2;
	}
	public double getDivision() {
		return (double)num1/num2;
	}
	public static int getNum1() {
		return num1;
	}
	public static void setNum1(int num1) {
		CalculatorExpr.num1 = num1;
	}
	public static int getNum2() {
		return num2;
	}
	public static void setNum2(int num2) {
		CalculatorExpr.num2 = num2;
	}
	
	
}
