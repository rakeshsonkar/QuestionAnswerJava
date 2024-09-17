package sep.question;

public class WaitNotifyExample {

	  public static void main(String[] args) {
	        final Object lock = new Object();

	        Thread waitingThread = new Thread(() -> {
	            synchronized (lock) {
	                try {
	                    System.out.println("Thread is waiting...");
	                    lock.wait();  // Releases the lock
	                    System.out.println("Thread resumed.");
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        Thread notifyingThread = new Thread(() -> {
	            synchronized (lock) {
	                try {
	                    Thread.sleep(3000);  // Simulate some work
	                    System.out.println("Notifying thread is waking up the waiting thread...");
	                    lock.notify();  // Wakes up the waiting thread
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        waitingThread.start();
	        notifyingThread.start();
	    }
}
