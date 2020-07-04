public class Lion extends Animal {
	public int weight;
	public static int speed;
	public Lion(int weight, int speed) {
		super(weight, speed);
		
		this. weight = weight * 5;
		this.speed = speed + 20;
	}
	public void printWeight () {
		super. printWeight ();
		System.out.println("Lion’s weight: " + weight);
	}
	public static void printSpeed() {
		System.out.println("Lion’s speed: " + speed);
	}
} //class Lion