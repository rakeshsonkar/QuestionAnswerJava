package july.thread;

public class Main {

	public static void main(String[] args) {
		Thread thread1 = new SimpleThread("Simple", 2);
		thread1.start();
		
		Runnable r = new SimpleRunnable();
		Thread th= new Thread(r);
		th.start();
		
		//Runnable r1= new SimpleRunnable();
		//Thread thr= Thread.ofPlatform().name("Simple").daemon(true).start(r1);
		
		// 
		
		Thread thread12 =Thread.currentThread();
		System.out.println(thread12.getName());
		Thread thread = new Thread();
				
				Thread.interrupted();
		@SuppressWarnings("unused")
		boolean interrupted = thread.isInterrupted();
		
		
	}
}
