package threads.observer;

import java.util.Observer;

public class TestManyMany {

	public static void main(String[] args) {
		//create two listeners
		Observer o = new Owner();
		Observer v = new Vet();
		
		//create and run cats
		Cat[] c = new Cat[args.length];
		for(int i = 0; i<args.length; i++){
			c[i] = new Cat(args[i]);
			//add listeners to a cat
			c[i].addObserver(o);
			c[i].addObserver(v);
			new Thread(c[i]).start();
		}
	}

}
