package sep.infobook;

public class SplittingString {

	public static void main(String[] args) {
		/*
		 * String textfile = "ReadMe.txt"; String filename = textfile.split("\\.")[0];
		 * String extension = textfile.split("\\.")[1];
		 * 
		 * System.out.println(filename); System.out.println(extension);
		 */
		
		String textfile1 = "ReadMe.txt";
		String filename1 = textfile1.split("[.]")[1];
		//String extension1 = textfile1.split(".")[1];
		
		System.out.println(filename1);
		//System.out.println(extension1);
		
	}
}
