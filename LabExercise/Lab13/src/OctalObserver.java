public class OctalObserver extends Observer{

   private int prevState;

   public OctalObserver(Subject subject){
      this.subject = subject;
      this.prevState = subject.getState();
     // this.subject.attach(this);
   }

   @Override
   public void update() {
	   if(prevState != subject.getState())
	   {
		   System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
		   prevState = subject.getState();
	   }
   }
}
