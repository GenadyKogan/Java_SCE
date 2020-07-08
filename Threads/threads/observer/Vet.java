package threads.observer;

import java.util.Observable;
import java.util.Observer;

public class Vet implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("************************");
		System.out.println("VET got a play request: "+(String)arg);
		
		checkup();

	}

	private void checkup() {
		System.out.println("The pet is healthy");
		

	}

}
