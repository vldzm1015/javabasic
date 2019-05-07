package thread.basic;

public class Ex6_Priority {

	public static void main(String[] args) {
		// 부여하지 않으면 NORM 큰 값은 MAX 작은값은 MIN이지만 별차이 없음
		MakeCar mc1 = new  MakeCar("차틀" ,Thread.MAX_PRIORITY);
		mc1.start();
		
		MakeCar mc2 = new  MakeCar("도색" ,Thread.MIN_PRIORITY);
		mc2.start();
	}

}
class MakeCar extends Thread{
	String work;
	MakeCar(String _work, int prio){
		work = _work;
		setPriority(prio);
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