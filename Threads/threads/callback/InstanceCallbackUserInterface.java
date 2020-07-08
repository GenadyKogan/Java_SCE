package threads.callback;


public class InstanceCallbackUserInterface {
  
  public void receiveResponse(long time, String name) {
  
    StringBuffer result = new StringBuffer(name);
    result.append(" slept ");
    result.append(time);
    System.out.println(result);
      
  }
  
  public static void main(String[] args) {
  
	  System.out.println("We have "+args.length+" cats at home");
	  InstanceCallbackLifeCycle[] c = new InstanceCallbackLifeCycle[args.length];
	  InstanceCallbackUserInterface inter = new InstanceCallbackUserInterface();
	  for (int i = 0; i < args.length; i++) {
		  //Calculate the digest
		  c[i] = new InstanceCallbackLifeCycle(args[i], inter);
		  c[i].start( );
	  }
  }

}
