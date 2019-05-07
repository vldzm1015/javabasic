package c_control;
/*	switch 문 : 분기문
  	switch(_____)
 	{
 		case A : 명령어 A; break;
 		case B : 명령어 B; break;
 		case C : 명령어 C; break;
 		default: 그 외 명령어;    (맨 뒤가 아닐경우는 break;)
 	}
 ***_____ : 정수형 / 문자형 / String(1.5버전 이후)
 */
public class Ex04_swich_주민번호 {

	public static void main(String[] args) {
//		초기화 = 변수선언 + 값지정(대입)
		String id = "801212-1024567";
		
		// chul 은 id 의 8번째 글자
		char chul = id.charAt(8);
		String home = " ";
		switch(chul){   // 8번째 글자가
		case '0': home="서울"; break;  
		// 0일경우 break;
		case '1': home="인천/부산"; break;
		// 1일경우 break;
		case '2': home="경기"; break;
		// 2일경우 break;
		case '9': home="제주"; break;
		// 9일경우 break;
		default : home="한국인"; 
		}  // 아무것도 걸리지 않았을 경우
		System.out.println( "출신지 : " + home);
	}
}






