package threads.observer;

import java.util.Observable;
import java.util.Observer;

public class Owner implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("+++++++++++++++++++");
		System.out.println("OWNER got a notification: "+(String)arg);
		
		play();
		
	}

	private void play() {
		System.out.println("I am playing with my pet.");
		
	}


}
