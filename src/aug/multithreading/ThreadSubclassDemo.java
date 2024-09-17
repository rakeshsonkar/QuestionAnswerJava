package aug.multithreading;

public class ThreadSubclassDemo {

	public static void main(String[] args) {
		Thread greaderThread = new Greeter1();
		greaderThread.start();
		
	}
	
}

class Greeter1 extends Thread{
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Hello! from Thread:  "+ name );
	}
}