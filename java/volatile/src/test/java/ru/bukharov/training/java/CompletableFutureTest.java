package ru.bukharov.training.java;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

/**
 * First thread changes the flag
 * Second thread waits when the flag will be change
 *
 * 1) if flag is NOT volatile: second thread doesn't see changes
 * 2) if flag is volatile: second thread can see changes
 */
class VolatileTest {

	boolean sayHello;
	volatile boolean sayHelloVolatile;

	@Test
	void notVolatileVarTest() throws InterruptedException {
		System.out.println("Use NOT volatile flag.\n\n"
				+ "Expected:\n"
				+ "Say Hello..\n"
				+ "Say Bye..\n\n"
				+ "Actual:");
		Thread thread = new Thread(() -> {
			while(!sayHello) {
			}
			System.out.println("Hello World!");

			while(sayHello) {
			}
			System.out.println("Good Bye!");
		});

		thread.start();

		Thread.sleep(1000);
		System.out.println("Say Hello..");
		sayHello = true;

		Thread.sleep(1000);
		System.out.println("Say Bye..");
		sayHello = false;
	}

	@Test
	void volatileVarTest() throws InterruptedException {
		System.out.println("Use volatile flag.\n\n"
				+ "Expected:\n"
				+ "Say Hello..\n"
				+ "Hello World!\n"
				+ "Say Bye..\n"
				+ "Good Bye!\n\n"
				+ "Actual:");
		Thread thread = new Thread(() -> {
			while(!sayHelloVolatile) {
			}
			System.out.println("Hello World!");

			while(sayHelloVolatile) {
			}
			System.out.println("Good Bye!");
		});

		thread.start();

		Thread.sleep(1000);
		System.out.println("Say Hello..");
		sayHelloVolatile = true;

		Thread.sleep(1000);
		System.out.println("Say Bye..");
		sayHelloVolatile = false;
	}

}
