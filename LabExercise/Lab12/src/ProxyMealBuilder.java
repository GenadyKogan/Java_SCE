
public class ProxyMealBuilder {
	private MealBuilder bid;
	public ProxyMealBuilder() {
		bid=new MealBuilder();
	}
	public Meal prepareVegMeal() {
		return bid.prepareNonVegMeal();
	}
	public Meal prepareNonVegMeal() {
		return bid.prepareNonVegMeal();
	}
	
}
