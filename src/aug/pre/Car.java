package aug.pre;

public class Car implements Vehicle {

	@Override
	public void stat() {
		System.out.println("Car started");
		
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.stat();
		car.stop();
	}

}

interface Vehicle{
	void  stat();
	
	default void stop() {
		System.out.println("Vehicle stopped");
	}
}

