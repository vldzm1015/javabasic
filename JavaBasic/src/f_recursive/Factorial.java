package f_recursive;

public class Factorial {

	public static void main(String[] args) {
		// 5!=5*4*3*2*1 = 120

		int sum=0;
		sum= sumFunc(5);
		System.out.println("총합 :" + sum);
	}
	static int sumFunc(int i) {
		if(i==1) return 1;  //중요 없으면 무한루프
		return i * sumFunc(i-1);

	}



}


