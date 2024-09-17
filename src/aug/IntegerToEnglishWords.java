package aug;

import java.util.Arrays;
import java.util.List;

public class IntegerToEnglishWords {

	private static final String[] lessThanTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	private static final String[] lessThanTwenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	private static final String[] lessThanHundred = {"","Ten","Twenty","thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	private static final int MIL = 1_000_000;
	private static final int BIL=1_000_000_000;
	private static StringBuilder res;
	
	public static void main(String[] args) {
		
		int num=123;
		int num1=12345;
		int num2=19;
		System.out.println(numberToWords(num));
		System.out.println(numberToWords(num1));
		System.out.println(numberToWords(num2));
		
		System.out.println(iterativeApproach(num));
		System.out.println(convertToWordsPairBasedApproach(num1));
		System.out.println(numberToWords(num2));
	}

	private static String numberToWords(int num) {
		if(num==0) {
			return "Zero";
		}
		
		res = new StringBuilder();
		makeNumber(num);
		return res.toString().trim();
	
	}

	private static void makeNumber(int num) {
		if(num==0) {
			return;
		}else if(num < 10) {
			res.append(lessThanTen[num]).append(" ");
		}else if(num < 20) {
			res.append(lessThanTwenty[num-10]).append(" ");
		}else if(num < 100) {
			res.append(lessThanHundred[num/10]).append(" ");
			makeNumber(num%10);
		}else if(num<1000) {
			res.append(lessThanTen[num/100]).append(" Hundred ");
			makeNumber(num%100);
		}else if(num<MIL) {
			makeNumber(num/1000);
			res.append("Thousand ");
			makeNumber(num % 1000);
		}else if(num<BIL) {
			makeNumber(num/MIL);
			res.append("Million ");
			makeNumber(num % MIL);
		}else {
			makeNumber(num / BIL);
			res.append("Billion ");
			makeNumber(num % BIL);
		}
	}
	
	String recursiveApproach(int num){
		 // Handle the special case where the number is zero
        if (num == 0) {
            return "Zero";
        }
        // Call the helper function to start the conversion
        return convertToWords(num);
        
	}

	private static String convertToWords(int num) {
		 // Recursive function to convert numbers to words
	    // Handles numbers based on their ranges: <10, <20, <100, <1000, <1000000, <1000000000, and >=1000000000
		
		if (num < 10) {
            return lessThanTen[num];
        }
        if (num < 20) {
            return lessThanTwenty[num - 10];
        }
        if (num < 100) {
            return lessThanHundred[num / 10] + (num % 10 != 0 ? " " + convertToWords(num % 10) : "");
        }
        if (num < 1000) {
            return convertToWords(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convertToWords(num % 100) : "");
        }
        if (num < 1000000) {
            return convertToWords(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convertToWords(num % 1000) : "");
        }
        if (num < 1000000000) {
            return convertToWords(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convertToWords(num % 1000000) : "");
        }
        return convertToWords(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convertToWords(num % 1000000000) : "");
	}
	
	private static String iterativeApproach(int num) {
		 // Handle the special case where the number is zero
        if (num == 0) return "Zero";
        
		// Arrays to store words for single digits, tens, and thousands
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};
        
        /// StringBuilder to accumulate the result
        StringBuilder result= new StringBuilder();
        int groupIndex=0;
     // Process the number in chunks of 1000
        
        while (num > 0) {
            // Process the last three digits
            if (num % 1000 != 0) {
                StringBuilder groupResult = new StringBuilder();
                int part = num % 1000;

                // Handle hundreds
                if (part >= 100) {
                    groupResult.append(ones[part / 100]).append(" Hundred ");
                    part %= 100;
                }

                // Handle tens and units
                if (part >= 20) {
                    groupResult.append(tens[part / 10]).append(" ");
                    part %= 10;
                }

                // Handle units
                if (part > 0) {
                    groupResult.append(ones[part]).append(" ");
                }

                // Append the scale (thousand, million, billion) for the current group
                groupResult.append(thousands[groupIndex]).append(" ");
                // Insert the group result at the beginning of the final result
                result.insert(0, groupResult);
            }
            // Move to the next chunk of 1000
            num /= 1000;
            groupIndex++;
        }
        return result.toString().trim();  
	}
	
	private static String convertToWordsPairBasedApproach(int num) {
		   if (num == 0) {
	            return "Zero";
	        }

		   for (NumberWord nw : numberToWordsList) {
	            // Check if the number is greater than or equal to the current unit
	            if (num >= nw.value) {
	                // Convert the quotient to words if the current unit is 100 or greater
	                String prefix = (num >= 100) ? numberToWords(num / nw.value) + " " : "";

	                // Get the word for the current unit
	                String unit = nw.word;

	                // Convert the remainder to words if it's not zero
	                String suffix = (num % nw.value == 0) ? "" : " " + numberToWords(num % nw.value);

	                return prefix + unit + suffix;
	            }
	        }

	        return "";
	}
	
	private static final List<NumberWord> numberToWordsList = Arrays.asList(
	        new NumberWord(1000000000, "Billion"), new NumberWord(1000000, "Million"),
	        new NumberWord(1000, "Thousand"), new NumberWord(100, "Hundred"),
	        new NumberWord(90, "Ninety"), new NumberWord(80, "Eighty"),
	        new NumberWord(70, "Seventy"), new NumberWord(60, "Sixty"),
	        new NumberWord(50, "Fifty"), new NumberWord(40, "Forty"),
	        new NumberWord(30, "Thirty"), new NumberWord(20, "Twenty"),
	        new NumberWord(19, "Nineteen"), new NumberWord(18, "Eighteen"),
	        new NumberWord(17, "Seventeen"), new NumberWord(16, "Sixteen"),
	        new NumberWord(15, "Fifteen"), new NumberWord(14, "Fourteen"),
	        new NumberWord(13, "Thirteen"), new NumberWord(12, "Twelve"),
	        new NumberWord(11, "Eleven"), new NumberWord(10, "Ten"),
	        new NumberWord(9, "Nine"), new NumberWord(8, "Eight"),
	        new NumberWord(7, "Seven"), new NumberWord(6, "Six"),
	        new NumberWord(5, "Five"), new NumberWord(4, "Four"),
	        new NumberWord(3, "Three"), new NumberWord(2, "Two"),
	        new NumberWord(1, "One")
	    );
	
}

class NumberWord {
    int value;
    String word;

    NumberWord(int value, String word) {
        this.value = value;
        this.word = word;
    }
}