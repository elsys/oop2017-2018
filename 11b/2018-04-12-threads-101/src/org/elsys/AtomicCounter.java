package org.elsys;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter {
	private static final int THREADS = 10;
	private static AtomicLong counter = new AtomicLong(0);
	
	private static class Incrementer implements Runnable {

		@Override
		public void run() {
			System.out.println("incrementer started...");
			for(long i = 0; i<1000000; ++i) {
					counter.incrementAndGet();
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
		System.out.println("count=" + counter.get());
	}
	
	
}
