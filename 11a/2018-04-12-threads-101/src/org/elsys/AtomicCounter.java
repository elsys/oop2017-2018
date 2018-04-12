package org.elsys;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter {
	public static final int THREADS = 10;
	
	private static AtomicLong counter = new AtomicLong(0);
	
	public static void main(String[] argv) {
		Thread[] threads=new Thread[THREADS];
		
		for(int i=0; i<THREADS; i++) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("runnable started...");
					for(int i=0; i<1000000; i++) {
							counter.incrementAndGet();
					}
					System.out.println("runnable finished...");					
				}
				
			};
			threads[i] = new Thread(runnable);
		}
		
		for(int i=0; i<THREADS; i++) {
			threads[i].start();
		}
		
		for(int i=0; i<THREADS; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("program finished...");
		System.out.println("counter=" + counter.get());
	}
}
