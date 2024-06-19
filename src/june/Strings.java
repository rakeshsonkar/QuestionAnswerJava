package june;

public class Strings {

	public static void main(String[] args) {
		//concatenation 
		String fName= "Rakesh";
		String lName="Sonkar";
		String fullName=fName+" "+lName;
		System.out.println(fullName.length());
		
		//charAt
		for (int i = 0; i < fullName.length(); i++) {
			System.out.print(fullName.charAt(i));
		}
		
		
		String name1="Tony";
		String name2="Tony";
		
		if(name1.compareToIgnoreCase(name2)==0) {
			System.out.println("String are equal");
			
		}else {
			System.out.println("String is  not  equal");
		}
		
	}
}
