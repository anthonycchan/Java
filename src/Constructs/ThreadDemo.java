package Constructs;

public class ThreadDemo extends Thread {

	private String threadName;
	private int pauseMs;
	
	public ThreadDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public ThreadDemo(String name) {
		super(name);
		this.threadName = name;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		System.out.println("running " + threadName);
		for ( int i = 0; i < 4; i++ ) {
			System.out.println(threadName + " " + i);
			try {
				Thread.sleep(this.pauseMs);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void start() {
//		this.pauseMs = pauseMs;
		super.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo td = new ThreadDemo("thread1");
		td.start();
		
		ThreadDemo td2 = new ThreadDemo("thread2");
		td2.start();
	}
	
}
