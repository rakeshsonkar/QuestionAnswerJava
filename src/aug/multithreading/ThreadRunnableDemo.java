package aug.multithreading;

public class ThreadRunnableDemo {
	public static void main(String[] args) {
		Runnable greeter = new Greeter();
		Thread greetThread= new Thread(greeter);
		greetThread.start();
	}

}

class Greeter implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String  name = Thread.currentThread().getName();
		System.out.println("Hello! From  thread : " +name);
		
	}
	 
}
