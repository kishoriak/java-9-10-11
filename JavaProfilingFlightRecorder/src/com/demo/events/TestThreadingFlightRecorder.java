package com.demo.events;

import java.util.concurrent.*;

class TestThreadingFlightRecorder {
	private static BlockingQueue<byte[]> queue = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) {
		Runnable producer = () -> {
			while(true) {
				queue.offer(new byte[1*1024*1024]);
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumer = () -> {
			while(true) {
				try {
					queue.take();
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(producer, "Producer Thread").start();
		new Thread(consumer, "Consumer Thread").start();
	}
}