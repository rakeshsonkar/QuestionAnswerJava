package july.thread;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {

	private final int secs;
	
	public SimpleThread(String name,int seces) {
		// TODO Auto-generated constructor stub
		this.secs=seces;
		this.setName(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s : Starting simple Thread \n",this.getName());
		
		try {
			TimeUnit.SECONDS.sleep(this.secs);
		} catch (InterruptedException e) {
			System.out.println(" Interrupted");
		}
		System.out.printf("%s : Starting simple Thread \n",this.getName());
	}
}
