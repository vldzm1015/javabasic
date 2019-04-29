package g_exception;

public class Ex04_throw {

	public static void main(String[] args) {
		try {
		readArray();
		}catch(Exception ex) {
			System.out.println("예외발생 : "+ex.getMessage());
		}
		System.out.println("정상종료");
	
	}
	static void readArray() throws Exception {
		String str[]={"우리는한배", "공부즐기시길", "스터디"};
		try {
			for(int i=0; i<=str.length; i++) {
				System.out.println(str[i]);
			}
		}catch(Exception ex) {
			throw new MyException();  //일부러 에러를 발생시킬 때 throw를 사용하고 new를 붙인다.
		}
		
	}
}