package june;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatedValues {
	public static void main(String[] args) {
		String str="RakeshSonkar";
		
		Map<Character, Long> res= str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		System.out.println(res);
		Optional<Character> firstnonrepeatedVaule = res.entrySet().stream().filter(f->f.getValue()==1).map(d->d.getKey()).findFirst();
		firstnonrepeatedVaule.ifPresent(t->System.out.println(t));
		Optional<Character> firstrepeatedVaule = res.entrySet().stream().filter(f->f.getValue()>1).map(Map.Entry::getKey).skip(0).findFirst();
		firstrepeatedVaule.ifPresentOrElse(System.out::println, ()->System.out.println("data is not found"));
		System.out.println();
		
	}

}
