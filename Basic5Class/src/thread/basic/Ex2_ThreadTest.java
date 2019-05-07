package thread.basic;

public class Ex2_ThreadTest {

	public static void main(String[] args) {
		MakeCar1 mc1 = new  MakeCar1("차를 만들기");
		mc1.start();
		
		MakeCar1 mc2 = new MakeCar1("도색");
		mc2.start();
		
		System.out.println("프로그램끝");
	}

}
class MakeCar1 extends Thread{
	String work;
	MakeCar1(String _work){
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