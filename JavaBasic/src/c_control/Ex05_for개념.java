package c_control;
/*
  	for (초기값;  조건문; 증가식)
  	{
  	반복할 문장들
  	}
 */	
public class Ex05_for개념 {

	public static void main(String[] args) {

		//초기화 = 변수선언 + 값지정(대입)
		int sum = 0;
		for(int i=1; i<=10; i++) {
			// i 는 1이고, i는 10 보다 작거나 같아질 때까지 ++
			sum += i;  // sum = sum + i;
			System.out.println("결과 : " +  i);


//			//연습  1~100까지 홀수의 합과 짝수의 합
//			int sum짝 = 0, sum홀 = 0;
//			for(int i=1; i<=100; i ++) {
//				if(i%2==0) {
//					sum짝 += i; 
//				}else{
//					sum홀 += i; 
//				}
//			}			
//			System.out.println("짝수합 : " +  sum짝);
//			System.out.println("홀수합 : " + sum홀);

//			//연습  1~100까지 홀수의 합과 짝수의 합
//			int sum짝 = 0, sum홀 = 0;
//			for(int i=1; i<=100; i+=2 ) {
//				sum홀+=i;
//				sum짝+= (i+1); 
//			}
//			System.out.println("짝수합 : " +  sum짝);
//			System.out.println("홀수합 : " + sum홀);

		
//			// A~Z 출력
//			for(char c='A'; c<='Z'; c++) {
//				System.out.println(c);
//			}
//			// Z~A 출력
//			for(char c='Z'; c>='A'; c--) {
//				System.out.println(c);
//			}
		}			
	}
}
