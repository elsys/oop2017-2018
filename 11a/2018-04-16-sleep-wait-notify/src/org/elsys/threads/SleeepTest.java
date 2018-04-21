package org.elsys.threads;

public class SleeepTest {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new PointlessRunnable());
		t1.start();
		try {
			t1.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main");
		}
	}

}
