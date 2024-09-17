package sep.question;

public class Main {
	public static void main(String[] args) {
		  Dog dog = new Dog("Buddy");
	        dog.sound();
	}
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);  // Call the constructor of the abstract class
    }

    // Implementing abstract method
    public void sound() {
        System.out.println(name + " barks.");
    }

	
}

abstract class Animal {
    String name;

    // Constructor in the abstract class
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called: " + name);
    }

    // Abstract method
    public abstract void sound();
    
    
}
