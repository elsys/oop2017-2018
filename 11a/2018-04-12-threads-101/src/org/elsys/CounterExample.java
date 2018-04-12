package org.elsys;

public class CounterExample {
	public static final int THREADS = 10;
	
	private static long counter = 0;
	private static Object lock = new Object();
	
	public static void main(String[] argv) {
		Thread[] threads=new Thread[THREADS];
		
		for(int i=0; i<THREADS; i++) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("runnable started...");
					for(int i=0; i<1000000; i++) {
						synchronized (lock) {
							counter ++;
						}
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
		System.out.println("counter=" + counter);
	}
}
