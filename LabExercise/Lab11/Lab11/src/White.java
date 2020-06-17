import java.util.Random;

public class White extends Thread implements Horse {

	private int distanceLeft;
	private Random rnd;

	public White(int number, int distance) {

		super("White " + number);
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
