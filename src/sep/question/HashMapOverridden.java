package sep.question;

import java.util.HashMap;

public class HashMapOverridden {
	 public static void main(String[] args) {
	        HashMap<Person, String> personMap = new HashMap<>();

	        Person p1 = new Person("Alice", 30);
	        Person p2 = new Person("Bob", 25);
	        Person p3 = new Person("Alice", 30);  // Same data as p1

	        personMap.put(p1, "Engineer");
	        personMap.put(p2, "Doctor");

	        // Checking if p3 is recognized as the same key as p1
	        System.out.println("p1 and p3 are equal: " + p1.equals(p3));
	        System.out.println("Job for p3 (same as p1): " + personMap.get(p3));
	    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding hashCode()
    @Override
    public int hashCode() {
        // Simple hash code calculation using name and age
        return name.hashCode() + age;
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Not the same class or null
        }
        Person other = (Person) obj;
        return name.equals(other.name) && age == other.age; // Compare fields
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
