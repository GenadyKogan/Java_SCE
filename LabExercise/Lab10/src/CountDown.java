
public class CountDown implements Runnable{

	private int id;
	private int counter;
	
	public CountDown(int id, int count){
		this.id = id;
		this.counter = count;
	}
	
	public void run() {
		while(counter>=0) {
			   System.out.println("Task "+id+", count = "+counter--);
			   try {
				   Thread.sleep((long) (100*Math.random()));
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }
			   Thread.yield();
			  }
		 }
		
}

