package org.elsys;

// http://greenteapress.com/semaphores/LittleBookOfSemaphores.pdf

public class Basic extends Thread {

	@Override
	public void run() {
		System.out.println("Thread run!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread finished!!!");
	}
	
	public static void main(String[] argv) {
		Thread threads[] = new Thread[10];
		for(int i=0; i<10; i++) {
			threads[i] = new Basic();
		}
		
		for(int i=0; i<10; i++) {
			threads[i].start();
		}
		
		
		for(int i=0; i<10; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Program ended!!!!");
	}
}
