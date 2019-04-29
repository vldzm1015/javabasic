package z_etc;
import java.util.*;
public class Test2 {

	public static void main(String[] args) {
		ArrayList<String> data = method();
//		for (int i = 0; i < data.size(); i++) {
//			String str = (String) data.get(i);
//			System.out.println(str);
//		}
		for (String s:data) {
			System.out.println(s);
		}
	}
	// Generics
	static ArrayList<String> method () {
		String a = "hola";
		String b = "hi";
		String c = "bye";
		ArrayList<String> list = new ArrayList<String>();
		// 추가로 들어올 때마다 새로운 메모리 생성=>공간확보
		// 확실한 갯수를 알 때는 배열. 모르면 Array
		list.add(a);
		list.add(b);
		list.add(c);
		list.add("hala");
		return list;
	}
}
