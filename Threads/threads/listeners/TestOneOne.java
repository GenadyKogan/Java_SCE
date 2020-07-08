package threads.listeners;


public class TestOneOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cat c = new Cat("Max");
		Observer l = new Owner();
		
		c.addListener(l);
		c.start();

	}

}
