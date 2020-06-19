public class HexaObserver extends Observer{

   private int prevState;
   
   public HexaObserver(Subject subject){
      this.subject = subject;
      this.prevState = subject.getState();
      this.subject.attach(this);
   }

   @Override
   public void update() {
	   if(prevState != subject.getState())
	   {
		   System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() ); 
		   prevState = subject.getState();
	   }
   }
}
