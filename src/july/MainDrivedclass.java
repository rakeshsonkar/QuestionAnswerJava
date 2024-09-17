package july;

public class MainDrivedclass {

	public static void main(String[] args) {
		try {
			throw new Derived();
		} catch (Base b) {
			System.out.println("Caught base class exception");
		}//catch (Derived d) {
		//	System.out.println("Caught Derived class exception");
		//}
	}
	
}

@SuppressWarnings("serial")
class Base extends Exception{}

@SuppressWarnings("serial")
class Derived extends Base{}
