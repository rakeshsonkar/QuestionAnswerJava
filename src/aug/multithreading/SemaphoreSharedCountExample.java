package aug.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreSharedCountExample {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		new IncrementCount(sem, "A");
		new DecrementCount(sem, "B");
	}

}

class Shared{
	static int count = 0;
}

class IncrementCount {
	String name;
	Semaphore sem;
	public IncrementCount(Semaphore sem,String name) {
		this.sem=sem;
		this.name=name;
		new Thread(r1).start();
	}
	
	Runnable r1=()->{
		try {
			System.out.println(name + " is  waiting for a  permit.");
			sem.acquire();
			System.out.println(name + " gets a permit.");
			
			for(int i=0;i<5;i++) {
				Shared.count++;
				System.out.println(name +" : " + Shared.count);
				Thread.sleep(10);
			}
			
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(name + "  releases the permit.");
		sem.release();
	};
}

class DecrementCount {
	String name;
	Semaphore sem;
	public DecrementCount(Semaphore sem,String name) {
		this.sem=sem;
		this.name=name;
		new Thread(r2).start();
	}
	
	Runnable r2=()->{
		try {
			System.out.println(name + " is  waiting for a  permit.");
			sem.acquire();
			System.out.println(name + " gets a permit.");
			
			for(int i=0;i<5;i++) {
				Shared.count--;
				System.out.println(name +" : " + Shared.count);
				Thread.sleep(10);
			}
			
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(name + "  releases the permit.");
		sem.release();
	};
}
