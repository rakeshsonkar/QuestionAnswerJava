package sep;

class SharedObj{
	private volatile boolean flag = false;
	
	public void setFalgTrue() {
		System.out.println("Writer thread made the flag true !");
		flag= true;
	}
	
	public void printIfFlagTrue() {
		while(!flag) {
			//do nothing
		}
		System.out.println("Flag is  true !");
	}
}

public class VolatileExample {

	public static void main(String[] args) {
		SharedObj obj =  new SharedObj();
		
		Thread writerThread = new Thread(()->{
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			obj.setFalgTrue();
		});
		
		Thread readerThread = new Thread(()->obj.printIfFlagTrue());
		writerThread.start();
		readerThread.start();
	}
}
