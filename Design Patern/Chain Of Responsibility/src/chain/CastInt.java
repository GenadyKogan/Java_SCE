package chain;

public class CastInt extends CastChain{

	
	public CastInt(CastChain next) {
		super(next);
	}

	@Override
	public Object cast(Package value) {
		try {
			return Integer.parseInt(value.getValue());
		}
		catch(NumberFormatException e) {
			if (next!=null) return next.cast(value);
			return null;
		}
	}

}
