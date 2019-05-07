package c_control;

import java.util.Calendar;

/*
 *  	1	- 정수값 1 (연산가능) 	
 *  	'1'	- 문자 1
 *  	"1"	- 문자열 1
 */
public class Ex03_주민번호_나이 {

	public static void main(String[] args) {
		//초기화 = 변수선언 + 값지정(대입)
		String id = "902212-2031115";
	
		String nai1 = id.substring(0,2);	
		//substring(0,2); = substring의 0~1번째까지	
		// nai1 = id의 0~1 번째 값
		int nai2 = Integer.parseInt  (nai1);		
		// String의 값을 Integer사용해서 int형으로 변환
		//String -> int ( "90" -> 90)
		
		int age = 0;
		// 초기값 0으로 지정
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		// 년도는 Calendar 에서 가져오기
		char a = id.charAt(7);
		// id 의 7번째 숫자가 
		if( a =='1'    | a =='2'    ) { // 1또는 2일경우
			age = year - (1900+nai2)+1;
		}else if( a =='3'| a =='4'    ) {  // 3또는 4일경우
			age = year - (2000+nai2)+1;
		}
		System.out.println("당신의 나이 : " + age);
		
		
		
	}

}
