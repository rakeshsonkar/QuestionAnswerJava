package july.methodreference;

public class PrintTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		IPrint iPrint = (str) -> System.out.println(str);
		
		IPrint iPrint2= PrintTest::print;
		iPrint2.printData("Rakesh Sonkar");
		iPrint2.printData("Sonkar Rakesh");
	}
	
	public static String print(String s) {
		System.out.println(s);
		return s;
	}
}
