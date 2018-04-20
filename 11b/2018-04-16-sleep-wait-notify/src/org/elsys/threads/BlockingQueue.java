package org.elsys.threads;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

	private List<T> queue = new LinkedList<>();
	private int capacity;

	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	public synchronized T pop() throws InterruptedException {
		while (queue.size() == 0) {
			System.out.println("Waiting for element");
			wait();
		}
		T result = queue.remove(0);
		System.out.println("Notifying push threads");
		notifyAll();
		return result;
	}

	public synchronized void push(T obj) throws InterruptedException {
		while (queue.size() == capacity) {
			System.out.println("Waiting for pop");
			wait();
		}
		queue.add(obj);
		System.out.println("Notifying pop threads");
		notifyAll();
	}
}
