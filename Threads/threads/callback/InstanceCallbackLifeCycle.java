package threads.callback;


public class InstanceCallbackLifeCycle extends Thread {
	
	private InstanceCallbackUserInterface callback;
	
	public InstanceCallbackLifeCycle(String name, InstanceCallbackUserInterface callback) {
		super(name);
		this.callback = callback;
	}

	public void run() {
	  	long time;
	  	try{
	  		time = (long)(Math.random()*10000L);
	  		Thread.sleep(time);
	  		callback.receiveResponse(time, getName());
	  	}
	  	catch (InterruptedException ex) {
	      System.err.println(ex);
	    }
  }

}
