package e_method;
//입력받은 값을 makeSquare이용해서 n*m문자 배열을 만들기
//F G H I
//J K L M
//N O P Q
public class Ex000_복습 {

	public static void main(String[] args) {
		char[][] square = input();
		output(square);
	}
	/*
	 * Function: INPUT
	 * Parameter: none
	 * Return: char [][]
	 * Rol: 두 정수와 알파벳 문자를 하나를 입력 받기
	 * 
	 */
	static char[][] input() {	
		int n=3, m=4;
		char alpha = 'f';
		char [][]square = makeSquare(n,m,alpha);
		return square;
	}
	/*
	 * Function: makeSquare
	 * Parameter: int n, int m, char alpha
	 * Return: char [][]
	 * Rol: 입력받은 값을 이용해서 n * m 만큼의 문자 배열을 만들기
	 *    F G H I
	 *    J K L M
	 *    N O P Q
	 */
	static char[][] makeSquare(int n, int m, char alpha){
		char [][]square = new char [n][m];
		for(int i=0; i<n; i++) {
			for( int j=0; j<m; j++) { 
				square[i][j]=alpha++;
			}
		}
		return square;
	}
	/*
	 * Function: output
	 * Parameter: char [][]
	 * Return: none
	 * Rol: 입력받은 값을 이용해서 n * m 만큼의 문자 배열을 만들기
	 * 
	 */
	static void output(char [][] square) {
		for(int i = 0; i<square.length; i++ ) {
			for( int j=0; j<square[i].length; j++) {
				System.out.print(square[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
