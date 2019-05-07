package thread.basic;


class  Count {
	int i =0;
	
//	synchronized void increment() {
//  메소드 앞에도 쓸 수 있지만 속도가 매우 느려짐. 공유하는 객체에 사용권장.
	
	void increment() {
	// synchronized 붙이면 하나가 끝날때까지 다른 작업들은 대기
	// 자원을 공유하지만 자원의 값을 유지해야 할 경우 사용
	// synchronized 만 쓸 수 없어서 공유하는 객체나 자신을 넣는다.
		synchronized(this) {
		i++;
		}
	}
}

class ThreadCount extends Thread{
	Count cnt;
	
	public  ThreadCount(Count cnt) {
		this.cnt = cnt;
		
	}
	
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			cnt.increment();
		}
	}
}

public class Ex7_Synch {

	public static void main(String[] args) {
		Count cnt = new Count();
		
		ThreadCount tc1 = new ThreadCount(cnt);
		tc1.start();
		
		ThreadCount tc2 = new ThreadCount(cnt);
		tc2.start();
		
		try {
			tc1.join();
			tc2.join();
		} catch (Exception e) {		}
		
		System.out.println("i 값 : " + cnt.i);
	}

}
