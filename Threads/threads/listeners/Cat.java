package threads.listeners;

import java.util.Vector;

public class Cat extends Thread {
	
	//vector is synchronized
	private Vector<Observer> list = new Vector<Observer>();
	
	public Cat(String name){
		super(name); 
	}
	
	public void addListener(Observer l){list.add(l);}
	
	public synchronized void removeListener(Observer l) {
		int index = list.indexOf(l);
		list.set(index, list.lastElement());
		list.remove(list.size()-1);
	}
	
	public void run(){
//		notifyListeners(" is going to sleep");
		long time = (long)(Math.random()*1000L);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Got an exception");
			e.printStackTrace();
		}
		notifyListeners(" is awake and hungry after "+time+" hours of sleeping");
	}
	
	private void notifyListeners(String msg){
		for (Observer l : list) {
			l.notify(getName()+msg);
		}
	}

}
