package c_control;

public class Ex07_중첩for {

	public static void main(String[] args) {
		// 연습(1)
//				for(int j=0; j<5; j++) {
//					for(int i=5-j; i>0; i--) {
//						System.out.print('*');
//					}
//					System.out.println( );
//				}
//		
		//		// 연습(2)
//				for(int j=0; j<26; j++) {
//					for(char c='A'; c<='Z'; c++) {
//						System.out.print(c);
//					}
//					System.out.println();
//				}
		//예제 1  [ A~Z +1 ]
		//		for(int j=0; j<26; j++) {
		//			for(char c='A'; c<='A'+j; c++) {
		//				System.out.print(c);
		//			}
		//			System.out.println();
		//		}

		//예제 2  [ A~Z -1 (Z부터) ]
		//		for(int j=26; j>0; j--) {
		//			for(char c='A'; c<'A'+j; c++) {
		//				System.out.print(c);
		//			}
		//			System.out.println();
		//		}

		/*
	    -----------------------------------------------------
	            [ 문제 3 ] 아래와 같이 출력하기
	            ABCDEFGHIJKLMNOPQRSTUVWXYZ
	            BCDEFGHIJKLMNOPQRSTUVWXYZ
	            CDEFGHIJKLMNOPQRSTUVWXYZ
	            DEFGHIJKLMNOPQRSTUVWXYZ
	            :
	            XYZ
	            YZ
	            Z
	            -----------------------------------------------------
		 */
		//	        for(int i=0; i<26; i++) {
		//	            for (char ch = (char)('A'+i); ch <= 'Z'; ch++) {
		//	                System.out.print( ch );
		//	            }
		//	            System.out.println();
		//	        }
		//	    }
		//	}

		/*
	-----------------------------------------------------

	        [ 문제 4 ] 아래와 같이 출력하기
	        Z
	        ZY
	        ZYX
	        :
	        ZYXWVUTSRQPONMLKJIHGFEDC
	        ZYXWVUTSRQPONMLKJIHGFEDCB
	        ZYXWVUTSRQPONMLKJIHGFEDCBA

	 -----------------------------------------------------
		 */

		for(int i=0; i<26; i++) {
			for (char ch = 'Z'; ch >= 'Z'-i; ch--) {
				System.out.print( ch );
			}
			System.out.println();
		}
	


	/*
	 -----------------------------------------------------
	[ 문제 5 ] 아래와 같이 출력하기
	        ABCDEFGHIJKLMNOPQRSTUVWXYZ
	         BCDEFGHIJKLMNOPQRSTUVWXYZ
	          CDEFGHIJKLMNOPQRSTUVWXYZ
	           DEFGHIJKLMNOPQRSTUVWXYZ
	             :
	                              WXYZ
	                               XYZ
	                                YZ
	                                 Z
	 -----------------------------------------------------
	 */

//	        // 모든 라인을 출력
//	        for (int i = 0; i < 26; i++) {  		// 26개까지 프린트
//	            for (int j=0; j<i; j++) {       		// 공백을 늘려줌
//	                System.out.print("  ");
//	            }
//	            for (char ch = (char) ('A' + i); ch <= 'Z'; ch++) {  	// A부터 빠지게함
//	                System.out.print(ch);
//	            }
//	            System.out.println( );
//	        }
	}
}
	