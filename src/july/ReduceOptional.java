package july;

import java.util.List;
import java.util.Optional;

public class ReduceOptional {

	public static void main(String[] args) {
		
		//example
		List<Integer> list =List.of(1,2,3,4,5);
		Optional<Integer> opt=list.stream().reduce((a,b)->a+b);
		System.out.println(opt);
		
		
		@SuppressWarnings("unused")
		List<Integer> ls=List.of(1,2,3,4,5);
		int output= list.stream().reduce(0, Integer::sum) ;
		System.out.println(output);
		
		//Using 100 as Identity . Incorrect !
		List<Integer> list1 = List.of(1,2,3,4,5);
		int out=list1.parallelStream().reduce(100,(a,b)->{
			log1("accumulator",a,b);
			return a+b;
		});
		System.out.println(out);
		
		
		List<Integer> list2= List.of(1,2,3,4,5);
		String o=list2.stream().reduce("",(a,b)->a+b*b,String::concat);
		System.out.println(o);
		
			list2.parallelStream().reduce("",(r,e)->{
				log("accumulator", r, e);
				return r+e*e;
			},
				(s1,s2)->{
					log("combiner", s1, s2);
					return s1+s2;
				});
	}

	private static void log(String type, Object r, Object e) {
		
		String ThrName= Thread.currentThread().getName();
		System.out.printf("%S - %s(<%s>, <%s>)\n" ,ThrName,type,r,e);
	}

	private static void log1(String type, Integer a, Integer b) {
	
		String ThrName= Thread.currentThread().getName();
		System.out.printf("%S - %s(<%s>, <%s>)\n" ,ThrName,type,a,b);
	}
}
