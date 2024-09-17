package aug.multithreading;

public class FirstExample {

	public static void main(String[] args) {
		Thread currentThread =  Thread.currentThread();
		System.out.println("Thread name  is  ::: "+ currentThread.getName());
	}
}
