package org.elsys.threads;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

	private List<T> queue;
	private int size;
	private int capacity;

	public BlockingQueue(int capacity) {
		queue = new LinkedList<>();
		size = 0;
		this.capacity = capacity;
	}
	
	public synchronized T pop() throws InterruptedException {
		while (size == 0) {
			System.out.println("Waiting for element to be pushed...");
			wait();
		}
		T result = queue.get(--size);
		System.out.println("Notifying push threads...");
		notifyAll();
		return result;
	}
	
	public synchronized void push(T obj) throws InterruptedException {
		while (size == capacity) {
			System.out.println("Waiting for element to be popped...");
			wait();
		}
		queue.add(obj);
		size++;
		System.out.println("Notifying pop threads...");
		notifyAll();
	}
}
