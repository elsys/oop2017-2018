package org.elsys.threads;

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new BlockingQueue<>(4);

		Runnable pusher = new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (i < 10) {
					i++;
					try {
						Thread.sleep(50);
						queue.push(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Runnable popper = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(50);
						queue.pop();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};

		for (int i = 0; i < 5; i++) {
			new Thread(pusher).start();
			new Thread(popper).start();
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
