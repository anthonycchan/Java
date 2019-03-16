package Constructs;

import java.io.FileReader;
import java.io.IOException;

class ExceptionTest{
	void invokeMultipleException()
	{
		FileReader fr = null;
		try {
//			int data1[] = new int[2];
			//data1[2] = 1;
			
			fr = new FileReader("C:/output/input.txt");
			
			int c;
			while ( (c = fr.read()) != -1 )
			{
				System.out.print((char)c);
			}
		}
		catch (ArrayIndexOutOfBoundsException|IOException e1)
		{
			System.out.println(e1);
		}
		finally {
			try {
				fr.close();
				System.out.println("File closed");
			}catch (IOException|NullPointerException e1){
				System.out.println("Closing error");
			}
		}
	}
	
	//
	// Throwing exceptions to be handled by the caller.
	//
	void throwingExceptions1()
	{
		int x[] = new int[2];
		x[2] = 1;
	}
	void throwingExceptions2() throws IOException
	{
		FileReader fr = new FileReader("C:/output/input.txt");
		 
		int ch;
		while ( (ch = fr.read()) != -1 )
		{
			System.out.print(ch);
		}
		
		fr.close();
	}
	
	//
	// Java 7 addition: Try with Resources. Automatically closes resource in the try block
	//
	void tryWithResources()
	{
		try(FileReader fr = new FileReader("C:/output/input.txt")) {
			char data[] = new char[50];
			fr.read(data);
			System.out.println(data);
		}catch(IOException e) {
			System.out.println("tryWithResources: " + e);
		}
	}
	
	//
	// Custom exception
	//
	void customExceptionThrower() throws CustomException
	{
		throw new CustomException();
	}
}

//
// AutoClosable class
//
class TryWithResourcesClass implements AutoCloseable {
	public void close() throws IOException
	{
		System.out.println("Auto close");
	}
	
	public void fileResorce()
	{

	}
}

//
//Custom Exception
//
class CustomException extends Exception {
	static final long serialVersionUID = 1;  // Added to prevent compile time warning
	
	String display()
	{
		return "Display";
	}
}

public class Exceptions {

	public Exceptions() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) 
	{
		ExceptionTest et = new ExceptionTest();
		
		et.invokeMultipleException();
		
		//
		// Catching thrown exceptions
		//
		System.out.println("**Throwing Exceptions");
		try {
			et.throwingExceptions1();
			et.throwingExceptions2();
		}
		catch (ArrayIndexOutOfBoundsException|IOException e) {
			System.out.println(e);
		}
		
		//
		// Java 7 addition: Try with Resources. Automatically closes resource in the try block
		//
		System.out.println("**Try with Resources");
		et.tryWithResources();
		
		//
		// Testing class implements AutoClosable. The close method is automatically executed after the try block.
		//
		System.out.println("**Implements AutoClosable");
		try ( TryWithResourcesClass tryWithResource = new TryWithResourcesClass() )
		{}
		catch ( Exception e )
		{}
		
		//
		// Throws Custom Exception
		//
		System.out.println("**Throws Custom Exception");
		try {
			et.customExceptionThrower();
		}catch (CustomException e) {
			System.out.println(e + " " + e.display());
		}
	}
}
