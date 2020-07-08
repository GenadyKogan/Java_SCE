package threads.callback;


public class CallbackLifeCycle extends Thread {
	
	public CallbackLifeCycle(String name) {
		super(name);
	}

	public void run() {
	  	long time;
	  	try{
	  		time = (long)(Math.random()*10000L);
	  		Thread.sleep(time);
	  		CallbackUserInterface.receiveResponse(time, getName());
	  	}
	  	catch (InterruptedException ex) {
	      System.err.println(ex);
	    }
  }

}
