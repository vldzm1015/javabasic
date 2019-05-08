package thread.basic;

public class Ex2_ThreadTest2 {

	public static void main(String[] args) {
		MakeCar2 mc1 = new  MakeCar2("차를 만들기");
		// start 는 Thread 에만 있어서 Runnable을 구현하려면 중간작업필요
		Thread t1 = new Thread(mc1);
		t1.start();
		
		//원본
//		MakeCar2 mc2 = new MakeCar2("도색");
//		Thread t2 = new Thread(mc2);
//		t2.start();
		
		// 축약형  1
//		Thread t2 = new Thread(new MakeCar2("도색"));
//		t2.start();
		
		// 축약형 2
		new Thread(new MakeCar2("도색")).start();
		
		System.out.println("프로그램끝");
	}

}
//부모가 이미 존재할 경우 implements Runnable

class MakeCar2 implements Runnable{ 	String work;
	MakeCar2(String _work){
		work = _work;
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(work+"작업중");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}

		}
	}
}