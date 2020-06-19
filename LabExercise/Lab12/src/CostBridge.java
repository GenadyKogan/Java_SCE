import java.util.List;

public class CostBridge {
	public static float getCost(List<Item> items) {
		float cost=0.0f;
		for(Item item:items)
			cost+=item.price();
		return cost;
	}
}
