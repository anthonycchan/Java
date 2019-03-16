package Constructs;

import java.io.*;

import Constructs.Employee;

public class Serialization {

	public Serialization() {
		// TODO Auto-generated constructor stub
	}

	public void serialize(Employee emp1) {
		System.out.println("Serializing");
		try {
			FileOutputStream fout = new FileOutputStream("C:/output/serializationTest.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(emp1);
			out.close();
			fout.close();
		}
		catch (IOException exp ) {
			System.out.println(exp.toString());
		}
	}
	
	public Employee deserialize() {
		System.out.println("Deserializing");
		Employee emp1 = null;
		
		try {
			FileInputStream fin = new FileInputStream("C:/output/serializationTest.ser");
			ObjectInputStream in = new ObjectInputStream(fin);
			emp1 = (Employee) in.readObject();
			in.close();
			fin.close();
		}
		catch ( IOException exp ) {
			System.out.println(exp.toString());
		}
		catch ( ClassNotFoundException exp ) {
			System.out.println(exp.toString());
		}
		
		return emp1;
	}
	
	public static void main( String args[] )
	{
		Serialization serialObj = new Serialization();
		
		Employee emp1 = new Employee("Anthony");
		emp1.empAge(28);
		emp1.empSalary(1000000);
		emp1.empDesignation("Team lead");
		serialObj.serialize(emp1);
		
		Employee emp2 = serialObj.deserialize();
		System.out.println( emp2.name + " " + emp2.age + " " + emp2.salary + " " + emp2.designation);
	}
}
