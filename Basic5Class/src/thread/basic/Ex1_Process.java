package thread.basic;

import java.io.IOException;

public class Ex01_Process {

	public static void main(String[] args) {
		//다른 응용 프로그램을 프로세스 실행
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec(" C:\\Program Files\\internet explorer\\iexplore.exe" );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
