package Constructs;

public class Inheritance {

	protected int sampleInt1 = 3;
	
	public Inheritance() {
		// TODO Auto-generated constructor stub
		System.out.println("superclass constructor");
	}

	public void print() {
		System.out.println("super class print method" + sampleInt1);
	}
	
	public static void main(String args[]) {
		Inheritance superClass = new Inheritance();
		
		superClass.print();
		
		superClass = new subClass();
		superClass.print();
	}
}

class subClass extends Inheritance {	
	public subClass() {
		System.out.println("subclass constructor");
	}
	
	public void print() {
		System.out.println("Subclass print method" + sampleInt1);
	}
}
