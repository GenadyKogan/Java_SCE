
public class BinaryObserver extends Observer{
	 private int prevState;

	public BinaryObserver(Subject subject){
		 this.subject=subject;
		 this.prevState = subject.getState();
	     //this.subject.attach(this);
	 }

	@Override
	public void update() {
		if(prevState!=subject.getState()) {
			System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
			   prevState = subject.getState();
		}
		
	}
}
