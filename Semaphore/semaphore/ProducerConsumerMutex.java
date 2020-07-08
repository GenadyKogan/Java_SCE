package threads.semaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ProducerConsumerMutex {
    static LinkedList<String> crunchifyList = new LinkedList<String>();
    
    // Semaphore maintains a set of permits.
    // Each acquire blocks if necessary until a permit is available, and then takes it.
    // Each release adds a permit, potentially releasing a blocking acquirer.
    static Semaphore semaphore = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    
    // I'll producing new Integer every time
    static class Producer extends Thread {
        public void run() {
            
            int counter = 1;
            try {
                while (true) {
                    String item = "item-" + counter++;
                    
                    mutex.acquire();
                    // critical section begins
                    crunchifyList.add(item);
                    System.out.println("Producer put a new " + item);
                    //critical section ends
                    mutex.release();
                    
                    // release lock, for consumer
                    semaphore.release();
//                    Thread.sleep(10);
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
    
    // I'll be consuming Integer every time
    static class Consumer extends Thread {
        String consumerName;
        
        public Consumer(String name) {
            this.consumerName = name;
        }
        
        public void run() {
            try {
                
                while (true) {
                    
                    // process stops here until producer releases the lock
                    semaphore.acquire();
                    
                    // Acquires a permit from this semaphore, blocking until one is available
                    mutex.acquire();
                    // Starting critical section
                    String result = crunchifyList.pollLast();
                    System.out.println(consumerName + " got an " + result + " buffer size: "
                            + crunchifyList.size() + "\n");
                    // Ending critical section
                    mutex.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Producer().start();
    	new Consumer("Crunchify").start();
        new Consumer("Google").start();
        new Consumer("Yahoo").start();
    }
}