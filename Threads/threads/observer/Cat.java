package threads.observer;

import java.util.Observable;

public class Cat extends Observable implements Runnable{

	private String name;
//	Long time;
	
	public Cat(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		long time = (long)(Math.random()*1000L);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Got an exception");
			e.printStackTrace();
		}
		setChanged();
		notifyObservers(" is awake and hungry after "+time+" hours of sleeping");
		}
		
}

