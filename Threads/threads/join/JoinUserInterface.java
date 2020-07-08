package threads.join;

import java.io.*;

import threads.race.CatLifeCycle;

public class JoinUserInterface {
  
  public static void main(String[] args) {

	  	System.out.println("We have "+args.length+" cats at home");
		CatLifeCycle[] c = new CatLifeCycle[args.length];
		for (int i = 0; i < args.length; i++) {
			//run cats
			c[i] = new CatLifeCycle(args[i]);
			c[i].start( );
		}
  
		for (int i = 0; i < args.length; i++) {
			try {      
		        c[i].join();
		        // Now print the result
		        StringBuffer result = new StringBuffer(args[i]);
				result.append(" slept ");
				result.append(c[i].howLongDidYouSleep());
				System.out.println(result.toString());
	      }
	      catch (InterruptedException ex) {
	    	  System.err.println("Thread Interrupted before completion");
	      } 
    }     
  
  }

}
