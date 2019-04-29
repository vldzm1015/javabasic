package g_exception;
/*
 * 오류
 * 	- 에러 : 심각오류
 * 	- 예외 : 심각하지 않은 오류
 * 
 * 예외처리 - 프로그램을 정상적으로 종료하기 위해	
 *  (1) 예외를 잡자 - try~ catch구문
 *  		try {
 *  			예외발생할 구문
 *  		} catch(){
 *  			예외가 발생한 후의 구문
 *  		}finally{
 *  			예외 발생 여부와 관계없이 무조건 실행구문
 *  		}
 */
public class Ex01_tryCatch {

	public static void main(String[] args) {
		String[] str = {"맛점", "우산", "즐거운화요일"};
		try {										//예외발생할 구문
			for(int i =0; i<=str.length; i++)
			//for(int i =0; i<str.length; i++)
			{
				System.out.println(str[i]);
			}
			System.out.println("예외가 발생할 여지가 있는 구문");
			return;
		}catch(Exception ex) {						//예외가 발생한 후의 구문
			System.out.println("예외발생 : "+ ex.getMessage()); 
			//System.out.println("예외발생 : "+ ex.toString());
			//ex.printStackTrace();
		}finally {									//예외 발생 여부와 관계없이 무조건 실행구문
			System.out.println("무조건 실행구문");
		}
		System.out.println("프로그램 정상종료");
	}
}
