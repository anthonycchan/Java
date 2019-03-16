/*
 * HOW TO COMPILE AND RUN IN COMMAND LINE
 * 
 * Compile:
 * C:\javac FirstJavaApp.java -d .
 * 
 * Run:
 * C:\java HelloWorld.FirstJavaApp
 *  
 */
package Constructs;

class EnumTester {
	enum EnumTest1 { string1, string2, string3 }
	
	EnumTest1 enumTest1Obj1;
}

class Vehicle {
	String engine = "3.0L";
	
	Mechanic autoMechanic = new Mechanic("Bill");
	
	Vehicle()
	{
		engine = "3.5L";
	}
	
	Vehicle(String engine)
	{
		//autoMechanic = new Mechanic();
		autoMechanic.setName("Pikachu");
		
		this.engine = engine;
	}
	public void setEngine(String engine)
	{
		this.engine = engine;
	}
	
	public String getEngine()
	{
		return engine;
	}
	
	Mechanic getMechanic()
	{
		return autoMechanic;
	}
	
	protected void finalize()
	{
		System.out.println("cleaning up" + engine);
	}
}

class Mechanic {
	String name;
	
	Mechanic(){}
	
	Mechanic(String name)
	{
		this.name = name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	
	String getName()
	{
		return this.name;
	}
	
	void replaceEngine(Vehicle vh)
	{
		vh.engine = "1.5L";
	}
	  
	void swapEngine(Vehicle vh)
	{
		Vehicle newVh = new Vehicle("2.0L");
		vh = newVh;
	}
	  
	protected void finalize()
	{
		System.out.println("cleaning up Mechanic");
	}
}

public class FirstJavaApp {

	public FirstJavaApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {	
		//
		// Enumerations
		//
		EnumTester enumTesterObj = new EnumTester();
		enumTesterObj.enumTest1Obj1 = EnumTester.EnumTest1.string1;
		System.out.println(enumTesterObj.enumTest1Obj1);
		
		//
		// Method pass by value
		//
		Vehicle vh1 = new Vehicle("1.3L");
		Mechanic meh1 = new Mechanic();
		meh1.replaceEngine(vh1);
		System.out.println(vh1.getEngine());
		
		// Try to point Vehicle pointer to another object (no change)
		meh1.swapEngine(vh1);
		System.out.println(vh1.getEngine());
		
		// NULL pointer
		meh1 = null;
		if ( meh1 != null )
			meh1.swapEngine(vh1);
		
		// Initialization only occurs in the constructor
		Vehicle vh2 = new Vehicle();
		System.out.println(vh2.getEngine());
	}

}
