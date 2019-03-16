package Constructs;

class Chat {
	private boolean flag = false;
	private int counter = 0;
	
	//
	// synchronize ensures only 1 thread executes this method at a time
	//
	public synchronized void Question(String str) {
		if ( flag ) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(str + " " + counter++);
		flag = true;
		notify();
	}
	
	public synchronized void Answer(String str) {
		if ( !flag ) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(str + " " + counter++);
		flag = false;
		notify();
	}
	
	public synchronized void print(String threadName) {
		for ( int i = 0; i < 50; i++ ) {
			System.out.println(threadName + " " + i);
		}
	}
}

class T1 implements Runnable {
	private Chat ch;
	
	T1 (Chat ch) {
		this.ch = ch;
		new Thread(this, "QuestionThread").start();	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String questions[] = { "Hi", "How are you?" };
		for ( String str : questions)
			ch.Question(str);
	}

}

class T2 implements Runnable {
	Chat ch;
	T2 (Chat ch) {
		this.ch = ch;
		new Thread(this, "AnswerThread").start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String answers[] = { "Hello", "I'm fine thank you" };
		for ( String str : answers )
			ch.Answer(str);
	}
}

class T3 implements Runnable {
	Chat ch;
	Thread t; 
	
	T3(Chat ch) {
		this.ch = ch;
	}
	
	public void start() {
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.ch.print(t.getName());
	}
	
}

public class ThreadCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chat ch = new Chat();
		
		// 
		// Multiple synchronized method
		//
		new T1(ch);
		new T2(ch);
		
		//
		// Single synchronized method
		//
		T3 t3 = new T3(ch);
		T3 t3_1 = new T3(ch);
		t3.start();
		t3_1.start();
		
		// Test thread deadlock
		ThreadComDemo1 tcd1 = new ThreadComDemo1();
		ThreadComDemo2 tcd2 = new ThreadComDemo2();
		tcd1.start();
		tcd2.start();
	}

	//
	// Thread deadlock
	// When control is in synchronized(lock1) block of ThreadComDemo1, ThreadComDemo2 cannot enter its synchronized(lock1) block
	// When control is in synchronized(lock2) block of ThreadComDemo2, ThreadComDemo1 cannot enter its synchronized(lock2) block
	//
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	private static class ThreadComDemo1 extends Thread{		
		public void run() {
			synchronized(lock1) {
				System.out.println("ThreadComDemo1: lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Waiting for lock2 to release");
				synchronized(lock2) {
					System.out.println("ThreadComDemo1: lock2");
				}
			}
		}
	}
	
	private static class ThreadComDemo2 extends Thread{
		public void run() {
			synchronized(lock2) {
				System.out.println("ThreadComDemo2: lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Waiting for lock1 to release");
				synchronized(lock1) {
					System.out.println("ThreadComDemo1: lock2");
				}
			}
		}
	}
}
