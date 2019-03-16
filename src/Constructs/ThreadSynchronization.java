package Constructs;

class Printer {
	public void print(String threadName) {
		for ( int i = 0; i < 5; i++ ) {
			System.out.println(threadName + " - " + i);
		}
	}
}

class ThreadSyncDemo extends Thread {
	Printer pd;
	ThreadSyncDemo(Printer pd, String threadName ) {
		setName(threadName);
		this.pd = pd;
	}
	
	public void run() {
		//
		// ensures only 1 thread executes at a time
		//
		synchronized (pd){
			pd.print(getName());
		}
	}
}

public class ThreadSynchronization {

	public ThreadSynchronization() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer pd = new Printer();
		ThreadSyncDemo td = new ThreadSyncDemo(pd, "thread1" );
		ThreadSyncDemo td2 = new ThreadSyncDemo(pd, "thread2" );
		
		td.start();
		td2.start();
		
		//
		// Join makes sure that the currently running (master) thread will run only if the slave threads stops running
		//
		try {
			td.join();
			td2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
