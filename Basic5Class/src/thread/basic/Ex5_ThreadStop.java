package thread.basic;

public class Ex5_ThreadStop {
	public static void main(String[] args) {
		System.out.println("메인쓰레드 : "+Thread.currentThread().getName());
		MakeCar3 mc = new  MakeCar3( );
		mc.start();
		try {
			Thread.sleep(2000);
		} catch (Exception ex) { }
			System.out.println("쓰레드 종료");
			//mc.stop(); 권장하지 않음
//			mc.start();	 // stop(); 이후에는 다시 실행안됨
			mc.flag = true;
		
	}

}
class MakeCar3 extends Thread{
	boolean flag = false; 
	// 쓰레드를 끝내고 싶을때는 stop메소드 대신  boolean 변수사용
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			if(flag) return;
			
			System.out.println(getName()+"작업중");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

		}
	}
}