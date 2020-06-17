import java.util.concurrent.ArrayBlockingQueue;
import java.util.LinkedList;
import java.util.Queue;
public class Consumer implements Runnable  {
//	private final ArrayBlockingQueue<Integer> queue;
//	private final int id;
//	private final int amount; //Number of products to consume
//	private final int PERIOD = 2000; //Time period for consuming one product
//	public Consumer(int id, int amount, ArrayBlockingQueue<Integer> q) {
//		this.id = id;
//		this.amount = amount;
//		queue =q;
//	}
//	public void run() {
//		try {
//			for (int i =0; i < amount; i++){
//				Thread.sleep(PERIOD);
//				consume(queue.take());
//			}
//		}catch (InterruptedException ignored) { }
//	}
//	private void consume(Integer prod){
//	System.out.println("Consumed: " + prod); //consume an Integer product
//
//	}
	private Queue<Integer> workingQueue;
	private final int id;
	private final int amount; //Number of products to consume
	private final int PERIOD = 2000; //Time period for consuming one product

	public Consumer(Queue<Integer> wq, int id, int amount) {
		workingQueue = wq;
		this.id = id;
		this.amount = amount;
	}
	public void run() {
		try {
			for (int i = 0; i < amount; i++){
				Thread.sleep((long) (PERIOD*Math.random()));
				consume(id);//consume an Integer product
			}
		} 
		catch (InterruptedException ignored) { } 
	}	
	 public Integer consume(int id) throws InterruptedException {
		 Integer ret = null;
		 synchronized(workingQueue){
			while (workingQueue.isEmpty())
				workingQueue.wait();
			ret = workingQueue.poll();
			System.out.println("Consuming ("+id+"): "+ret+"  *******> Queue size: "+ workingQueue.size()); 
			workingQueue.notifyAll();
		 }
		return ret;
	}
}