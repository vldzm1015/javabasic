//package zz_ex00;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class ProduceInfo {
//
//	public static void main(String[] args) {
//		Scanner input=new Scanner(System.in);
//		int one;
//		int two;
//		int i = 0;
//		char answer;
//		Product[] p = new Product[5];
//
//		END:
//
//			do {
//				System.out.println("1.상품추가 2.모든 상품조회 3.끝내기");
//				one=input.nextInt(); input.nextLine();
//
//				if(one == 1 )
//					System.out.println("상품 종류  : 1)책  2)음악CD 3)회화책");
//				two=input.nextInt(); input.nextLine();
//
//				ArrayList<Object> arr= input(two);
//
////				switch(two) {
//				case 1 : p[i]= new Book(i,(int)arr.get(0),(String)arr.get(1),(String)arr.get(2),
//						(int)arr.get(3),(int)arr.get(4),(String)arr.get(5),(String)arr.get(6));break;
//				case 2 :
//					p[i]=new CompactDisc(i,(String)arr.get(0),(String)arr.get(1),(int)arr.get(2),
//							(String)arr.get(3),(String)arr.get(4),(int)arr.get(5)); break;
//				case 3 : 
//					p[i]= new ConversationBook(i,(String)arr.get(0),(String)arr.get(1),(int)arr.get(2),(String)arr.get(3),
//							(String)arr.get(4),(int)arr.get(5),(String)arr.get(6)); break;
//				}
//				System.out.println( "다시 하시겠습니까? (y|n)" );
//				answer = input.next().charAt(0);
//			}while (answer == 'Y' | answer == 'y');
//
//	}
//	private static ArrayList<Object> input(int two) {
//
//		return null;
//	}
//	public void addProduct() {
//
//	}
//
//}
//
//
////addProduct(type: int): void 