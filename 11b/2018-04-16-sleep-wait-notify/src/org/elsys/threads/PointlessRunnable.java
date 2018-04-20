package org.elsys.threads;

public class PointlessRunnable implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("pointless");
		}
	}

}
