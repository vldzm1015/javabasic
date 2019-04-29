package d_array;

public class Ex02_2차원 {

	public static void main(String[] args) {
		
		int [ ][ ] score;
		score = new int [3][4];
		
		score[1][2]= 100;
		score[2][3]= 100;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				System.out.println(i+"행"+j +"열"+ score[i][j]);
			}
		}
		


	}

}
