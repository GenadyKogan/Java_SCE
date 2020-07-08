package threads.listeners;

public class Owner implements Observer{

	@Override
	public void notify(String msg) {
		System.out.println("+++++++++++++++++++");
		System.out.println("OWNER got a notification: "+msg);
		
		play();
		
	}

	private void play() {
		System.out.println("I am playing with my pet.");
		
	}

}
