package threads.listeners;

public class Vet implements Observer {

	@Override
	public void notify(String msg) {
		System.out.println("************************");
		System.out.println("VET got a play request: "+msg);
		
		checkup();

	}

	private void checkup() {
		System.out.println("The pet is healthy");
		
	}

}
