package e_static답안;

public class GradeExpr {

	// 멤버변수
	private int[] jumsu;
	private double average;
	private int total;
	private int goodscore;
	private int badscore;

	// 생성자 함수(Constructor method)
	public GradeExpr(int[] score) {
	this.jumsu = score;
	}

	/* Function: calTotal
	* Parameter: none
	* Return: int
	* Rol: 입력받은 점수의 총합산 리턴
	*/
	public int calTotal() {
	for (int i=0;i< jumsu.length; i++) {
	total +=jumsu[i]; 
	} 
	return total;
	}
	/* Function: calAverage
	* Parameter: int total
	* Return: double
	* Rol: 총점수의 평균을 소수점으로 리턴
	*/
	public double calAverage() {
	average = (double)total/(jumsu.length);
	return average; 
	}
	/* Function: getGoodScore
	* Parameter: int[] jumsu
	* Return: int
	* Rol: 입력받은 점수 배열에서 가장 높은점수 리턴
	*/
	public int getGoodScore() {
	goodscore = jumsu[0];
	for (int i=1; i<jumsu.length; i++) {
	if (goodscore < jumsu[i]) {
	goodscore = jumsu[i];
	} 
	} 
	return goodscore;
	}
	/* Function: getBadScore
	* Parameter: int[] jumsu
	* Return: int
	* Rol: 입력받은 점수 배열에서 가장 낮은점수 리턴
	*/
	public int getBadScore() {
	badscore = jumsu[0];
	for (int i=1; i<jumsu.length; i++) {
	if (badscore > jumsu[i]) {
	badscore = jumsu[i];
	}
	} return badscore;
	}

	}
