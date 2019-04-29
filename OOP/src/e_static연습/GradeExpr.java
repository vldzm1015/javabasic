package e_static연습;

public class GradeExpr {

	static int[] jumsu;
	 int total;
	private double average;
	private int goodScore;
	private int badScore;
	public GradeExpr(int [] jumsu){
		this.jumsu = jumsu;
	
	}
	public double getAverage() {
		average=(double)(total/jumsu.length);
		return average;
	}
	public int getTotal() {
		total = 0;
		for(int i=0; i<jumsu.length; i++) {
			total+=jumsu[i];
		}
		return total;
	}
	public int getGoodScore() {
		goodScore=jumsu[0];
		for(int i=0; i<jumsu.length; i++) {
			if(goodScore < jumsu[i]) {
				goodScore=jumsu[ i ];
			}
		}
		return goodScore;
	}
	public int getBadScore() {
		badScore=jumsu[0];
		for(int i=0; i<jumsu.length; i++) {
			if(badScore > jumsu[i]) {
				badScore=jumsu[ i ];
			}
		}
		return badScore;
	}
}
