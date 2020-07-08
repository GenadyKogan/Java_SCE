package threads.listeners;

//one thread - many different listeners
public class TestManyOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cat c = new Cat("Max");
				
		Observer o = new Owner();
		Observer v = new Vet();
		
		c.addListener(o);
		c.addListener(v);
		c.start();
		
	}

}
