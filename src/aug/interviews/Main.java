package aug.interviews;

public class Main {

	public static void main(String[] args) {
		/*
		 * System.out.println(28.100>28.1 );
		 * 
		 * System.out.println("1"=="1 "); System.out.println(1==1 );
		 */
		/*
		 * int count =827; int oct=036; int hexa=0x37e; int binar=0b10101;
		 * 
		 * System.out.println(count); System.out.println(oct); System.out.println(hexa);
		 * System.out.println(binar);
		 */
		
		A b= new C();
	}
}

class A{
	A(){
		System.out.println("test A");
	}
}
class B extends A{
	B(){
		//super();
		System.out.println("test B");
	}
}
class C extends B{
	C(){
		System.out.println("c");
	}
}
