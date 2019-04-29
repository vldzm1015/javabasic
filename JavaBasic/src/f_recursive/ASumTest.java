package f_recursive;

public class ASumTest {

	//	public static void main(String[] args) {
	//		int sum=0;
	//		for(int i=1; i<=10; i++) {
	////			sum+=i;
	//			int exsum = sum;
	//			sum=exsum+i;
	//			System.out.println(sum+"="+exsum+"+"+i);
	//		}
	//		System.out.println("합 : "+sum); //55
	//
	//	}
	public static void main(String[] args) {
		int sum=0;
		sum= sumFunc(3);
		System.out.println("총합 :" + sum);
	}
	static int sumFunc(int i) {
		if(i==1) return 1;  //중요 없으면 무한루프
		return i + sumFunc(i-1);
		
	}
}
