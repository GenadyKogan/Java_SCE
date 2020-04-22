
public class RandomPlayer extends Player {
	public RandomPlayer(String name) { 
		super(name); 
		}

	@Override
	public Action selectAction(Action[] actions) {
		int index =(int)(Math.random()*actions.length);
		return actions[index];
	}  
}
