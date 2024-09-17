package aug;


public class NumberOfSeniorCitizens {

	public static void main(String[] args) {
		 String[] details1 = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
	        String[] details2 = {"1313579440F2036", "2921522980M5644"};
	        
	        System.out.println(countPassengersOver60(details1)); // Output: 2
	        System.out.println(characterBasedExtraction(details2)); // Output: 0
	}

	private static int countPassengersOver60(String[] details1) {
		int count=0;
		for(String str : details1) {
			
			int age = Integer.parseInt(str.substring(11, 13));
			if(age> 60) {
				count++;
			}
		}
		
		return count;
	}
	
	public  static int stringParsing(String[] details) {
		
		int seniorCount=0;
		
		for(String str : details) {
			int age=Integer.parseInt(str.substring(11,13));
			if(age>60) {
				seniorCount++;
			}
		}
		return seniorCount;
	}
	
	public static  int  characterBasedExtraction(String[] details){
		
		int count=0;
		
		for(String str:details) {
			int ageTens=str.charAt(11) -'0';
			int ageOnes=str.charAt(12) -'0';
			
			int age = ageTens * 10  + ageOnes;
			if(age > 60 ) {
				count++;
			}
		}
		
		return count;
	}
}
