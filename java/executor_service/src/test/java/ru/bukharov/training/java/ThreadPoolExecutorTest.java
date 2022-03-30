package ru.bukharov.training.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class ThreadPoolExecutorTest {

	@Test
	void simpleTest() {
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(() -> System.out.println("Executed in another thread"));
	}

	@Test
	void futureTest() throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> future = es.submit(() -> "Thread result");
		while (!future.isDone()) {
			System.out.println("Wait thread");
		}
		System.out.println("Finish: " + future.get());
	}

	@Test
	void severalThreadsTest() {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(() -> executeMyTask("Thread 1"));
		es.submit(() -> executeMyTask("Thread 2"));
		es.submit(() -> executeMyTask("Thread 3"));
		es.submit(() -> executeMyTask("Thread 4"));
		es.submit(() -> executeMyTask("Thread 5"));

		awaitFinish(es);
	}

	private void awaitFinish(ExecutorService es) {
		es.shutdown();
		try {
			es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void executeMyTask(String name) {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(name + ": iteration: " + i);
					Thread.sleep((long)(Math.random()*1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
