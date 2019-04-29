package c_control;
/*
 *  break - 블럭을 벗어나는 명령
 *  continue - 블럭의 끝으로 가라는 명령
 */

public class Ex11_break_continue {

	public static void main(String[] args) {
		END:  // 변수와 헛갈리지 않기 위해 대문자로 표기 *아무거나 상관없음
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				if(j==0)   continue END; //break;
				System.out.println("<"+i+","+ j+">");
			}
			System.out.println("데이터");
		}
	}
}
