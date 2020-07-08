package threads.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Crunchify.com
 * 
 */
 
public class JavaSemaphoreDemo {
    private static final int MAX_CONCURRENT_THREADS = 2;
    private final Semaphore LOCK = new Semaphore(MAX_CONCURRENT_THREADS, true);
    
    public void runDemo() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.start();
        }
    }
    
    public class Person extends Thread {
        @Override
        public void run() {
            try {
                // Acquire Lock
                LOCK.acquire();
            } catch (InterruptedException e) {
                System.out.println("received InterruptedException");
                return;
            }
            System.out.println("Thread " + this.getId() + " starts using the shared car - Acquire()");
            try {
                sleep(1000);
            } 
            catch (Exception e) {}       
            finally {
                // Release Lock
            	System.out.println("Thread " + this.getId() + " stops using the shared car -  Release()\n");
                LOCK.release();
            }
        }
    }
    
    public static void main(String[] args) {
        JavaSemaphoreDemo test = new JavaSemaphoreDemo();
        test.runDemo();      
    }
}
