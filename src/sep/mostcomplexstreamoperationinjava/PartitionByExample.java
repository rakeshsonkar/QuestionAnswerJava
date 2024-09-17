package sep.mostcomplexstreamoperationinjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PartitionByExample {

	public static void main(String[] args) {
		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6);
		Map<Boolean, List<Integer>> ressult= numbers.stream()
				.collect(Collectors.partitioningBy(n-> n%2==0));
		
		System.out.println(ressult);
		
//		Map<Boolean,List<Customer>> customerPartition = customerList.stream()
//				.collect(Collectors.partitioningBy(cust->cust.getTotalSpend() > 10000));
		
		List<String> words = Arrays.asList("apple","banana","cherry","date");
		long count = words.stream().collect(Collectors.counting());
		System.out.println(count);
		
	IntSummaryStatistics start = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
	System.out.println(start);
	
List<Integer> lengths =words.stream().collect(Collectors.mapping(String::length, Collectors.toList()));
	System.out.println(lengths);
	
	String result = words.stream().collect(Collectors.joining(", ","[","]"));
	System.out.println(result);
	
	Map<Integer, Long> res= words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting()));
	System.out.println(res);
	
	
	List<Integer> event= numbers.stream().collect(Collectors.filtering(n-> n % 2 == 0, Collectors.toList()));
	System.out.println(event);
	
	
	int size= words.stream().collect(Collectors.collectingAndThen(Collectors.toSet(),  Set::size));
	System.out.println(size);
	
	IntSummaryStatistics totalLength = words.stream().collect(Collectors.mapping(String::length, Collectors.summarizingInt(Integer::intValue)));
	System.out.println(totalLength);
	
	ConcurrentMap<String,Integer> map = words.stream().collect(Collectors.toConcurrentMap(Function.identity(), String::length));
	System.out.println(map);
	
	int sum=numbers.stream().collect(Collectors.reducing(0,Integer::sum));
	System.out.println(sum);
	
//	Map<String,Integer> resulttest= numbers.stream().collect(Collectors.teeing(
//			Collectors.summarizingInt(Integer::intValue),
//			Collectors.counting(),
//			(sum,count) -> Map.of("sum", sum, "count",count.intValue())
//			));
//	
	
	
	 List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

     Map<String, Integer> resulttest = numbers1.stream().collect(Collectors.teeing(
         Collectors.summarizingInt(Integer::intValue),
         Collectors.counting(),
         (summarized, totalCount) -> Map.of(
                 "sum", (int) summarized.getSum(), // extracting sum from IntSummaryStatistics
                 "count", totalCount.intValue()
                 )
     ));

     System.out.println(resulttest);
     
     //System.out.println("rakesh"*3);
	}

}

class Customer{
	
}
