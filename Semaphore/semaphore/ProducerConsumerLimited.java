package threads.semaphore;

//import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ProducerConsumerLimited {
    static Vector<String> buffer = new Vector<String>(5);
    
    // Semaphore maintains a set of permits.
    // Each acquire blocks if necessary until a permit is available, and then takes it.
    // Each release adds a permit, potentially releasing a blocking acquirer.
    static Semaphore fill = new Semaphore(0);
    static Semaphore empty = new Semaphore(5);
    static Semaphore mutex = new Semaphore(1);
    
    // I'll producing new Integer every time
    static class Producer extends Thread {
        public void run() {
            
            int counter = 1;
            try {
                while (true) {
                    String item = "item-" + counter++;
                    empty.acquire();
                    mutex.acquire();
                    buffer.add(item);
                    System.out.println("Producer put a new " + item);
                    mutex.release();
                    
                    // release lock
                    fill.release();
//                    Thread.sleep(500);
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
                    fill.acquire();
                    
                    // Acquires a permit from this semaphore, blocking until one is available
                    mutex.acquire();
                    String result = buffer.remove(buffer.size()-1);
                    System.out.println(consumerName + " got " + result + " buffer size: "
                            + buffer.size() + "\n");
                    mutex.release();
                    empty.release();
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