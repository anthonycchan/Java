package Constructs;

abstract class Mammal {
	public void eat() {
		System.out.println("Animal is eating");
	}
	
	public abstract void print();
}

public class AbstractClass extends Mammal {

	public AbstractClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void print() {
		eat();
		System.out.println("print method");
	}
	
	public static void main(String args[]) {
		AbstractClass vh1 = new AbstractClass();
		vh1.print();
	}
}
