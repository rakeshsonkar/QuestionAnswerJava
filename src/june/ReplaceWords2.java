package june;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords2 {

	public static void main(String[] args) {
		List<String> l= new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		String sentence = "aadsfasf absbs bbab cadsfafs";
		ReplaceWords2 s= new ReplaceWords2();
		System.out.println( s.replaceWords(l, sentence));
	}
	
	public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(word, dict));
        }
        
        return result.toString();
    }
    private String findRoot(String word, Set<String> dict) {
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (dict.contains(prefix)) {
                return prefix;
            }
        }
        return word; 
    }  

}
