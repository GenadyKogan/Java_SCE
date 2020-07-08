package threads.race;

public class CatLifeCycle extends Thread {
	
	private Long sleepTime;
	
	public CatLifeCycle(String name){
		super(name);
	}
	
	public void run(){
		long time = (long)(Math.random()*10000L);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Got an exception");
			e.printStackTrace();
		}
		sleepTime = time;
		System.out.println(getName()+" is awake! Meow!");
//		System.out.println(getName()+" slept "+time);
    }
  
    public Long howLongDidYouSleep() {
       return sleepTime;
    }

}
