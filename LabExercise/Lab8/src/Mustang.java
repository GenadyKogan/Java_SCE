import java.util.Random;
import java.util.concurrent.SynchronousQueue;
public class Mustang extends Thread implements Horse {
	private int distanceLeft;
	private Random rnd;
	public Mustang(int number, int distance) {

		super("Mustang "+number);
		this.distanceLeft = distance;
		rnd = new Random();
	}
	public void run() {
		while(distanceLeft>0) {
			distanceLeft-=rnd.nextInt(5);
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				System.out.println(getName()+" stopped");
				return;
			}
		}
	}
	@Override
	public int getDistance() {
		
		return distanceLeft;
	}
}
