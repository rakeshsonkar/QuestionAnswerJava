package sep.array;



public class ClassLoaderExample {
	public static void main(String[] args) {
		
		HashMap hashMap = new HashMap();
		System.out.println(hashMap.size());
		
		System.out.println("System.getClass().getClassLoader() : " 
                + System.class.getClassLoader());
	}

}
