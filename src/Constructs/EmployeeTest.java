package Constructs;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import Constructs.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      /* Create two objects using constructor */
	      Employee empOne = new Employee("James Smith");
	      Employee empTwo = new Employee("Mary Anne");
	      
	      // Invoking methods for each object created
	      empOne.empAge(26);
	      empOne.empDesignation("Senior Software Engineer");
	      empOne.empSalary(1000);
	      empOne.printEmployee();

	      empTwo.empAge(21);
	      empTwo.empDesignation("Software Engineer");
	      empTwo.empSalary(500);
	      empTwo.printEmployee();
	 
	      
	      // 
	      // instanceof operator
	      //
	      System.out.println( empOne instanceof Employee);
	      
	      //
	      // for loop (foreach)
	      //
	      int intArray[] = { 0, 1, 2, 3, 4 };
	      
	      for ( int x : intArray )
	      {
	    	  System.out.print(x + ", ");
	      }
	      
	      //
	      // Numbers class
	      //
	      Integer x = 5;
	      x++;
	      System.out.println("\n" + x.doubleValue());

	      // 
	      // Arrays
	      //
	      int empArray[] = {3, 2, 1};

	      int retIntArray[] = arrayTester(empArray);
	      System.out.println(empArray.length + " : " + retIntArray.length);
	      
	      // Arrays utility class
	      System.out.println( Arrays.equals(empArray, retIntArray) );
	      Arrays.sort(empArray);
	      displayArray(empArray);
	      
	      //
	      // Date
	      //
	      Date today = new Date();
	      System.out.println("\nDate and time: " + today.toString());
	      
	      SimpleDateFormat df = new SimpleDateFormat("E dd.mm.yy hh::mm");
	      System.out.println(df.format(today));
	}

	private static int[] arrayTester(final int[] arrayParam)
	{
		int intArray[] = arrayParam;
		
		return intArray;
	}
	
	private static void displayArray(final int intArray[])
	{
		for( int i : intArray )
			System.out.print(i);
	}
}
