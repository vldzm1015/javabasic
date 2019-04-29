package d_array;

public class Ex00_배열초기화 {

	public static void main(String[] args) {
		int a; //변수선언 (기본형) ->메모리확보
		a=10;// 값지정
		int b=20; //초기화
		
		//------------------------------
		/*int[] arr; // 변수선언(참조형) ---> 메모리확보X
		arr = new int[3];   // 객체(object = instance)생성(메모리확보)
		arr[0] = 10;
		arr[1] = 13;
		arr[2] = 27;
		*/
		
		//int[ ] arr = new int[ ] {3,30,13}; //배열초기화 기본형   
		int[ ] arr = {3,30,13}; //배열초기화 new int[ ] 생략가능
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[ i ]);
		}
	}

}


