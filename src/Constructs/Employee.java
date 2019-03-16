package Constructs;

public class Employee implements java.io.Serializable {
   String name;
   int age;
   String designation;
   double salary;
	
   public static final int COST = 1000;
   private static int s_time = 600;
   
   // This is the constructor of the class Employee
   public Employee(String name){
      this.name = name;
   }
   // Assign the age of the Employee  to the variable age.
   public void empAge(int empAge){
      age =  empAge;
   }
   /* Assign the designation to the variable designation.*/
   public void empDesignation(String empDesig){
      designation = empDesig;
   }
   /* Assign the salary to the variable	salary.*/
   public void empSalary(double empSalary){
      salary = empSalary;
   }
   
   private static void changeTime(int offset) {
	   s_time += offset;
   }
   
   private int getTime(){
	   return s_time;
   }
   
   /* Print the Employee details */
   public void printEmployee(){
      System.out.println("Name:"+ name );
      System.out.println("Age:" + age );
      System.out.println("Designation:" + designation );
      System.out.println("Salary:" + salary);
      
      Employee.changeTime(10);
      
      System.out.println(getTime());
   }
}
