package june.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
	
	public static void main(String[] args) {
		List<Emp> empList= new ArrayList<Emp>();
		createEmployeeList(empList);
		
		Map<String,List<Emp>> empMap= empList.stream().collect(Collectors.groupingBy(Emp::getCity));
		empMap.forEach((key,val)->{
			System.out.println("City : "+ key + "   ---->  Employees "+ val);
		});
	}

	private static void createEmployeeList(List<Emp> empList) {
		Emp e1= new Emp("Arun", "1", "jaipur");
		Emp e2= new Emp("Rakesh", "2", "rajashath");
		Emp e3= new Emp("Raj", "3", "Up");
		Emp e4= new Emp("Kumar", "4", "Noida");
		Emp e5= new Emp("Anil", "5", "jaipur");
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		
	}
	
}
