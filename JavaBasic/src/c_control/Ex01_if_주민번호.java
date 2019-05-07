package c_control;

public class Ex01_if_주민번호{

	public static void main(String[] args) {
		String id = "880203-202545";
		// id 의 7번째 글자을 sung으로 지정
		char sung = id.charAt(7);
		// 1 또는 3 또는 9이면 남자를 출력
		if( sung =='1'    | sung =='3'   |sung =='9'   ) {
			System.out.println("남자");
			// 2 또는 4 또는 8이면 여자를 출력
		}else if( sung =='2'| sung =='4'   |sung =='8'    ) {
			System.out.println("여자");
		}			
	}
}
