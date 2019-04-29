package l_collection;

import java.util.*;
/*
 *  1. list 구조 
 *  	- 순서를 저장
 */
public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(4);
		// 갯수가 늘어도 상관없음. 동적인 배열
		list.add("rabbit");
		list.add("zebra");
		list.add("fox");
		list.add("cat");
		list.add("dog");
		list.add("ant");
		list.add("lion");
		
		for(String str : list) {
		// 향상된 for문은 형변환 불필요.
		// 형변환이 미리 되어있기 때문에 다른 형은 못씀.
			System.out.println(str);
		}
		System.out.println(list);
		
		list.set(1, "gugu");
		System.out.println(list);
		
		list.remove(4);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
//		for (int i = 0; i < args.length; i++) {
//			String str = (String)list.get(i);
//			System.out.println(str);
//		}

	}

}
