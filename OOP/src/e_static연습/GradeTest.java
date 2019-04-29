package e_static연습;

import java.util.Scanner;
import java.util.StringTokenizer;


public class GradeTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("데이터 개수 입력 : ");
		int num = input.nextInt();
		input.nextLine();  
		
		
		int []jumsu= new int[num];
		System.out.println("원소 값 입력 (ex)100/100/100");
		String info = input.nextLine();
		StringTokenizer st = new StringTokenizer(info,"/");
		
		for(int i=0; i<jumsu.length; i++) {	
			jumsu[i]=Integer.parseInt(st.nextToken());			
		}
		
		GradeExpr s = new GradeExpr(jumsu);
		System.out.print("점수들 : ");
        
		for (int i = 0; i < jumsu.length; i++) {
            System.out.print(jumsu[i] + ", ");
        }
        System.out.println();
	
		System.out.println("총점: "+ s.getTotal());
		System.out.println("평균: "+ s.getAverage());
		System.out.println("최고점수: "+ s.getGoodScore());
		System.out.println("최저점수: "+ s.getBadScore());
	}
}