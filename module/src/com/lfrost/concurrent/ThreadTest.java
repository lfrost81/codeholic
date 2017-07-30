package com.lfrost.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
	ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	List<Thread> threads = new ArrayList<Thread>();

	void runThreads() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			threads.add(new Thread(new JobThread(i, queue)));
		}

		for (Thread thread : threads) {
			thread.start();
		}

		for (int i = 0; i < 10; i++) {
			queue.put(i);
		}

		for (Thread thread : threads) {
			queue.put(-1);
		}

		for (Thread thread : threads) {
			thread.join();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadTest tt = new ThreadTest();
		tt.runThreads();
	}
}

class JJ extends Thread {
	
}

class JobThread implements Runnable {
	private ArrayBlockingQueue<Integer> queue;
	private int id;

	public JobThread(int threadId, ArrayBlockingQueue<Integer> queue) {
		this.id = threadId;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			Integer n = null;
			try {
				n = queue.poll(2, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (n == -1) {
				System.out.println(id + " " + n);
				break;
			}
			System.out.println(id + " " + n);
		}
	}
}