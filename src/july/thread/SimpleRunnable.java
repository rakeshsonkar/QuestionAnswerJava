package july.thread;

import java.util.concurrent.TimeUnit;

public class SimpleRunnable implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Interrupted");
		}
		System.out.println("Ending Simple Thread");
		
	}

}
