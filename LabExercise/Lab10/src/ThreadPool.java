import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPool {
	public static void main(String[] a) { 	
		final int COUNTER_VALUE = 7;
		final int NUMBER_OF_TASKS = 6;
		final int THREAD_POOL_NUM = 4;
		
		Executor executor = Executors.newFixedThreadPool (THREAD_POOL_NUM);// 4 thread in same time
		
		for(int i=0; i<NUMBER_OF_TASKS; i++)
			executor.execute (new CountDown(i+1,COUNTER_VALUE));
		
		((ExecutorService) executor).shutdown(); 
		
		while(!((ExecutorService) executor).isTerminated()){
			 try {
				Thread.sleep(50);
				
			 } catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		
		System.out.println("End of work");
		
	}
	
}
