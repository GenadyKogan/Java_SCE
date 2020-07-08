package threads.polling;

import threads.race.CatLifeCycle;


public class PollingUserInterface {

	public static void main(String[] args) {
		System.out.println("We have "+args.length+" cats at home");
		CatLifeCycle[] c = new CatLifeCycle[args.length];
		for (int i = 0; i < args.length; i++) {
			//run cats
			c[i] = new CatLifeCycle(args[i]);
			c[i].start( );
		}
		for (int i = 0; i < args.length; i++) {
			boolean sleeping = true;
			while (sleeping) {
				//Now print the result
				Long time = c[i].howLongDidYouSleep();
				System.out.println(time);
				if (time != null) {
					StringBuffer result = new StringBuffer(args[i]);
					result.append(" slept ");
					result.append(time);
					System.out.println(result.toString());
					System.out.flush();
					sleeping  = false;
//					break;
				}
			}
		}

	}

}
