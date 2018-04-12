package org.elsys;

public class CounterExample {
	private static final int THREADS = 10;
	private static long counter = 0;
	private static Object lock = new Object();
	
	private static class Incrementer implements Runnable {

		@Override
		public void run() {
			System.out.println("incrementer started...");
			for(long i = 0; i<1000000; ++i) {
				synchronized (lock) {
					counter ++;
				}
			}
			System.out.println("incrementer finished...");
		}
		
	}
	
	public static void main(String[] argv) {
		Thread threads[] = new Thread[THREADS];
		for (int i = 0; i < THREADS; i++) {
			Runnable runner = new Incrementer();
			threads[i] = new Thread(runner);
		}

		for (int i = 0; i < THREADS; i++) {
			threads[i].start();
		}

		for (int i = 0; i < THREADS; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Program ended!!!!");
		System.out.println("count=" + counter);
	}
	
}
