package ru.bukharov.training.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class CompletableFutureTest {

	@Test
	void defaultExecutorTest() throws ExecutionException, InterruptedException {
		CompletableFuture task = CompletableFuture
				.supplyAsync(getSupplier())
				.thenAccept((res) -> System.out.println("Result: " + res));

		System.out.println("Run");
		task.get();
	}

	@Test
	void customExecutorTest() throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newSingleThreadExecutor();

		CompletableFuture task = CompletableFuture
				.supplyAsync(getSupplier(), es)
				.thenAccept((res) -> System.out.println("Result: " + res));
		System.out.println("Run");
		task.get();
	}

	private Supplier<Integer> getSupplier() {
		return () -> {
			try {
				System.out.println("Start Task");
				Thread.sleep(1000);
				System.out.println("Finish Task");
				return 42;
			} catch (InterruptedException e) {
				e.printStackTrace();
				return 0;
			}
		};
	}
}
