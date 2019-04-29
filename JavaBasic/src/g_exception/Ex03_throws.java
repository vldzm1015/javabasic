package g_exception;

import java.io.FileInputStream;

public class Ex03_throws {

	public static void main(String[] args) {
		try {
		readFile();								// 1 . 3 예외 발생받아서 
		System.out.println("파일처리");
		}catch(Exception ex) {					// 4 catch로 처리
			System.out.println("예외발생");
		}
	}
	static void readFile() throws Exception{	//  2(예외발생) throws Exception으로 예외 토스
		FileInputStream fis = new FileInputStream("xxx.txt");
		System.out.println("파일연결");
	}
}
