package j_useful;

public class EqualsEx {

	public static void main(String[] args) {
		Student a = new Student("0123456","홍길동");
		Student b = new Student("0123456", "홍길동");
		if(a.equals(b))System.out.println("동일인");
		else System.out.println("다른학생");
		System.out.println(a.toString());
		// toString() 없어도 같은결과
		System.out.println(b);

	}

}
class Student extends Object {
	String hakbun, name;
	Student(){}
	Student(String hakbun, String name){
		this.hakbun= hakbun;
		this.name = name;
	}
	public boolean equals(Object obj){
		// Object 안에있는 obj라는 메소드라는 뜻
		Student other = (Student)obj;
		if(hakbun.equals(other.hakbun)) return true;
		else return false;
		
	}
	public String toString() {
		return "["+hakbun+"]"+name;
	}
	
}