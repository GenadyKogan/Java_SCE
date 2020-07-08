package threads.listeners;

//one listener - many threads
public class TestOneMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create two listeners
		Observer l = new Owner();
		
		//create and run cats
		Cat[] c = new Cat[args.length];
		for(int i = 0; i<args.length; i++){
			c[i] = new Cat(args[i]);
			//add listeners to a cat
			c[i].addListener(l);
			c[i].start();
		}

	}

}
