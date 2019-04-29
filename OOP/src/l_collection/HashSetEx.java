package l_collection;
import java.util.HashSet;
public class HashSetEx {

	public static void main(String[] args) {
		HashSet list = new HashSet();
		// HashSet 은 순번을 저장하지 않음
		// 중복된 값도 들어가지 않음.
		list.add("rabbit");
		list.add("zebra");
		list.add("fox");
		list.add("fox");
		list.add("dog");
		list.add("dog");
		list.add("lion");
		System.out.println(list);
	}

}
