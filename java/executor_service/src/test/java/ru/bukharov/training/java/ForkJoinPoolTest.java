package ru.bukharov.training.java;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import org.junit.jupiter.api.Test;

class ForkJoinPoolTest {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Test
	void fibonacciTest() throws InterruptedException {
		ForkJoinFibonacci task = new ForkJoinFibonacci(50);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.execute(task);

		while(!task.isDone()) {
			System.out.println("Active thread count: " + forkJoinPool.getActiveThreadCount());
			System.out.println("Task count: " + forkJoinPool.getQueuedTaskCount());
			System.out.println("--------------------------------------");
			Thread.sleep(1000);
		}

		System.out.println("Finish: " + task.getResult());
	}

	private class ForkJoinFibonacci extends RecursiveAction {

		private static final long threshold = 10;
		private volatile long number;
		private volatile long result;

		ForkJoinFibonacci(long number) {
			this.number = number;
		}

		long getResult() {
			return result;
		}

		@Override
		protected void compute() {
			long n = number;
			if (n <= threshold) {
				result = fib(n);
			} else {
				ForkJoinFibonacci f1 = new ForkJoinFibonacci(n - 1);
				ForkJoinFibonacci f2 = new ForkJoinFibonacci(n - 2);
				ForkJoinTask.invokeAll(f1, f2);
				result = f1.result + f2.result;
			}
		}

		private long fib(long n) {
			if (n <= 1) return n;
			else return fib(n - 1) + fib(n - 2);
		}
	}
}
