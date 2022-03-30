package ru.bukharov.training.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class ScheduledThreadPoolExecutorTest {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Test
	void delayTaskTest() throws InterruptedException {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture future = ses.schedule(() -> System.out.println("Executed task: " + getNow()), 5, TimeUnit.SECONDS);
		while(!future.isDone()) {
			System.out.println("Wait: " + getNow());
			Thread.sleep(1000);
		}
	}

	@Test
	void periodTaskTest() throws InterruptedException {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(() -> System.out.println("Executed task: " + getNow()), 0, 3, TimeUnit.SECONDS);
		Thread.sleep(10 * 1000);
	}

	private String getNow() {
		return dtf.format(LocalDateTime.now());
	}
}
