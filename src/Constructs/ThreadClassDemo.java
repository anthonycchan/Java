package Constructs;

class DisplayMessage implements Runnable {
	private String message;
	private int intData;
	
	public DisplayMessage(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while ( true ) {
			System.out.println(this.message + " " + getIntData());
		}
	}
	
	public void setIntData(int intData) {
		this.intData = intData;
	}
	
	public int getIntData() {
		return this.intData;
	}
}

class GuessANumber extends Thread {
	private int number;
	public GuessANumber(int number) {
		this.number = number;
	}
	
	public void run() {
		int counter = 0;
	    int guess = 0;
	    
	    do {
	       guess = (int) (Math.random() * 100 + 1);
	       System.out.println(this.getName() + " guesses " + guess);
	       counter++;
	    } while(guess != number);
	    
	    System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.**"); 
	}
}

public class ThreadClassDemo {

	public ThreadClassDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		DisplayMessage hello = new DisplayMessage("hello");
		hello.setIntData(100);
		Thread thread1 = new Thread(hello);
		thread1.setDaemon(true);
		thread1.setName("thread1");
		System.out.println("Starting hello thread...");
		thread1.start();
		
		Runnable goodbye = new DisplayMessage("goodbye");
		Thread thread2 = new Thread(goodbye);
		thread2.setDaemon(true);
		thread2.setName("thread2");
		System.out.println("Starting goodbye thread...");
		thread2.start();
		
		System.out.println("Starting GuessANumber thread...");
		GuessANumber gan = new GuessANumber(97);
		gan.setName("thread3");
		gan.start();

		try {
			//
			// Join makes sure that the currently running (main) thread will run only if the gan thread stops running
			//
			gan.join();
		}
		catch ( InterruptedException exp ) {
			System.out.println(exp.toString());
		}
		
		System.out.println("Ending");
	}

}
