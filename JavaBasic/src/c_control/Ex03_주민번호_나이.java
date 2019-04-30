package c_control;

import java.util.Calendar;

/*
 *  	1	- 정수값 1 (연산가능) 	
 *  	'1'	- 문자 1
 *  	"1"	- 문자열 1
 */
public class Ex03_주민번호_나이 {

	public static void main(String[] args) {
		String id = "032212-3031115";
		
		String nai1 = id.substring(0,2);			
		// nai1 = "80"
		int nai2 = Integer.parseInt  (nai1);		
		//String -> int ( "80" -> 80)
		int age = 0;
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		char a = id.charAt(7);
		if( a =='1'    | a =='2'    ) {
			age = year - (1900+nai2)+1;
		}else if( a =='3'| a =='4'    ) { 
			age = year - (2000+nai2)+1;
		}
		System.out.println("당신의 나이 : " + age);
		
		
		
	}

}
