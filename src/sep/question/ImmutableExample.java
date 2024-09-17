package sep.question;

import java.util.Date;

public class ImmutableExample {

	public static void main(String[] args) {
		 Date birthDate = new Date();
	        ImmutablePerson person = new ImmutablePerson("John", 25, birthDate);

	        System.out.println("Name: " + person.getName());
	        System.out.println("Age: " + person.getAge());
	        System.out.println("Birth Date: " + person.getBirthDate());

	        // Trying to modify the birthDate field through the returned reference
	        birthDate.setTime(birthDate.getTime() + 1000000000L);

	        // The birthDate inside ImmutablePerson is not changed
	        System.out.println("Modified Birth Date: " + person.getBirthDate());
	}
}
 final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Date birthDate;  // A mutable object

    // Constructor to initialize all fields
    public ImmutablePerson(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        // Create a defensive copy of the mutable Date object
        this.birthDate = new Date(birthDate.getTime());
    }

    // Getter methods that return the field values
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Return a defensive copy of the Date object to preserve immutability
    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }

    // No setters provided (no methods to modify the object's state)
}
