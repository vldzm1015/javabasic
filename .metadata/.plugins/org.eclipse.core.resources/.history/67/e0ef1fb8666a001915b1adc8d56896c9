package c_control;
public class Ex02_if_학번 {
//	public static void main(String[] args) {
//		String hakbun = "2019211001";
//		char a = hakbun.charAt(4);
//		if( a =='1'   ) {
//			System.out.println("공대");
//		} else if( a =='2'    ) {
//			System.out.println("사회대");
//		}
	public static void main(String[] args) {
		String hakbun = "2019213001";
		String hakyeon = hakbun.substring(0,4);  
		char dan = hakbun.charAt(4);  //단과구하기
		String dande =" ";
		String major = hakbun.substring(5,7); //학과구하기
		String major1 =" ";
/*		if(dan=='1') {
			dande = "공대";
			if( major.equals("11")) {
				major1 = "컴퓨터학과";
			} else if(major.equals("12")) {
				major1 = "소프트웨어학과";
			}else if(major.equals("13")) {
				major1 = "모바일학과";
			}else if(major.equals("22")) {
				major1 = "자바학과";
			}else if(major.equals("33")) {
				major1 = "서버학과";
			}
		} else if(dan=='2') {
			dande = "사회대";
			if( major.equals("11")) {
				major1 = "사회학과";
			} else if(major.equals("12")) {
				major1 = "경영학과";
			}else if(major.equals("13")) {
				major1 = "경제학과";
			}
		}
*/		
		if(dan=='1') {
			dande = "공대";
			switch(major1){
			case "11": major1="컴퓨터학과"; break;
			case "12": major1="소프트웨어학과"; break;
			case "13": major1="모바일학과"; break;
			case "22": major1="자바학과"; break;
			case "33": major1="서버학과"; break;
			}
		} else if(dan=='2') {
			dande = "사회대";
			switch(major1){
			case "11": major1="사회학과"; break;
			case "12": major1="경영학과"; break;
			case "13": major1="경제학과"; break;
			}
		}
	    System.out.println( hakbun + "님은" + hakyeon +  "년에 입학한 "  + dande +"학부"  + major1 + "학생입니다.");
	}
}
