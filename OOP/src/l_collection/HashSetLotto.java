package l_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSetLotto {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
//		for (int i = 0; i < 6; i++) {
//		for문을 사용하면 중복된 수가 있을경우 전체 갯수가 줄어듬
		while(lotto.size()<6) {	
			int su = (int)(Math.random()*45)+1;
			lotto.add(su);
		}
		System.out.println(lotto);
		
		ArrayList<Integer> list = new ArrayList<Integer>(lotto);
		Collections.sort(list);
		System.out.println(list);
		
	}
	
}
