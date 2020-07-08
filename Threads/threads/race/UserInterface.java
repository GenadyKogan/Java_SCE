package threads.race;

public class UserInterface {
	
	public static void runAndCare(String[] args) {
		  System.out.println("We have "+args.length+" cats at home");
		  CatLifeCycle[] c = new CatLifeCycle[args.length];
		  StringBuffer result = null;
		  for (int i = 0; i < args.length; i++) {
			  //start cat's lifecycle
			  c[i] = new CatLifeCycle(args[i]);
			  c[i].start( );
			  // Now print the result
			  result = new StringBuffer(args[i]);
			  result.append(" slept ");
			  result.append(c[i].howLongDidYouSleep().doubleValue());
			  System.out.println(result.toString());
		  }
	  }
	
	public static void runAndWaitAndCare(String[] args) {
		System.out.println("We have "+args.length+" cats at home");
		CatLifeCycle[] c = new CatLifeCycle[args.length];
		for (int i = 0; i < args.length; i++) {
			//start cat's lifecycle
			c[i] = new CatLifeCycle(args[i]);
			c[i].start( );
		}
		
		//wait
		for(int i=0; i<=10000000; i++);
		
		StringBuffer result = null;
		for (int i = 0; i < args.length; i++) {
			// Now print the result
			result = new StringBuffer(args[i]);
			result.append(" slept ");
			result.append(c[i].howLongDidYouSleep().doubleValue());
			System.out.println(result.toString());
		}
	}

	public static void main(String[] args) {
//		runAndCare(args);
		runAndWaitAndCare(args);
	}

}
