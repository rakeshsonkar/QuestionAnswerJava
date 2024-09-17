package june.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainJava8 {

	public static void main(String[] args) {

		System.out.println("Top 25 java 8 codding Question and Ans . ");

		List<Integer> nums = Arrays.asList(10, 12, 22, 5, 100, 13, 55, 53, 10, 22, 1, 2);
		System.out.println("find the First element of the list using streams function");
		nums.stream().findFirst().ifPresent(System.out::println);
		System.out.println("find the total element of the list using streams function");
		System.out.println(nums.stream().count());
		System.out.println("find Out EVEN and Odd element of the list using streams function");
		nums.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
		System.out.println();
		nums.stream().filter(num -> num % 2 != 0).forEach(System.out::println);
		System.out.println();
		System.out.println("find start with 5 element of the list using streams function");
		nums.stream().filter(n -> n.toString().startsWith("5")).forEach(System.out::println);

		System.out.println("find duplicate element of the list using streams function");
		// nums.stream().filter(n->n.toString().startsWith("5")).forEach(System.out::println);
		Set<Integer> temp = new HashSet<Integer>();
		nums.stream().filter(num -> !temp.add(num)).forEach(System.out::println);

		System.out.println("find min and max element of the list using streams function");
		Optional<Integer> max = nums.stream().max(Integer::compareTo);
		Optional<Integer> min = nums.stream().min(Integer::compareTo);
		System.out.println(max.orElse(null));
		System.out.println(min.orElse(null));

		System.out.println("find Sort element of the list using streams function");

		nums.stream().sorted().forEach(System.out::println);
		System.out.println("find Sort reverseOrder element of the list using streams function");
		nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("Check array contain duplicate values or  not.");
		int[] numbers = { 1, 2, 3, 4, 5,5, 1 };

		if (Arrays.stream(numbers).distinct().count() != numbers.length) {
			System.out.println("It contin duplicate value");
		} else {
			System.out.println("Not cantains");
		}
		System.out.println("find square elements and filter numbers greater than 50.");
		nums.stream().map(num -> num * num).filter(num -> num > 50).forEach(System.out::println);

		System.out.println("find sort array convert in stream ");
		Arrays.sort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);

		System.out.println("find map convert words into uppercase the in stream ");
		List<String> words=Arrays.asList("Dev","Byte","school","Dev","Byte");
		words.stream().map(word->word.toUpperCase()).forEach(System.out::println);
		System.out.println("find the maximum element in array? ");
		Arrays.stream(numbers).max().ifPresent(System.out::println);
		
		System.out.println("concatenate two Streams");
		
		Stream<Integer> s1=Stream.of(1,2,3);
		Stream<Integer> s2=Stream.of(5,6,4);
		Stream.concat(s1, s2).forEach(System.out::println);
		System.out.println(" Streams 10 random number");
		Random random= new Random();
		Stream.generate(random::nextInt).limit(10).forEach(System.out::println);
		System.out.println("Print date and Time using java feature ?");
		
		LocalDateTime dateTime= LocalDateTime.now();
		System.out.println(dateTime);
		System.out.println("Print date and Time using java feature then format it in dd-mm-yyyy ?");
		DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(dateTimeFormatter.format(dateTime));
		Optional<List<String>> list1= Optional.ofNullable(words);
		list1.ifPresentOrElse(i->i.stream().forEach(System.out::println), ()->System.out.println("the list is empty"));
		System.out.println("find the occurrencess");
		int[] values= {10,1,20,2,100,100,100};
		int number=10;
		long res=Arrays.stream(values).filter(v->v==number).count();
		System.out.println(res);
		
		Map<String,Long> map =words.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
		map.entrySet().stream().filter(m->m.getValue()>1).forEach(m->System.out.println(m.getKey() + " : "+m.getValue()));
		System.out.println("give sum of salary of all employee");
		Employee emp=new Employee("test1",1000);
		Employee emp1=new Employee("test2",11000);
		Employee emp2=new Employee("test3",15000);
		Employee emp3=new Employee("test4",50000);
		Employee emp4=new Employee("test1",50000);
		List<Employee> employees= new ArrayList<Employee>();
		employees.add(emp);
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		System.out.println(employees.stream().mapToDouble(Employee::getSalary).sum());
		
		String str="DevByteSchool";
		Map<Character,Long> charCount=str.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(charCount);
		Map<String, Double> uniqueEmployee=	employees.stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary,
				(existing,replacement)->existing,
				()-> new TreeMap<>(Comparator.naturalOrder())));
		System.out.println(uniqueEmployee);
		
		
	}
}
