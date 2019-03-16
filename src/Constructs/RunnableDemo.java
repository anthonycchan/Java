package Constructs;

public class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;
	private int pauseMs;
	
	public RunnableDemo(String name) {
		// TODO Auto-generated constructor stub
		threadName = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
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

	public void start(int pauseMs) {
		if ( t == null ) {
			t = new Thread(this, this.threadName);
			this.pauseMs = pauseMs;
			t.start();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo rd = new RunnableDemo("thread1");
		rd.start(100);
		
		RunnableDemo rd2 = new RunnableDemo("thread2");
		rd2.start(1000);
	}

}
