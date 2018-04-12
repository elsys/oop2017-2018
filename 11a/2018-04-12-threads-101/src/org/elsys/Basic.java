package org.elsys;

public class Basic extends Thread {
	public static final int THREADS = 10;
	
	@Override
	public void run() {
		System.out.println("thread started...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread finished...");
	}
	
	public static void main(String[] argv) {
		Thread[] threads=new Thread[THREADS];
		
		for(int i=0; i<THREADS; i++) {
			threads[i] = new Basic();
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
	}
}
