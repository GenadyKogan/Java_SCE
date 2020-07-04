
public class Animal {
	public final int weight;
	public static int speed;
	public Animal(int weight, int speed) {
		this.weight = weight;
		this.speed = speed;
	}
	public void printWeight() {
		System.out.println("Animal’s weight: " + weight);
	}
	public static void printSpeed() {
		System.out.println("Animal’s speed: " + speed);
}
} //class Animal