package june;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

	public static void main(String[] args) {
		String[] str1= {"cat","bat","rat"};
		String str =  "the cattle was rattled by the battery";
		
		List<String> str2=List.of(str1);
		
	List<String> l= new ArrayList<String>();
	l.add("a");
	l.add("b");
	l.add("c");
	String sentence = "aadsfasf absbs bbab cadsfafs";
	
		System.out.println(replaceWords(str2,str)); 
		System.out.println(replaceWords(l,sentence)); 

	}

	 public static String replaceWords(List<String> dictionary, String sentence) {
	        String[] s = sentence.split(" ");
	        for(String d: dictionary){
	            for(int i=0;i<s.length;i++){
	                if(s[i].startsWith(d))s[i]=d;
	            }
	        }
	        return String.join(" ",s);
	    }
}
