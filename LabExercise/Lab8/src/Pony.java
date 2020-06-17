import java.util.Random;

public class Pony extends Thread implements Horse{

	private int distanceLeft;
	private Random rnd;

	public Pony(int number, int distance) {

		super("Pony "+number);
		this.distanceLeft = distance;
		rnd = new Random();
	}

	public void run() {

		while (distanceLeft > 0) {
			distanceLeft -= rnd.nextInt(5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(getName()+" stopped");
				return;
			}
		}
	}

	 public int getDistance() {

		return distanceLeft;

	}
}
