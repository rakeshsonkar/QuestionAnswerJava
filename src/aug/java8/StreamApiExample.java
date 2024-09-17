package aug.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiExample {
	
	static List<Employee> employees = new ArrayList<Employee>();
	static {
		employees.add(new Employee("Shabbir","jain",5000.0,List.of("Project 1","Project 2")));
		employees.add(new Employee("Raj","Kumar",7000.0,List.of("Project 3","Project 4")));
		employees.add(new Employee("priyanka","gupta",10000.0,List.of("Project 5","Project 6")));
		employees.add(new Employee("Shivani","Singh",32000.0,List.of("Project 7","Project 8")));
	}
	
	public static void main(String[] args) {
		
		//Stream.of(employees);
		//forEach
		//employees.stream()
	//	.forEach(e->System.out.println(e));
		
		// map 
				Set<Employee> ls = employees.stream()
				.map(e-> new Employee(
						e.getFirstName(),
						e.getLastName(),
						e.getSalary() * 1.10,
						e.getProjects()
						)).collect(Collectors.toSet());
				
				System.out.println(ls);
				
				
				// filter 
				
			List<Employee> flList =	employees.stream().filter(e-> e.getSalary() > 7000.0)
				.map(e-> new Employee(
						e.getFirstName(),
						e.getLastName(),
						e.getSalary() * 10.0,
						e.getProjects()
						)).collect(Collectors.toList());
			
			System.out.println(flList);
				
	}

}
