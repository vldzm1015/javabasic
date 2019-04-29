package d_array;
/* 야구게임
 * 숫자 세개와 숫자의 자리까지 맞추면 게임 승리
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex07_baseball {
	public static void main(String[] args) {

		// 1.컴퓨터 랜덤 수 3개 만들기
		int baseball[] = new int[3];
		for(int i = 0; i<baseball.length; i++ ) {
			baseball[i]= (int)(Math.random()*10);
			for(int j=0; j<i; j++) {  // 중복 발생 방지
				if(baseball[i] == baseball[j]) {
					j--;
				}
			}
		}
		//	      for(int i = 0; i<baseball.length; i++ ) {   //랜덤 숫자 확인용
		//	         System.out.println(baseball[i]+" ");
		//	      }

		// 2. 사용자가 입력한 답을 answer에 저장      
		int answer[] = new int[3];

		Scanner input = new Scanner(System.in);   
		for(int n=0; n<10; n++) {     
			System.out.println("0~9중에서 3개 입력 (ex) 6 3 9");
			String na = input.nextLine();
			StringTokenizer st = new StringTokenizer(na);
			for(int i=0; st.hasMoreTokens(); i++) {
				answer[i] = Integer.parseInt(st.nextToken());

			}

			// 3. baseball 배열과 answer배열을 각각 비교 	              
			int strike=0, ball=0;
			for( int i=0; i<baseball.length; i++) {
				for( int j=0; j<answer.length; j++) {
					if(baseball[i]==answer[j]) { //같은 값이라면
						if(i==j) {  		// 자리와 위치가 같다면 strike 
							strike+=1;
						}else {			 // 숫자만 같다면 ball
							ball+=1;
						}	        	
					}	        	 	            
				}
			}
			// 3 strike라면 반복문 좋료

			if(strike==3) {
				System.out.println("정답입니다 :) ");break;
			}else {
				System.out.println("strike="+strike+"개, ball="+ball+"개" );
			} 
			System.out.println("다시시도하세요");
		}
		System.out.println("땡! 다음기회에");
	}
}
