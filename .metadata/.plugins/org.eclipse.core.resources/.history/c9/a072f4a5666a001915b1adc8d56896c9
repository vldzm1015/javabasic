package l_collection;
import java.util.HashMap;
import java.util.Scanner;
public class HashMapEx {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("kimjava", "1111");
		map.put("kimjava", "1234");
		map.put("parkjava", "2222");

		Scanner input = new Scanner(System.in);
		boolean stop = false;
		while(!stop) {
			System.out.println("아이디와 패스워드 입력");
			System.out.println("아이디입력 : ");
			String id = input.nextLine();
			System.out.println("패스워드 입력 : ");
			String pw = input.nextLine();
			if (map.containsKey(id)) {
				// id가 map의 key에 해당되는가?
				if(map.get(id).equals(pw)){
					//if (map.containsValue(pw)) {
					// id 와 같은 key의 값과 pw가 같다면 ?
					System.out.println("로그인성공");
					stop=true;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
				continue;
			}
		}
	}
}