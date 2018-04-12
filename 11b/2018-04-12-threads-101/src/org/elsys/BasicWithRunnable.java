package org.elsys;

public class BasicWithRunnable {

	public static void main(String[] argv) {
		Thread threads[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			Runnable runner = new Runnable() {

				@Override
				public void run() {
					System.out.println("Runnable run!!!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Runnable finished!!!");
				}

			};
			threads[i] = new Thread(runner);
		}

		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}

		for (int i = 0; i < 10; i++) {
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
