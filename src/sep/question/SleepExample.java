package sep.question;

public class SleepExample {

	 public static void main(String[] args) {
	        Thread sleepingThread = new Thread(() -> {
	            try {
	                System.out.println("Thread is sleeping for 2 seconds...");
	                Thread.sleep(2000);  // Pauses for 2 seconds, but keeps the lock
	                System.out.println("Thread woke up.");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        sleepingThread.start();
	    }
}
