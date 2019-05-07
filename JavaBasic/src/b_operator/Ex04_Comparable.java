package b_operator;
/*
 * 비교연산자 : >  <  >=  <= , == !=
 */
public class Ex04_Comparable {

	public static void main(String[] args) {
		//초기화 = 변수선언 + 값지정(대입)
		int k=100, e=100, m=100;
		double avg = (k+e+m)/3;
		System.out.println("평균 : " + avg );
		String score = " ";
		/*
		if(avg>=90) {
			System.out.println("A학점");
		} else if(avg>=80) {
			System.out.println(" B학점");
		}else if(avg<=70) {
			System.out.println(" C학점");
		}
		*/
		// 평균을 10으로 나눌 경우
		switch((int)(avg/10)){
		case 10: 
		case 9: score="A학점" ; break;
		// 나눈 값이 case 10~9 이면 score A학점 후 브레이크
		case 8: score="B학점" ; break;
		// 나눈 값이 case 8 이면 score  B학점 후 브레이크
		case 7: score="C학점" ; break;
		// 나눈 값이 case 7 이면 score  C학점 후 브레이크
		case 6: score="D학점" ; break;
		// 나눈 값이 case 6 이면 score  D학점 후 브레이크
		default : score="F학점" ; 
		} // break;에 걸린적이 없다면 score F학점
		System.out.println(score);
	}
}