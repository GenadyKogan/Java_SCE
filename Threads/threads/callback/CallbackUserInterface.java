package threads.callback;


public class CallbackUserInterface {
  
  public static void receiveResponse(long time, String name) {
  
    StringBuffer result = new StringBuffer(name);
    result.append(" slept ");
    result.append(time);
    System.out.println(result);
      
  }
  
  public static void main(String[] args) {
  
	  System.out.println("We have "+args.length+" cats at home");
	  CallbackLifeCycle[] c = new CallbackLifeCycle[args.length];
	  for (int i = 0; i < args.length; i++) {
		  c[i] = new CallbackLifeCycle(args[i]);
		  c[i].start( );
	  }
  }

}
