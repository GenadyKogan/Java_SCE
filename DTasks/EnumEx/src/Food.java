
public class Food {
	public enum Dessert{IceCream,Cake,Cooki};
	public enum JunkFood{Pizza,Hamburger,Falafel};
	private Dessert theDessert;
	private JunkFood theJunkFood;
	public Food(Dessert theDessert,JunkFood theJunkFood) {
		this.theDessert=theDessert;
		this.theJunkFood=theJunkFood;
	}
	public String toString() {
		return "Dessert="+theDessert.name()+", Junk="+theJunkFood.name();
	}
}
