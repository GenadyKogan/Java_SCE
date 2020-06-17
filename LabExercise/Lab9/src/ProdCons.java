import java.util.concurrent.ArrayBlockingQueue;
import java.util.LinkedList;
import java.util.Queue;
public class ProdCons {
	final static int BOUND = 10;
	final static int AMOUNT = 10;
	final static int NUMBER_OF_PRODUSERS = 4;
	final static int NUMBER_OF_CONSUMERS = 2;		
	private static Queue<Integer> workingQueue;
	public static void main(String args[]) {
//		final int BOUND = 5;
//		final int AMOUNT = 10;
//		ArrayBlockingQueue<Integer> q = new
//		ArrayBlockingQueue<Integer>(BOUND);
//		Producer p1 = new Producer(1,AMOUNT,q);
//		Producer p2 = new Producer(2,AMOUNT,q);
//		Consumer c = new Consumer(3,2*AMOUNT,q);
//		new Thread(p1).start();
//		new Thread(p2).start();
//		new Thread(c).start();
		workingQueue = new LinkedList<Integer>();
		Producer[] prod = new Producer[NUMBER_OF_PRODUSERS];
		Consumer[] cons = new Consumer[NUMBER_OF_CONSUMERS];
		for(int i = 0; i<NUMBER_OF_PRODUSERS; i++)
			prod[i] = new Producer(workingQueue,i+1,AMOUNT);
		for(int i = 0; i<NUMBER_OF_CONSUMERS; i++)
			cons[i] = new Consumer(workingQueue,i+NUMBER_OF_PRODUSERS+1,2*AMOUNT);
		for(int i = 0; i<NUMBER_OF_PRODUSERS; i++)
			(new Thread(prod[i])).start();
		for(int i = 0; i<NUMBER_OF_CONSUMERS; i++)
			(new Thread(cons[i])).start();
	}
	public static boolean isQueueFull() {
		return workingQueue.size()>=BOUND;
	}
}
