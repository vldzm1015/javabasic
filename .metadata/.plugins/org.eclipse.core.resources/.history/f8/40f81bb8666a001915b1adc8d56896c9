package d_array;


public class Ex05_로또{
	public static void main(String[] args) {

		int [ ][ ] lotto = new int[5][6];

		// 로또번호생성
		for(int i = 0; i<lotto.length; i++ ) {
			for( int j=0; j<lotto[i].length; j++) {
				lotto[ i ][ j ] = (int)(Math.random()*45)+1;
				for(int k=0; k<j; k++) {
					if(lotto[i][k] == lotto[i][j]) {
						j--;
					}
				}
			}
		}
//
//
//		// 정렬
//		for(int k = 0; k<lotto.length; k++ ) {
//			for( int j= lotto.length-1; j>0; j--) {
//				if( lotto[k][j] > lotto[k][j+1]) {
//					int temp = lotto[k][j];
//					lotto[k][j] = lotto[k][j+1];
//					lotto[k][j+1] = temp;
//
//				}
//			}
//
//
			// 출력
			for( int i=0; i<lotto.length; i++) {
				int sum=0;
				for( int j=0; j<lotto[i].length; j++) {
					sum+= lotto[i][j];
					System.out.print(lotto[i][j]+"\t");
				}
				if(106 <sum && sum<170)
					System.out.print("★");
				System.out.println();
			}

		}
	}



