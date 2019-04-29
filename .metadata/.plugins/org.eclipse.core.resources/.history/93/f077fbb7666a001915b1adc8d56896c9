package z_useful;
import java.util.Calendar;

public class Ex01_Calendar {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		// 연,월,일,시
		System.out.println(c.get(Calendar.YEAR)+"년");
		System.out.println((c.get(Calendar.MONTH)+1)+"월");     //월 +1
		System.out.println(c.get(Calendar.DATE) + "일");
		// 요일
		String[ ] str= { "일","월","화","수","목","금","토" };
		int yoil = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(str[yoil-1] +" 요일 입니다.");
		
		
		// 시,분,초
		System.out.println(c.get(Calendar.HOUR) + "시");
		System.out.println(c.get(Calendar.MINUTE) + "분");
		System.out.println(c.get(Calendar.SECOND) + "초");
		// 그 외 정보
		System.out.println("이 해의 " + c.get(Calendar.DAY_OF_YEAR) +" 번째 일 입니다.");
		System.out.println("이 해의 " + c.get(Calendar.WEEK_OF_YEAR) +"번째 주 입니다.");
		System.out.println("이 달의 " + c.get(Calendar.WEEK_OF_MONTH)+"번째 주 입니다.");
	}
}
