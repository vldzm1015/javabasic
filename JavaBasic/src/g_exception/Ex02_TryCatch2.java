package g_exception;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02_TryCatch2 {

	public static void main(String[] args) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("abc.txt");
			System.out.println("파일연결");
			fis.read();
		//} catch (Exception e) {	  //모든 예외를 한번에 잡을 경우 하나만 쓴다
		} catch (FileNotFoundException e) {			
			//e.printStackTrace();
			System.out.println("파일없는 예외 : " + e.getMessage());
		}catch (IOException e) {			
			//e.printStackTrace();
			System.out.println("입출력 예외 : " + e.getMessage());
		}catch(Exception e) {			// 맨 앞에 쓸경우 다른 코딩들이 에러나기 때문에 맨 뒤에 쓰거나 하나만 씀 
			System.out.println("그 외 예외처리"); 
		}finally {
			try{fis.close();}catch(Exception ex) {}
		}
		System.out.println("끝"); //파일이 없는 경우에도 예외처리가 됬기때문에 문자가 나옴
	}
}
