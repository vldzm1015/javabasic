package language;

public class Japan extends Language{
	String greeting;
	String introduce;
	String say;
	
	Japan(){
	}
	public void greeting() {
		System.out.println(greeting+"일본어인사말");
	}

	public void introduce() {
		System.out.println(introduce+"일본어 자기소개");
	}

	public void say() {
		System.out.println(say+"일본어 할말");
	}
}

